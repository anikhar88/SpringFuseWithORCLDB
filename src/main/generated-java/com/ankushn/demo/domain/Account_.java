/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/domain/EntityMeta_.e.vm.java
 */
package com.ankushn.demo.domain;

import java.util.Date;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Account.class)
public abstract class Account_ {

    // Raw attributes
    public static volatile SingularAttribute<Account, String> id;
    public static volatile SingularAttribute<Account, String> login;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, Boolean> isEnabled;
    public static volatile SingularAttribute<Account, String> civility;
    public static volatile SingularAttribute<Account, String> firstName;
    public static volatile SingularAttribute<Account, String> lastName;
    public static volatile SingularAttribute<Account, Date> birthDate;
    public static volatile SingularAttribute<Account, String> description;
    public static volatile SingularAttribute<Account, Date> creationDate;
    public static volatile SingularAttribute<Account, String> creationAuthor;
    public static volatile SingularAttribute<Account, Date> lastModificationDate;
    public static volatile SingularAttribute<Account, String> lastModificationAuthor;
    public static volatile SingularAttribute<Account, Integer> version;

    // Many to one
    public static volatile SingularAttribute<Account, Address> address;

    // Many to many
    public static volatile ListAttribute<Account, Role> roles;
}