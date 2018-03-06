package com.qatestlab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

}

