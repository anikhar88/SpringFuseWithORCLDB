/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/SaveSearch.p.vm.java
 */
package com.ankushn.demo.web.selenium.support.elements;

import static com.google.common.collect.Lists.newArrayList;
import static com.palominolabs.xpath.XPathUtils.getXPathString;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SaveSearch extends ByCustomWebElement {
    public SaveSearch(String id) {
        super(id);
    }

    public void save(String name) {
        webClient.fill(By.id(id + "_input"), name);
        webClient.click(By.id("form:saveSearch"));
        webClient.waitUntilTextIsPresent("Search criteria saved as " + name);
    }

    public void load(String name) {

    }

    public List<String> values() {
        System.out.println("click dropdown " + new Date());
        webClient.click(By.xpath("//span[@id=" + getXPathString(id) + "]/button/span[@class='ui-button-text']"));
        webClient.waitUntilDisplayed(By.id(id + "_panel"));
        System.out.println("--> ok is displayed autocomplete popup " + new Date());
        List<String> ret = newArrayList();
        String popup = "//div[@id=" + getXPathString(id + "_panel") + "]/ul/li";
        for (WebElement webElement : webClient.findAll(By.xpath(popup))) {
            ret.add(webElement.getText());
        }
        return ret;
    }
}
