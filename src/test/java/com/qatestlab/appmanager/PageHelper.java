package com.qatestlab.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageHelper {

    public static void filterCategoryByName(WebDriver driver, WebDriverWait wait) {
        wait.until(visibilityOfElementLocated(By.name("categoryFilter_name")));
        WebElement categoryNameField = driver.findElement(By.name("categoryFilter_name"));
        categoryNameField.sendKeys("Тестовая Категория");
        WebElement submitFilterButton = driver.findElement(By.xpath("//*[@id=\"submitFilterButtoncategory\"]"));
        submitFilterButton.click();
    }

    public static void createCategory(WebDriver driver, WebDriverWait wait) {
        wait.until(visibilityOfElementLocated(By.id("name_1")));
        WebElement createCategoryName = driver.findElement(By.id("name_1"));
        createCategoryName.sendKeys("Тестовая Категория");
        WebElement saveCategoryButton = driver.findElement(By.id("category_form_submit_btn"));
        saveCategoryButton.click();
    }

    public static void clickAddCategory(WebDriver driver, WebDriverWait wait) {
        wait.until(visibilityOfElementLocated(By.id("page-header-desc-category-new_category")));
        WebElement addCategory = driver.findElement(By.id("page-header-desc-category-new_category"));
        addCategory.click();
    }

    public static void clickCategoriesSubtab(WebDriver driver, WebDriverWait wait) {
        wait.until(visibilityOfElementLocated(By.id("subtab-AdminCategories")));
        WebElement subtabCategories = driver.findElement(By.id("subtab-AdminCategories"));
        subtabCategories.click();
    }

    public static void hoverCatalogTab(WebDriver driver, WebDriverWait wait) {
        wait.until(visibilityOfElementLocated(By.id("subtab-AdminCatalog")));
        WebElement orderTabElement = driver.findElement(By.id("subtab-AdminCatalog"));
        Actions actions = new Actions(driver);
        actions.moveToElement(orderTabElement).build().perform();
    }

    public static void setEmail(WebDriver driver) {
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
    }

    public static void open(WebDriver driver) {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
    }

    public static void clickLogout(WebDriver driver) {
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"header_logout\"]"));
        logoutButton.click();
    }

    public static void clickAvatarButton(WebDriver driver, WebDriverWait wait) {
        wait.until(visibilityOfElementLocated(By.className("employee_avatar_small")));
        WebElement avatarMenu = driver.findElement(By.className("employee_avatar_small"));
        avatarMenu.click();
    }

    public static void pressLoginButton(WebDriver driver, WebDriverWait wait) {
        wait.until(visibilityOfElementLocated(By.name("submitLogin")));
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
    }

    public static void setPassword(WebDriver driver) {
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
    }
}
