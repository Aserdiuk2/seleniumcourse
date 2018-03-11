package com.qatestlab.tests;

import com.qatestlab.appmanager.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BasicTests {

    private final PageHelper categoryHelper = new PageHelper();

    @Test
    public static void main () {
        WebDriver driver = initChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        PageHelper.open(driver);
        PageHelper.setEmail(driver);
        PageHelper.setPassword(driver);
        PageHelper.pressLoginButton(driver, wait);
        PageHelper.hoverCatalogTab(driver, wait);
        PageHelper.clickCategoriesSubtab(driver, wait);
        PageHelper.clickAddCategory(driver, wait);
        PageHelper.createCategory(driver, wait);
        PageHelper.filterCategoryByName(driver, wait);
        driver.quit();

    }

    @Test
    public void succesfullSignIn() {
        WebDriver driver = initChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        PageHelper.open(driver);
        PageHelper.setEmail(driver);
        PageHelper.setPassword(driver);
        PageHelper.pressLoginButton(driver, wait);
        PageHelper.clickAvatarButton(driver, wait);
        PageHelper.clickLogout(driver);
        driver.quit();
    }

    @Test
    public void mainTabTests() {
        WebDriver driver = initChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        PageHelper.open(driver);
        PageHelper.setEmail(driver);
        PageHelper.setPassword(driver);
        PageHelper.pressLoginButton(driver, wait);

        PageHelper.clickOrdersTab(driver);
        PageHelper.displayTabName(driver);
        driver.navigate().refresh();
        PageHelper.verifyOrdersTabIsOpen(driver);

        PageHelper.clickCatalogTab(driver);
        PageHelper.displayTabName(driver);
        driver.navigate().refresh();
        PageHelper.verifyCatalogTabIsOpen(driver);

        PageHelper.clickLogoButton(driver);
        PageHelper.clickCustomersTab(driver);
        PageHelper.displayTabName(driver);
        driver.navigate().refresh();
        PageHelper.verifyCustomersTabIsOpen(driver);

        PageHelper.clickCustomerThreadsSubtab(driver);
        PageHelper.displayTabName(driver);
        driver.navigate().refresh();
        PageHelper.verifyCustomerThreadsSubtabIsOpen(driver);

        PageHelper.clickStatsTab(driver);
        PageHelper.displayTabName(driver);
        driver.navigate().refresh();
        PageHelper.verifyStatsTabIsOpen(driver);

        PageHelper.clickDashboardButton(driver);
        PageHelper.displayTabName(driver);
        driver.navigate().refresh();
        PageHelper.verifyDashboardIsOpen(driver);

        driver.quit();
    }


    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }


}

