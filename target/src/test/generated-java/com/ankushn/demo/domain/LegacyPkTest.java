/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/domain/CompositePkTest.cpk.vm.java
 */
package com.ankushn.demo.domain;

import com.ankushn.demo.util.ValueGenerator;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

/**
 * Basic tests for LegacyPk
 */
public class LegacyPkTest {
    @Test
    public void compositePrimaryKeycode_test1() {
        LegacyPk cpk = new LegacyPk();
        assertThat(cpk.isCodeSet()).isFalse();
        assertThat(cpk.getCode()).isNull();
        assertThat(cpk.isEmpty()).isTrue();
    }

    @Test
    public void compositePrimaryKeycode_test2() {
        LegacyPk cpk = new LegacyPk().code(ValueGenerator.getUniqueString(8));

        assertThat(cpk.isCodeSet()).isTrue();
        assertThat(cpk.getCode()).isNotNull();
        assertThat(cpk.isEmpty()).isFalse();
    }

    @Test
    public void compositePrimaryKeydept_test1() {
        LegacyPk cpk = new LegacyPk();
        assertThat(cpk.isDeptSet()).isFalse();
        assertThat(cpk.getDept()).isNull();
        assertThat(cpk.isEmpty()).isTrue();
    }

    @Test
    public void compositePrimaryKeydept_test2() {
        LegacyPk cpk = new LegacyPk().dept(ValueGenerator.getUniqueInteger());

        assertThat(cpk.isDeptSet()).isTrue();
        assertThat(cpk.getDept()).isNotNull();
        assertThat(cpk.isEmpty()).isFalse();
    }

    @Test
    public void compositePrimaryKeyname_test1() {
        LegacyPk cpk = new LegacyPk();
        assertThat(cpk.isNameSet()).isFalse();
        assertThat(cpk.getName()).isNull();
        assertThat(cpk.isEmpty()).isTrue();
    }

    @Test
    public void compositePrimaryKeyname_test2() {
        LegacyPk cpk = new LegacyPk().name(ValueGenerator.getUniqueString(16));

        assertThat(cpk.isNameSet()).isTrue();
        assertThat(cpk.getName()).isNotNull();
        assertThat(cpk.isEmpty()).isFalse();
    }

    @Test
    public void isEmptyTrue() {
        LegacyPk cpk = new LegacyPk();
        assertThat(cpk.isEmpty()).isTrue();
    }

    @Test
    public void isEmptyFalse() {
        LegacyPk cpk = new LegacyPk();
        cpk.setCode(ValueGenerator.getUniqueString(8));
        cpk.setDept(ValueGenerator.getUniqueInteger());
        cpk.setName(ValueGenerator.getUniqueString(16));
        assertThat(cpk.isEmpty()).isFalse();
    }

    @Test
    public void toStringNotNullWhenNew() {
        LegacyPk cpk = new LegacyPk();
        assertThat(cpk.toString()).isNotNull();
    }

    @Test
    public void toStringHasLength() {
        LegacyPk cpk = new LegacyPk();
        cpk.setCode(ValueGenerator.getUniqueString(8));
        cpk.setDept(ValueGenerator.getUniqueInteger());
        cpk.setName(ValueGenerator.getUniqueString(16));
        assertThat(cpk.toString()).isNotNull();
        assertThat(cpk.toString().isEmpty()).isFalse();
    }

    @Test
    public void equality_test1() {
        LegacyPk cpk = new LegacyPk();
        assertThat(cpk).isEqualTo(cpk);
        assertThat(cpk.hashCode()).isEqualTo(cpk.hashCode());
        assertThat(cpk.compareTo(cpk)).isZero();
    }

    @Test
    public void equality_test2() {
        LegacyPk cpk = new LegacyPk();
        assertThat(cpk.equals(null)).isFalse();
        assertThat(cpk.compareTo(null)).isEqualTo(-1);
    }

    @Test
    public void equality_test3() {
        LegacyPk cpk1 = new LegacyPk();
        LegacyPk cpk2 = new LegacyPk();

        String code = ValueGenerator.getUniqueString(8);
        cpk1.setCode(code);
        cpk2.setCode(code);

        Integer dept = ValueGenerator.getUniqueInteger();
        cpk1.setDept(dept);
        cpk2.setDept(dept);

        String name = ValueGenerator.getUniqueString(16);
        cpk1.setName(name);
        cpk2.setName(name);

        assertThat(cpk1.hashCode()).isEqualTo(cpk2.hashCode());
        assertThat(cpk1.equals(cpk2)).isTrue();
        assertThat(cpk2.equals(cpk1)).isTrue();
        assertThat(cpk1.compareTo(cpk2)).isZero();
        assertThat(cpk2.compareTo(cpk1)).isZero();
    }
}