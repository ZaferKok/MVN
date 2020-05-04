package com.tehcproed;
//        Create a class: BeforeAndAfterMethods
//        Then create 3 test methods using the follwoing names
//        titleTest =>Verify if google title = “Google”
//        imageTest => Verify if google image displays or not
//        gmailLinkTest => Verify if the Gmail link is displayed or not
//        Close the browser after each test

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class F3_BeforeAndAfterMethods {
    WebDriver driver;
// Methods ->titleTest, imageTest, gmailLinkTest => alphabetical order
    @Before //  => we use  @Before for repeated pre condition,
    public void setUp(){
        // we use @Before for repeated pre conditions,
        //Before method is used to setup the driver, or open the browser, or go to URL
        //We avoid repetitions using @Before and  @After methods
        //What repeats in all 3 methods at the beginning
        //@Before wil run before each @Test method
        // This @Before method will run 3 times before each @Test method
        //  If your browser/internet/website is slow, then you may see some exception
        // your test case may fail. To avoid this, we can put some wait in @Before method

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        // We can put implicitly wait for slower websites
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }


    @Test
    public void titleTest(){
        //Verify if google title = “Google”

        String expected = "Google";
        String actual= driver.getTitle();
        if(actual.equals(expected)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }
    @Test
    public void imageTest(){


        WebElement googleImage = driver.findElement(By.id("hplogo"));
        if (googleImage.isDisplayed()) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }
    @Test
    public void gmailLinkTest(){


        WebElement gmailText = driver.findElement(By.linkText("Gmail"));
        if (gmailText.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }

    @After
    public void tearDown(){
        // @After annotation is usually used to close the browser
        // sometimes it is used to put report.
        // This method will run after each @Test Annotation
        // This method will run 3 times because there are 3 @Test annotations
        driver.close();
    }
}
