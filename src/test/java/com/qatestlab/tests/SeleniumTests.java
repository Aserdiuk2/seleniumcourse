package com.qatestlab.tests;

import com.qatestlab.pages.PageHelper;
import com.qatestlab.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumTests extends BaseTest {


    @Test
    public void AddCategoryTest () {
        EventFiringWebDriver driver = getConfiguredDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        PageHelper pageHelper = new PageHelper(driver);

        PageHelper.open(driver);
        PageHelper.setEmail(driver);
        PageHelper.setPassword(driver);
        PageHelper.pressLoginButton(driver, wait);
        PageHelper.hoverCatalogTab(driver, wait);
        PageHelper.clickCategoriesSubtab(driver, wait);
        PageHelper.clickAddCategory(driver, wait);
        PageHelper.createCategory(driver, wait);
        PageHelper.filterCategoryByName(driver, wait);
        WebElement getCategoryName = driver.findElement(By.className("odd"));
        String CategoryName = getCategoryName.getText();
        System.out.println(CategoryName);
        driver.quit();

    }

    @Test
    public void succesfullSignIn() {
        EventFiringWebDriver driver = getConfiguredDriver();
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
        EventFiringWebDriver driver = getConfiguredDriver();
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


}

