/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/EditPage.e.vm.java
 */
package com.ankushn.demo.web.selenium.page.document;

import com.ankushn.demo.web.selenium.support.Page;
import com.ankushn.demo.web.selenium.support.elements.CustomWebElement;
import com.ankushn.demo.web.selenium.support.elements.EditAction;
import com.ankushn.demo.web.selenium.support.elements.EntityAction;
import com.ankushn.demo.web.selenium.support.elements.Messages;
import com.ankushn.demo.web.selenium.support.elements.NoInverseManyToOne;
import com.ankushn.demo.web.selenium.support.elements.Upload;

@Page
public class DocumentEdit {
    public EditAction action;
    public Messages messages;
    public EntityAction entity;
    public DocumentEditForm form;
    public DocumentEditTabs tabs;

    public static class DocumentEditForm extends CustomWebElement {
        public Upload documentBinary = new Upload("form:documentBinary");

        public NoInverseManyToOne account = new NoInverseManyToOne("form:account");
    };

    public static class DocumentEditTabs extends CustomWebElement {
    };
}