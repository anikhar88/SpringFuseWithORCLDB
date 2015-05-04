/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/support/GenericEditForm.p.vm.java
 */
package com.ankushn.demo.web.domain.support;

import static com.ankushn.demo.web.conversation.ConversationHolder.getCurrentConversation;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;

import org.apache.commons.lang.WordUtils;

import com.ankushn.demo.domain.Identifiable;
import com.ankushn.demo.printer.support.TypeAwarePrinter;
import com.ankushn.demo.repository.support.EntityGraphLoader;
import com.ankushn.demo.repository.support.GenericRepository;
import com.ankushn.demo.repository.support.JpaUniqueUtil;
import com.ankushn.demo.repository.support.RepositoryLocator;
import com.ankushn.demo.util.ResourcesUtil;
import com.ankushn.demo.web.conversation.ConversationCallBack;
import com.ankushn.demo.web.conversation.ConversationContext;
import com.ankushn.demo.web.util.MessageUtil;
import com.ankushn.demo.web.util.TabBean;

/**
 * Base Edit Form for JPA entities.
 */
public abstract class GenericEditForm<E extends Identifiable<PK>, PK extends Serializable> extends CommonAction<E> {
    private E entity;

    @Inject
    protected JpaUniqueUtil jpaUniqueUtil;
    @Inject
    protected MessageUtil messageUtil;
    @Inject
    protected TypeAwarePrinter printer;
    @Inject
    protected ResourcesUtil resourcesUtil;
    @Inject
    protected RepositoryLocator repositoryLocator;

    protected GenericRepository<E, PK> repository;
    protected EntityGraphLoader<E, PK> entityGraphLoader;

    public GenericEditForm(GenericRepository<E, PK> repository) {
        this.repository = repository;
    }

    public GenericEditForm(GenericRepository<E, PK> repository, EntityGraphLoader<E, PK> entityGraphLoader) {
        this.repository = repository;
        this.entityGraphLoader = entityGraphLoader;
    }

    /**
     * Retrieves the entity var from the current ConversationContext and
     * depending on the case merge the entity and load its graph. 
     */
    @PostConstruct
    protected void init() {
        if (context().getEntity() == null) {
            throw new IllegalStateException("Could not find any entity. Please fix me");
        }

        if (context().isNewEntity()) {
            // no need to merge anything since it is a brand new entity, not yet persisted.
            entity = context().getEntity();
        } else if (context().isSub()) {
            // entity is persistent and we are in sub mode (not the root edit page of the graph)
            if (entityGraphLoader != null) {
                try {
                    // we load the associations to avoid lazylily access exception.
                    // note: this is a readonly merge (nothing is flushed)
                    entity = entityGraphLoader.merge(context().getEntity());
                } catch (OptimisticLockException e) {
                    getCurrentConversation().setNextContext(newConcurrentModificationContext());
                    throw e; // Please see ExceptionInRenderPhaseListener
                }
            } else {
                // we can use the entity as is, it does not have any association
                // or they are eargly loaded.
                // TODO: probably a repository.readonlyMerge(context().getEntity()); to be consistent
                // ==> AGAIN this demonstration IMO that we do not need a separated service...                    
                entity = context().getEntity();
            }
        } else {
            // entity is persistent and we are in the root edit page.
            if (entityGraphLoader != null) {
                entity = entityGraphLoader.getById(context().getEntity().getId());
            } else {
                // we can use the entity as is, it does not have any association
                // or they are eargly loaded.
                // TODO: probably a repository.readonlyMerge(context().getEntity()); to be consistent
                // ==> AGAIN this demonstration IMO that we do not need a separated service...                  
                entity = context().getEntity();
            }
        }

        if (entity == null) {
            throw new IllegalStateException("Could not find any entity, after init! Was it deleted?");
        }
    }

