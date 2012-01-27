package com.yell.sso;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.japybara.WebTestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

public class SSOHelperTest extends WebTestCase {
    public void setUpWebDriver() {
        HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_8);
        htmlUnitDriver.setJavascriptEnabled(false);
        setDriver(htmlUnitDriver);
    }

    @Test
    public void shouldLogin() throws IOException {
        visit("/hello.do");
        assertFalse("Did not redirect to SSO login page", getContent().contains("Hello"));

        fillIn("Login", "labs");
        fillIn("Contraseña", "gandra");
        WebElement btn = getDriver().findElement(By.className(("btEntrar")));
        btn.click();

        assertHasContent("Hello");
    }
}
