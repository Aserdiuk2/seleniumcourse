package com.qatestlab.utils;

import com.qatestlab.tests.SeleniumTests;
import com.qatestlab.utils.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    @BeforeClass
    public static WebDriver getDriver() {
        WebDriver driver;
        /*String browser = Properties.getBrowser();
        switch (browser) {
            case "firefox":
                System.setProperty(
                        "webdriver.gecko.driver",
                        new File(BaseTest.class.getResource("/geckodriver.exe").getFile()).getPath());
                driver = new FirefoxDriver();
            case "ie":
            case "internet explorer":
                System.setProperty(
                        "webdriver.ie.driver",
                        new File(BaseTest.class.getResource("/IEDriverServer.exe").getFile()).getPath());
                driver = new InternetExplorerDriver();
            /*case "chrome":
            default:*/
                System.setProperty(
                        "webdriver.chrome.driver",
                        new File(SeleniumTests.class.getResource("/chromedriver.exe").getFile()).getPath());
                driver = new ChromeDriver();


        return driver;
    }

    @BeforeClass
    public static EventFiringWebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        EventFiringWebDriver wrappeDriver = new EventFiringWebDriver(driver);
        wrappeDriver.register(new EventHandler());
        return wrappeDriver;
    }

    @AfterTest
    public void tearDown() {
        getDriver().quit();
    }


}