    protected ConversationCallBack<E> onOptimisticLockCallBack = new ConversationCallBack<E>() {
        private static final long serialVersionUID = 1L;

        @Override
        protected void onOk(E entity) {
            ConversationContext<E> context = getCurrentConversation().nextContext();
            Identifiable<PK> previousEntity = context.getEntity();
            E refreshedEntity = repository.getById(previousEntity.getId());
            context.setEntity(refreshedEntity);
            init();
        }
    };

    protected ConversationContext<E> newConcurrentModificationContext() {
        ConversationContext<E> ctx = new ConversationContext<E>();
        ctx.setEntity(context().getEntity());
        ctx.setViewUri("/concurrentModificationResolution.faces");
        ctx.setCallBack(onOptimisticLockCallBack);
        return ctx;
    }

    /**
     * Return the entity that this edit form backs.
     */
    public E getEntity() {
        return entity;
    }

    /**
     * Return the TabBean used by this form or <code>null</code> if this form
     * does not use any tab.
     */
    public TabBean getTabBean() {
        return null; // leave it null by default as the view checks for null.
    }

    // ------------------------------------
    // Actions
    // ------------------------------------

    /**
     * Ok action is used from sub page (non-readonly) to send the data without saving it. 
     * It is expected to be ajax since we want to display the errors, if any,
     * without refreshing the page.
     */
    public String ok() {
        return context().getCallBack().ok(getEntity());
    }

    /**
     * Close the current edit page, without any dirty data checking.
     */
    public String forceClose() {
        getCurrentConversation().getCurrentContext().clearDependentEntities();
        return context().getCallBack().notSaved(getEntity());
    }

    /**
     * deleteAndClose action is used form modal dialogs in the main edit page.
     */
    public String deleteAndClose() {
        repository.delete(getEntity());
        messageUtil.infoEntity("status_deleted_ok", getEntity());
        return context().getCallBack().deleted(getEntity());
    }

    /**
     * Save action. Used from main edit page. Expected to be an ajax request.
     */
    public String saveAndClose() {
        try {
            if (saveAndCloseInternal(getEntity())) {
                return context().getCallBack().saved(getEntity());
            }

            return null; // stay on the same page, errors will be displayed.
        } catch (OptimisticLockException e) {
            getCurrentConversation().nextContext(newConcurrentModificationContext());
            return getCurrentConversation().nextView();
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected boolean saveAndCloseInternal(E entity) {
        if (!validate(entity)) {
            return false;
        }

        this.entity = saveEntity(entity);
        Set<Identifiable<? extends Serializable>> dependentEntities = getCurrentConversation().getCurrentContext().getDependentEntities();
        for (Identifiable<? extends Serializable> dependentEntity : dependentEntities) {
            repositoryLocator.getRepository(dependentEntity).merge((Identifiable) dependentEntity);
        }

        if (context().isNewEntity()) {
            // if for some reason, save is invoked again, no need to persist anymore.
            context().setIsNewEntity(false);
        }

        messageUtil.infoEntity("status_saved_ok", this.entity);
        return true;
    }

    /**
     * Note: merge work also on new entity (actually it works better with many to many association)
     * we replace current entity with the merged one so the callback receive the merged one.
     */
    protected E saveEntity(E entity) {
        return repository.merge(entity);
    }

    public boolean validate(E entity) {
        List<String> errors = jpaUniqueUtil.validateUniques(entity);
        for (String error : errors) {
            messageUtil.error(error);
        }
        return errors.isEmpty();
    }

    protected String getLabelName() {
        return WordUtils.uncapitalize(repository.getType().getSimpleName());
    }

    public String getEditKey() {
        return getLabelName() + "_edit";
    }

    public String getViewKey() {
        return getLabelName() + "_view";
    }

    public String getCreateKey() {
        return getLabelName() + "_create";
    }

    public String getTitle() {
        String key = getEditKey();
        if (!getEntity().isIdSet()) {
            key = getCreateKey();
        } else if (getCurrentConversation().getCurrentContext().isReadOnly()) {
            key = getViewKey();
        }
        return resourcesUtil.getProperty(key, printer.print(entity));
    }
}