package com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PageHelper {
    private EventFiringWebDriver driver;

    public PageHelper (EventFiringWebDriver driver) {
        this.driver = driver;
    }

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

    public static void verifyDashboardIsOpen(WebDriver driver) {
        Assert.assertEquals("Dashboard • prestashop-automation", driver.getTitle(), "Названия не соответствуют");
    }

    public static void clickDashboardButton(WebDriver driver) {
        WebElement adminDashboardButton = driver.findElement(By.xpath("//*[@id=\"tab-AdminDashboard\"]/a/span"));
        adminDashboardButton.click();
    }

    public static void verifyStatsTabIsOpen(WebDriver driver) {
        Assert.assertEquals("Статистика • prestashop-automation", driver.getTitle(), "Названия не соответствуют");
    }

    public static void clickStatsTab(WebDriver driver) {
        WebElement statsSubtab = driver.findElement(By.id("subtab-AdminStats"));
        statsSubtab.click();
    }

    public static void verifyCustomerThreadsSubtabIsOpen(WebDriver driver) {
        Assert.assertEquals("Customer Service • prestashop-automation", driver.getTitle(), "Названия не соответствуют");
    }

    public static void clickCustomerThreadsSubtab(WebDriver driver) {
        WebElement customerThreadsSubtab = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
        customerThreadsSubtab.click();
    }

    public static void verifyCustomersTabIsOpen(WebDriver driver) {
        Assert.assertEquals("Управление клиентами • prestashop-automation", driver.getTitle(), "Названия не соответствуют");
    }

    public static void clickCustomersTab(WebDriver driver) {
        WebElement customersSubtab = driver.findElement(By.id("subtab-AdminParentCustomer"));
        customersSubtab.click();
    }

    public static void clickLogoButton(WebDriver driver) {
        WebElement logoButton = driver.findElement(By.xpath("/html/body/header/nav/a"));
        logoButton.click();
    }

    public static void verifyCatalogTabIsOpen(WebDriver driver) {
        Assert.assertEquals("товары • prestashop-automation", driver.getTitle(), "Названия не соответствуют");
    }

    public static void clickCatalogTab(WebDriver driver) {
        WebElement catalogSubtab = driver.findElement(By.id("subtab-AdminCatalog"));
        catalogSubtab.click();
    }

    public static void verifyOrdersTabIsOpen(WebDriver driver) {
        Assert.assertEquals("Заказы • prestashop-automation", driver.getTitle(), "Названия не соответствуют");
    }

    public static void displayTabName(WebDriver driver) {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public static void clickOrdersTab(WebDriver driver) {
        WebElement ordersSubtab = driver.findElement(By.id("subtab-AdminParentOrders"));
        ordersSubtab.click();
    }

    public static void verifyFoundedCategory(String categoryName) {
        Assert.assertTrue(categoryName.contains("Тестовая Категория"), "Созданная категория не найдена");
    }

}
