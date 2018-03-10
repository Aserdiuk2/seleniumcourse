package com.qatestlab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class BasicTests {

    @Test
    public static void main (String[] args) {
        WebDriver driver = initChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        EventFiringWebDriver webDriver = new EventFiringWebDriver(driver);
        webDriver.register(new EventHandler());


        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");

        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        wait.until(visibilityOfElementLocated(By.name("submitLogin")));
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();

        wait.until(visibilityOfElementLocated(By.id("subtab-AdminCatalog")));
        WebElement orderTabElement = driver.findElement(By.id("subtab-AdminCatalog"));
        Actions actions = new Actions(driver);
        actions.moveToElement(orderTabElement).build().perform();

        wait.until(visibilityOfElementLocated(By.id("subtab-AdminCategories")));
        WebElement subtabCategories = driver.findElement(By.id("subtab-AdminCategories"));
        subtabCategories.click();


        wait.until(visibilityOfElementLocated(By.id("page-header-desc-category-new_category")));
        WebElement addCategory = driver.findElement(By.id("page-header-desc-category-new_category"));
        addCategory.click();

        wait.until(visibilityOfElementLocated(By.id("name_1")));
        WebElement createCategoryName = driver.findElement(By.id("name_1"));
        createCategoryName.sendKeys("Тестовая Категория");
        WebElement saveCategoryButton = driver.findElement(By.id("category_form_submit_btn"));
        saveCategoryButton.click();

        wait.until(visibilityOfElementLocated(By.name("categoryFilter_name")));
        WebElement categoryNameField = driver.findElement(By.name("categoryFilter_name"));
        categoryNameField.sendKeys("Тестовая Категория");
        WebElement submitFilterButton = driver.findElement(By.xpath("//*[@id=\"submitFilterButtoncategory\"]"));
        submitFilterButton.click();
        
        driver.quit();


    }

    @Test
    public void succesfullSignIn() {
        WebDriver driver = initChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");

        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        wait.until(visibilityOfElementLocated(By.name("submitLogin")));
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();

        wait.until(visibilityOfElementLocated(By.className("employee_avatar_small")));
        WebElement avatarMenu = driver.findElement(By.className("employee_avatar_small"));
        avatarMenu.click();

        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"header_logout\"]"));
        logoutButton.click();

        driver.quit();
    }

    @Test
    public void mainTabTests() {
        WebDriver driver = initChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();

        WebElement ordersSubtab = driver.findElement(By.id("subtab-AdminParentOrders"));
        ordersSubtab.click();
        String title = driver.getTitle();
        System.out.println(title);
        driver.navigate().refresh();
        Assert.assertEquals("Заказы • prestashop-automation", driver.getTitle());

        WebElement catalogSubtab = driver.findElement(By.id("subtab-AdminCatalog"));
        catalogSubtab.click();
        String title2 = driver.getTitle();
        System.out.println(title2);
        driver.navigate().refresh();
        Assert.assertEquals("товары • prestashop-automation", driver.getTitle());

        WebElement logoButton = driver.findElement(By.xpath("/html/body/header/nav/a"));
        logoButton.click();
        WebElement customersSubtab = driver.findElement(By.id("subtab-AdminParentCustomer"));
        customersSubtab.click();
        String title3 = driver.getTitle();
        System.out.println(title3);
        driver.navigate().refresh();
        Assert.assertEquals("Управление клиентами • prestashop-automation", driver.getTitle());

        WebElement customerThreadsSubtab = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
        customerThreadsSubtab.click();
        String title4 = driver.getTitle();
        System.out.println(title4);
        driver.navigate().refresh();
        Assert.assertEquals("Customer Service • prestashop-automation", driver.getTitle());

        WebElement statsSubtab = driver.findElement(By.id("subtab-AdminStats"));
        statsSubtab.click();
        String title5 = driver.getTitle();
        System.out.println(title5);
        driver.navigate().refresh();
        Assert.assertEquals("Статистика • prestashop-automation", driver.getTitle());

        WebElement adminDashboardButton = driver.findElement(By.xpath("//*[@id=\"tab-AdminDashboard\"]/a/span"));
        adminDashboardButton.click();
        String title6 = driver.getTitle();
        System.out.println(title6);
        driver.navigate().refresh();
        Assert.assertEquals("Dashboard • prestashop-automation", driver.getTitle());

        driver.quit();
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

}

