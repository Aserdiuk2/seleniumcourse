package com.qatestlab.tests;

import com.qatestlab.appmanager.EventHandler;
import com.qatestlab.appmanager.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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

