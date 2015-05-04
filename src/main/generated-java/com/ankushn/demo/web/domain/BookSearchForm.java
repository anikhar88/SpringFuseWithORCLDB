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

import javax.inject.Named;

import com.ankushn.demo.domain.Account;
import com.ankushn.demo.domain.Book;
import com.ankushn.demo.domain.Book_;
import com.ankushn.demo.repository.support.PropertySelector;
import com.ankushn.demo.repository.support.Range;
import com.ankushn.demo.repository.support.SearchParameters;
import com.ankushn.demo.web.domain.support.GenericSearchForm;
import com.ankushn.demo.web.faces.ConversationContextScoped;

/**
 * View Helper to search {@link Book}.
 * It exposes a {@link Book} instance so it can be used in search by-example-query.
 */
@Named
@ConversationContextScoped
public class BookSearchForm extends GenericSearchForm<Book, Integer, BookSearchForm> {
    private static final long serialVersionUID = 1L;
    protected Book book = new Book();
    protected Range<Book, Integer> numberOfPagesRange = newRange(Book_.numberOfPages);
    protected PropertySelector<Book, String> titleSelector = newPropertySelector(Book_.title);
    protected PropertySelector<Book, Integer> numberOfPagesSelector = newPropertySelector(Book_.numberOfPages);
    protected PropertySelector<Book, Account> accountSelector = newPropertySelector(Book_.account);

    public Book getBook() {
        return book;
    }

    @Override
    protected Book getEntity() {
        return getBook();
    }

    @Override
    public BookSearchForm newInstance() {
        return new BookSearchForm();
    }

    @Override
    public SearchParameters toSearchParameters() {
        SearchParameters sp = searchParameters();
        sp.range(numberOfPagesRange);
        sp.property(titleSelector, numberOfPagesSelector);
        sp.property(accountSelector);
        return sp;
    }

    @Override
    public void resetWithOther(BookSearchForm other) {
        this.book = other.getBook();
        this.numberOfPagesRange = other.getNumberOfPagesRange();
        this.titleSelector = other.getTitleSelector();
        this.numberOfPagesSelector = other.getNumberOfPagesSelector();
        this.accountSelector = other.getAccountSelector();
    }

    // Ranges
    public Range<Book, Integer> getNumberOfPagesRange() {
        return numberOfPagesRange;
    }

    // Property selectors
    public PropertySelector<Book, String> getTitleSelector() {
        return titleSelector;
    }

    public PropertySelector<Book, Integer> getNumberOfPagesSelector() {
        return numberOfPagesSelector;
    }

    // Relation selectors
    public PropertySelector<Book, Account> getAccountSelector() {
        return accountSelector;
    }
}
