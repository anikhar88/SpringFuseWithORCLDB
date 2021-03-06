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
import static com.ankushn.demo.repository.support.Range.newRange;

import java.util.Date;

import javax.inject.Named;

import com.ankushn.demo.domain.Account;
import com.ankushn.demo.domain.Account_;
import com.ankushn.demo.domain.Address;
import com.ankushn.demo.domain.Role;
import com.ankushn.demo.repository.support.PropertySelector;
import com.ankushn.demo.repository.support.Range;
import com.ankushn.demo.repository.support.SearchParameters;
import com.ankushn.demo.web.domain.support.GenericSearchForm;
import com.ankushn.demo.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link Account}.
 * It exposes a {@link Account} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class AccountSearchForm extends GenericSearchForm<Account, String, AccountSearchForm> {
    private static final long serialVersionUID = 1L;
    protected Account account = new Account();
    protected Range<Account, Date> birthDateRange = newRange(Account_.birthDate);
    protected PropertySelector<Account, String> loginSelector = newPropertySelector(Account_.login);
    protected PropertySelector<Account, String> passwordSelector = newPropertySelector(Account_.password);
    protected PropertySelector<Account, String> emailSelector = newPropertySelector(Account_.email);
    protected PropertySelector<Account, Boolean> isEnabledSelector = newPropertySelector(Account_.isEnabled);
    protected PropertySelector<Account, String> civilitySelector = newPropertySelector(Account_.civility);
    protected PropertySelector<Account, String> firstNameSelector = newPropertySelector(Account_.firstName);
    protected PropertySelector<Account, String> lastNameSelector = newPropertySelector(Account_.lastName);
    protected PropertySelector<Account, String> descriptionSelector = newPropertySelector(Account_.description);
    protected PropertySelector<Account, Address> addressSelector = newPropertySelector(Account_.address);
    protected PropertySelector<Account, Role> rolesSelector = newPropertySelector(false, Account_.roles);

    public Account getAccount() {
        return account;
    }

    @Override
    protected Account getEntity() {
        return getAccount();
    }

    @Override
    public AccountSearchForm newInstance() {
        return new AccountSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.range(birthDateRange);
        sp.property(loginSelector, passwordSelector, emailSelector, isEnabledSelector, civilitySelector, firstNameSelector, lastNameSelector,
                descriptionSelector);
        sp.property(addressSelector);
        sp.property(rolesSelector);
        return sp;
    }

    @Override
    public void resetWithOther(AccountSearchForm other) {
        this.account = other.getAccount();
        this.birthDateRange = other.getBirthDateRange();
        this.loginSelector = other.getLoginSelector();
        this.passwordSelector = other.getPasswordSelector();
        this.emailSelector = other.getEmailSelector();
        this.isEnabledSelector = other.getIsEnabledSelector();
        this.civilitySelector = other.getCivilitySelector();
        this.firstNameSelector = other.getFirstNameSelector();
        this.lastNameSelector = other.getLastNameSelector();
        this.descriptionSelector = other.getDescriptionSelector();
        this.addressSelector = other.getAddressSelector();
        this.rolesSelector = other.getRolesSelector();
    }

    // Ranges
    public Range<Account, Date> getBirthDateRange() {
        return birthDateRange;
    }

    // Property selectors
    public PropertySelector<Account, String> getLoginSelector() {
        return loginSelector;
    }

    public PropertySelector<Account, String> getPasswordSelector() {
        return passwordSelector;
    }

    public PropertySelector<Account, String> getEmailSelector() {
        return emailSelector;
    }

    public PropertySelector<Account, Boolean> getIsEnabledSelector() {
        return isEnabledSelector;
    }

    public PropertySelector<Account, String> getCivilitySelector() {
        return civilitySelector;
    }

    public PropertySelector<Account, String> getFirstNameSelector() {
        return firstNameSelector;
    }

    public PropertySelector<Account, String> getLastNameSelector() {
        return lastNameSelector;
    }

    public PropertySelector<Account, String> getDescriptionSelector() {
        return descriptionSelector;
    }

    // Relation selectors
    public PropertySelector<Account, Address> getAddressSelector() {
        return addressSelector;
    }

    // Relation selectors
    public PropertySelector<Account, Role> getRolesSelector() {
        return rolesSelector;
    }
}
