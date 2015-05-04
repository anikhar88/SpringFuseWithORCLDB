/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/RepositoryIT.e.vm.java
 */
package com.ankushn.demo.repository;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ankushn.demo.domain.MoreTypesDemo;

/**
 * Integration test on MoreTypesDemoRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class MoreTypesDemoRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(MoreTypesDemoRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private MoreTypesDemoRepository moreTypesDemoRepository;

    @Inject
    private MoreTypesDemoGenerator moreTypesDemoGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        MoreTypesDemo moreTypesDemo = moreTypesDemoGenerator.getMoreTypesDemo();

        // add it to a Set before saving (force equals/hashcode)
        Set<MoreTypesDemo> set = newHashSet(moreTypesDemo, moreTypesDemo);
        assertThat(set).hasSize(1);

        moreTypesDemoRepository.save(moreTypesDemo);
        entityManager.flush();

        // reload it from cache and check equality
        MoreTypesDemo model = new MoreTypesDemo();
        model.setId(moreTypesDemo.getId());
        assertThat(moreTypesDemo).isEqualTo(moreTypesDemoRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(moreTypesDemo.getId()).isEqualTo(moreTypesDemoRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(moreTypesDemo).isNotEqualTo(moreTypesDemoRepository.get(model));
    }

}