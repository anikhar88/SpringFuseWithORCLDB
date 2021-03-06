/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package com.ankushn.demo.repository;

import java.util.Date;

import javax.inject.Named;
import javax.inject.Singleton;

import com.ankushn.demo.domain.Dbuser;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class DbuserGenerator {

    /**
     * Returns a new Dbuser instance filled with random values.
     */
    public Dbuser getDbuser() {
        Dbuser dbuser = new Dbuser();

        // simple attributes follows
        dbuser.setUsername("a");
        dbuser.setCreatedBy("a");
        dbuser.setCreatedDate(new Date());
        return dbuser;
    }

}