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

        driver.get("http://clients.qatestlab.com");
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[2]/form/div/div[1]/div[1]/input"));
        login.sendKeys("0935769775");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[2]/form/div/div[2]/div[1]/input"));
        password.sendKeys("qcCHDxtm");
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[2]/form/div/div[3]/button"));
        submitButton.click();
        Thread.sleep(3000);
        
        driver.quit();


    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

}

