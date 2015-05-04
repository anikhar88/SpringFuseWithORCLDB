/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.ankushn.demo.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import com.ankushn.demo.domain.Account;
import com.ankushn.demo.repository.AccountRepository;
import com.ankushn.demo.web.domain.support.GenericLazyDataModel;
import com.ankushn.demo.web.faces.ConversationContextScoped;

/**
 * Provide PrimeFaces {@link LazyDataModel} for {@link Account}
 */
@Named
@ConversationContextScoped
public class AccountLazyDataModel extends GenericLazyDataModel<Account, String, AccountSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    public AccountLazyDataModel(AccountRepository accountRepository, AccountController accountController, AccountSearchForm accountSearchForm,
            AccountExcelExporter accountExcelExporter) {
        super(accountRepository, accountController, accountSearchForm, accountExcelExporter);
    }
}