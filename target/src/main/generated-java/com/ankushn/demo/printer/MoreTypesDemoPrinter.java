/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/printer/Printer.e.vm.java
 */
package com.ankushn.demo.printer;

import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import com.ankushn.demo.domain.MoreTypesDemo;
import com.ankushn.demo.domain.MoreTypesDemo_;
import com.ankushn.demo.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link MoreTypesDemo} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class MoreTypesDemoPrinter extends GenericPrinter<MoreTypesDemo> {
    public MoreTypesDemoPrinter() {
        super(MoreTypesDemo.class, MoreTypesDemo_.numberInt, MoreTypesDemo_.numberLong, MoreTypesDemo_.numberDouble);
    }

    @Override
    public String print(MoreTypesDemo moreTypesDemo, Locale locale) {
        if (moreTypesDemo == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, moreTypesDemo.getNumberInt());
        appendIfNotEmpty(ret, moreTypesDemo.getNumberLong());
        appendIfNotEmpty(ret, moreTypesDemo.getNumberDouble());
        return ret.toString();
    }
}