/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/pages/entity/EditPage.e.vm.java
 */
package com.ankushn.demo.web.selenium.page.account;

import com.ankushn.demo.web.selenium.support.Page;
import com.ankushn.demo.web.selenium.support.elements.Checkbox;
import com.ankushn.demo.web.selenium.support.elements.CustomWebElement;
import com.ankushn.demo.web.selenium.support.elements.DateInput;
import com.ankushn.demo.web.selenium.support.elements.EditAction;
import com.ankushn.demo.web.selenium.support.elements.EntityAction;
import com.ankushn.demo.web.selenium.support.elements.Messages;
import com.ankushn.demo.web.selenium.support.elements.NoInverseManyToOne;
import com.ankushn.demo.web.selenium.support.elements.StringInput;
import com.ankushn.demo.web.selenium.support.elements.Tab;

@Page
public class AccountEdit {
    public EditAction action;
    public Messages messages;
    public EntityAction entity;
    public AccountEditForm form;
    public AccountEditTabs tabs;

    public static class AccountEditForm extends CustomWebElement {
        public StringInput login = new StringInput("form:login");
        public StringInput password = new StringInput("form:password");
        public StringInput email = new StringInput("form:email");
        public Checkbox isEnabled = new Checkbox("form:isEnabled");
        public StringInput civility = new StringInput("form:civility");
        public StringInput firstName = new StringInput("form:firstName");
        public StringInput lastName = new StringInput("form:lastName");
        public DateInput birthDate = new DateInput("form:birthDate");
        public StringInput description = new StringInput("form:description");

        public NoInverseManyToOne address = new NoInverseManyToOne("form:address");
    };

    public static class AccountEditTabs extends CustomWebElement {
        public Tab roles = new Tab("role", "roles");
    };
}