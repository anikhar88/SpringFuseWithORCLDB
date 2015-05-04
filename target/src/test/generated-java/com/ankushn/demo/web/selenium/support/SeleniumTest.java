/*
 * (c) Copyright 2005-2015 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-selenium-primefaces:src/test/java/selenium/support/SeleniumTest.p.vm.java
 */
package com.ankushn.demo.web.selenium.support;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.ankushn.demo.web.selenium.page.AnonymousHomePage;
import com.ankushn.demo.web.selenium.page.LoggedHomePage;
import com.ankushn.demo.web.selenium.page.LoginPage;

public abstract class SeleniumTest {
    protected WebClient webClient;
    protected LoginPage loginPage;
    protected AnonymousHomePage anonymousHomePage;
    protected LoggedHomePage loggedHomePage;
    protected static WebDriver webDriver;
    public static final String WEBDRIVER_PROPERTY = "selenium.webdriver";
    public static final String BASE_URL_PROPERTY = "selenium.baseurl";
    public static final String DEFAULT_BASE_URL = "http://localhost:8080/demo";

    @BeforeClass
    public static void setupBrowser() {
        webDriver = buildDriver();
        webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(new Dimension(1280, 1024));
    }

    private static WebDriver buildDriver() {
        String webDriverName = System.getProperty(WEBDRIVER_PROPERTY, BrowserDriver.Firefox.name());
        return BrowserDriver.valueOf(webDriverName).buildWebDriver();
    }

    protected String getBaseUrl() {
        return System.getProperty(BASE_URL_PROPERTY, DEFAULT_BASE_URL);
    }

    @Before
    public void setupTest() {
        webClient = new WebClient(webDriver, this);
        webDriver.manage().deleteAllCookies();
        webDriver.get(getBaseUrl());
    }

    @AfterClass
    public static void closeBrowser() {
        webDriver.close();
        webDriver.quit();
    }

    public void page(String relative) {
        webClient.step("Requesting url " + relative);
        webDriver.get(getBaseUrl() + relative);
    }

    protected void englishHomePage() {
        page("/home.faces?locale=en");
        webClient.waitUntilTextIsPresent("Please login first in order to access the application content.");
    }

    protected void loginAsAnAdmin() {
        webClient.step("Login as admin");
        anonymousHomePage.connexion();
        loginPage.login("admin", "admin");
        webClient.waitUntilTextIsPresent("Congratulations admin, you are logged");
    }

    protected void logout() {
        webClient.step("Logout");
        loggedHomePage.logout();
        webClient.waitUntilTextIsPresent("Please login first in order to access the application content.");
    }
}
