/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 */
package com.ankushn.demo.web.domain;

import static com.ankushn.demo.repository.support.PropertySelector.newPropertySelector;

import javax.inject.Named;

import com.ankushn.demo.domain.Role;
import com.ankushn.demo.domain.Role_;
import com.ankushn.demo.repository.support.PropertySelector;
import com.ankushn.demo.repository.support.SearchParameters;
import com.ankushn.demo.web.domain.support.GenericSearchForm;
import com.ankushn.demo.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link Role}.
 * It exposes a {@link Role} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class RoleSearchForm extends GenericSearchForm<Role, Integer, RoleSearchForm> {
    private static final long serialVersionUID = 1L;
    protected Role role = new Role();
    protected PropertySelector<Role, String> roleNameSelector = newPropertySelector(Role_.roleName);

    public Role getRole() {
        return role;
    }

    @Override
    protected Role getEntity() {
        return getRole();
    }

    @Override
    public RoleSearchForm newInstance() {
        return new RoleSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.property(roleNameSelector);
        return sp;
    }

    @Override
    public void resetWithOther(RoleSearchForm other) {
        this.role = other.getRole();
        this.roleNameSelector = other.getRoleNameSelector();
    }

    // Property selectors
    public PropertySelector<Role, String> getRoleNameSelector() {
        return roleNameSelector;
    }
}
