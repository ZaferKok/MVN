package com.tehcproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class F4_Assertions {
    WebDriver driver;

    @Before
    public void setUp(){
// @Before method is not a test method. It is just a set up method
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        // We can put implicitly wait for slower websites
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    @Test
    public void titleTest(){

        String expected = "Google";
        String actual= driver.getTitle();
        // Assert class is coming from JUnit
        // asserEquals(); takes two string and checks if they are equal
        // It will fail if the two string is not equal
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void imageTest(){

        WebElement googleImage = driver.findElement(By.id("hplogo"));
        // use Assertion to check if googleImage is displayed
        // We are not comparing two string. We do not have expected and actual
        // We just want to check True or False condition.
        Assert.assertTrue(googleImage.isDisplayed());
        //We are expecting True. So we re using assertTrue
        // This will pass if the statement is True. It will fail if the googleImage.isDisplayed() is False
        // ====>>> Assert.assertFalse(googleImage.isDisplayed());
        // We are expecting a False statement. If googleImage.isDisplayed() is false then this will PASS
        // If googleImage.isDisplayed() is true, then this will FAIL
    }
    @Test
    public void gmailLinkTest() {

        WebElement gmailText = driver.findElement(By.linkText("Gmail"));
        Assert.assertTrue(gmailText.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
