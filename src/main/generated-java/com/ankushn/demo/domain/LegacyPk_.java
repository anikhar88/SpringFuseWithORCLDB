/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/domain/CompositePk_.cpk.vm.java
 */
package com.ankushn.demo.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(LegacyPk.class)
public abstract class LegacyPk_ {
    // pk attributes
    public static volatile SingularAttribute<LegacyPk, String> code;
    public static volatile SingularAttribute<LegacyPk, Integer> dept;
    public static volatile SingularAttribute<LegacyPk, String> name;
}
