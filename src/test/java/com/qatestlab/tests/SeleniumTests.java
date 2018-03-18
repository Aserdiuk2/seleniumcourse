package com.qatestlab.tests;

import com.qatestlab.pages.PageHelper;
import com.qatestlab.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SeleniumTests extends BaseTest {

    @DataProvider
    public Object[][] getLoginData() {
        return new String[][] {
                {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
        };
    }

    @Test (dataProvider = "getLoginData")
    public void shouldCreateProduct (String login, String password) {
        EventFiringWebDriver driver = getConfiguredDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        PageHelper.open(driver);
        PageHelper.setEmail(driver, login);
        PageHelper.setPassword(driver, password);
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
        WebElement popupMessage = driver.findElement((By.className("growl-message")));
        String message = popupMessage.getText();
        Assert.assertEquals(message, "Настройки обновлены.", "Popup is incorrect");
        //Всплывающее окно исчезает автоматически
        WebElement tapSubmitButton = driver.findElement(By.id("submit"));
        tapSubmitButton.click();
        Assert.assertEquals(message, "Настройки обновлены.", "Popup is incorrect");
        //Всплывающее окно исчезает автоматически

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
        WebElement findProduct = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h1"));
        String myProduct = findProduct.getText();
        Assert.assertEquals(myProduct, "Test Product", "Correct product isn`t found" );
        WebElement chooseProduct = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h1/a"));
        chooseProduct.click();
        WebElement productTitle = driver.findElement(By.className("h1"));
        String title = productTitle.getText();
        WebElement productPrice = driver.findElement(By.className("current-price"));
        String price = productPrice.getText();
        WebElement productQuantity = driver.findElement(By.className("product-quantities"));
        String quantity = productQuantity.getText();
        Assert.assertEquals(title, "TEST PRODUCT", "Category name is not correct");
        Assert.assertEquals(price, "100,00 ₴", "Price is incorrect");
        Assert.assertEquals(quantity, "По наличию 3 Товары", "Quantity is incorrect");













    }



}

