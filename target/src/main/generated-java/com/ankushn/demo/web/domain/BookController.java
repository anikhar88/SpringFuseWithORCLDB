/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/Controller.e.vm.java
 */
package com.ankushn.demo.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.ankushn.demo.domain.Book;
import com.ankushn.demo.printer.BookPrinter;
import com.ankushn.demo.repository.BookRepository;
import com.ankushn.demo.web.domain.support.GenericController;
import com.ankushn.demo.web.permission.BookPermission;

/**
 * Stateless controller for {@link Book} conversation start.
 */
@Named
@Singleton
public class BookController extends GenericController<Book, Integer> {
    public static final String BOOK_EDIT_URI = "/domain/bookEdit.faces";
    public static final String BOOK_SELECT_URI = "/domain/bookSelect.faces";

    @Inject
    public BookController(BookRepository bookRepository, BookPermission bookPermission, BookPrinter bookPrinter) {
        super(bookRepository, bookPermission, bookPrinter, BOOK_SELECT_URI, BOOK_EDIT_URI);
    }
}