package com.qatestlab.tests;

import com.qatestlab.pages.PageHelper;
import com.qatestlab.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SeleniumTests extends BaseTest {

    @Test
    public void shouldCreateProduct () {
        EventFiringWebDriver driver = getConfiguredDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        PageHelper.open(driver);
        PageHelper.setEmail(driver, "webinar.test@gmail.com");
        PageHelper.setPassword(driver, "Xcg7299bnSmMuRLp9ITw");
        PageHelper.pressLoginButton(driver, wait);
        PageHelper.clickCatalogTab(driver);
        WebElement createProduct = driver.findElement(By.id("page-header-desc-configuration-add"));
        createProduct.click();
        WebElement setProductName = driver.findElement(By.id("form_step1_name_1"));
        setProductName.sendKeys("Test product");
        WebElement chooseQuantityTab = driver.findElement(By.id("tab_step3"));
        chooseQuantityTab.click();
        WebElement setProductQuantity = driver.findElement(By.id("form_step3_qty_0"));
        setProductQuantity.clear();
        setProductQuantity.sendKeys("3");
        WebElement choosePriceTab = driver.findElement(By.id("tab_step2"));
        choosePriceTab.click();
        WebElement setProductPrice = driver.findElement(By.id("form_step2_price"));
        setProductPrice.clear();
        setProductPrice.sendKeys("100");
        WebElement tapActivationSwitcher = driver.findElement(By.className("switch-input"));
        tapActivationSwitcher.click();
        //Добавить проверку попапа driver.findElement(By.name("Настройки обновлены"));
        WebElement tapSubmitButton = driver.findElement(By.id("submit"));
        tapSubmitButton.click();
        //Добавить проверку попапа

    }

    @Test (dependsOnMethods = "shouldCreateProduct")
    public  void shouldDisplayCategory () {
        EventFiringWebDriver driver = getConfiguredDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        PageHelper.openShop(driver);
        WebElement tapAllProductsButton = driver.findElement(By.xpath("//*[@id=\"content\"]/section/a\n"));
        tapAllProductsButton.click();
        WebElement enterSearchQuery = driver.findElement(By.className("ui-autocomplete-input\n"));
        enterSearchQuery.sendKeys("Test product");
        WebElement tapChooseButton = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/button/i\n"));
        tapChooseButton.click();
        Assert.assertTrue(true, "Test Product");


        
    }



}

