package com.qatestlab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BasicTests {

    @Test
    public static void main (String[] args) throws InterruptedException {
        WebDriver driver = initChromeDriver();

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
        Thread.sleep(3000);

        WebElement avatarMenu = driver.findElement(By.className("employee_avatar_small"));
        avatarMenu.click();
        Thread.sleep(3000);

        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"header_logout\"]"));
        logoutButton.click();
        Thread.sleep(3000);

        driver.quit();

    }

    @Test
    public void mainTabTests() throws InterruptedException {
        WebDriver driver = initChromeDriver();

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0");
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
        Thread.sleep(3000);

        WebElement ordersSubtab = driver.findElement(By.id("subtab-AdminParentOrders"));
        ordersSubtab.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
        driver.navigate().refresh();
        Assert.assertEquals("Заказы • prestashop-automation", driver.getTitle());

        WebElement catalogSubtab = driver.findElement(By.id("subtab-AdminCatalog"));
        catalogSubtab.click();
        Thread.sleep(3000);
        String title2 = driver.getTitle();
        System.out.println(title2);
        driver.navigate().refresh();
        Assert.assertEquals("товары • prestashop-automation", driver.getTitle());

        WebElement logoButton = driver.findElement(By.xpath("/html/body/header/nav/a"));
        logoButton.click();
        Thread.sleep(3000);
        WebElement customersSubtab = driver.findElement(By.id("subtab-AdminParentCustomer"));
        customersSubtab.click();
        Thread.sleep(3000);
        String title3 = driver.getTitle();
        System.out.println(title3);
        driver.navigate().refresh();
        Assert.assertEquals("Управление клиентами • prestashop-automation", driver.getTitle());

        WebElement customerThreadsSubtab = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
        customerThreadsSubtab.click();
        Thread.sleep(3000);
        String title4 = driver.getTitle();
        System.out.println(title4);
        driver.navigate().refresh();
        Assert.assertEquals("Customer Service • prestashop-automation", driver.getTitle());

        WebElement statsSubtab = driver.findElement(By.id("subtab-AdminStats"));
        statsSubtab.click();
        Thread.sleep(3000);
        String title5 = driver.getTitle();
        System.out.println(title5);
        driver.navigate().refresh();
        Assert.assertEquals("Статистика • prestashop-automation", driver.getTitle());

        WebElement adminDashboardButton = driver.findElement(By.xpath("//*[@id=\"tab-AdminDashboard\"]/a/span"));
        adminDashboardButton.click();
        Thread.sleep(3000);
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

