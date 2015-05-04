/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/element/ListBox.p.vm.java
 */
package com.ankushn.demo.web.selenium.support.elements;

import static com.google.common.collect.Lists.newArrayList;
import static com.palominolabs.xpath.XPathUtils.getXPathString;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListBox extends ByCustomWebElement {
    private final String xPathId;

    public ListBox(String id) {
        super(id);
        this.xPathId = getXPathString(id);
    }

    private List<WebElement> getOptions() {
        String xpath = "//select[@id=" + xPathId + "]/option";
        return webClient.findAll(By.xpath(xpath));

    }

    public List<String> texts() {
        List<String> ret = newArrayList();
        for (WebElement webElement : getOptions()) {
            ret.add(webElement.getText());
        }
        return ret;
    }

    public List<String> selectedTexts() {
        List<String> ret = newArrayList();
        for (WebElement webElement : getOptions()) {
            if (webElement.isSelected()) {
                ret.add(webElement.getText());
            }
        }
        return ret;
    }

    public List<String> selectedValues() {
        List<String> ret = newArrayList();
        for (WebElement webElement : getOptions()) {
            if (webElement.isSelected()) {
                ret.add(webElement.getAttribute("value"));
            }
        }
        return ret;
    }

    public List<String> values() {
        List<String> ret = newArrayList();
        for (WebElement webElement : getOptions()) {
            ret.add(webElement.getAttribute("value"));
        }
        return ret;
    }

    public String selectedValue() {
        for (WebElement webElement : getOptions()) {
            if (webElement.isSelected()) {
                return webElement.getAttribute("value");
            }
        }
        return null;
    }

    public String selectedText() {
        for (WebElement webElement : getOptions()) {
            if (webElement.isSelected()) {
                return webElement.getText();
            }
        }
        return null;
    }

    public void text(String... texts) {
        for (String text : texts) {
            String xpath = "//select[@id=" + xPathId + "]/option[contains(text(), " + getXPathString(text) + ")]";
            webClient.click(By.xpath(xpath));
        }
    }

    public void value(String... values) {
        for (String value : values) {
            By xpath = By.xpath("//select[@id=" + xPathId + "]/option[contains(@value, " + getXPathString(value) + ")]");
            if (!webClient.find(xpath).isSelected()) {
                webClient.click(xpath);
            }
        }
    }

    public void selectAll() {
        for (WebElement webElement : getOptions()) {
            if (!webElement.isSelected()) {
                webClient.click(webElement);
            }
        }
    }

    public void unselectAll() {
        for (WebElement webElement : getOptions()) {
            if (webElement.isSelected()) {
                webClient.click(webElement);
            }
        }
    }
}
