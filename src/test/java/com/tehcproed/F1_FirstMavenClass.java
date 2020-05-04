package com.tehcproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/* Interview Question and Answers in the slides maybe day6
What is maven => java build tool. Project management tool.
What is pom.xml file => manages the dependencies
What is the difference between maven and pom => maven is tool, pom is
an xml file. Pom.xml is part of maven and pom manage the dependencies.
How did you use pom in your project? Why did you use it? => to manage
the dependencies. It helped me to manage the whole project such as
importing.....
What is dependency? How do you use them? Why do you use them? =>
dependencies are needed to setup teh drivers to create the drivers.
Import the necessary tools.
How do you update your pom file?
I go to mvnreporsitory.com and search for the dependency,
copy and paste on my pom.xml file.
*/
public class F1_FirstMavenClass {
    public static void main(String[] args) {
        // We wll no use System.setProperty("",""); in maven project
        // Instead, we will use WebDriverManager -> let us use the drivers
        // For chromedriver
        WebDriverManager.chromedriver().setup();// This is red. It means we are missing dependencies/after you load the codes from the website then import them.
        // Where do we get the dependencies from?
        // Answer : https://mvnrepository.com/  and search /WebDriverManager/copy the codes of last active version and paste it into pom.xml dependencies

        WebDriver driver = new ChromeDriver(); // ->missing dependency after you load the codes from the website then import them.
        // go to https://mvnrepository.com/ and search /selenium java/ copy the codes of last active version and paste it into pom.xml dependencies

        driver.get("https:/www.google.com");
        // How to generate fake data?
        // We need a dependency for it. It is called JavaFaker

        //creating searchbox element
        WebElement searchBox = driver.findElement(By.name("q"));
        //creating faker object
        Faker faker = new Faker();
        //sending that fake data to searchbox and hitting enter
        searchBox.sendKeys(faker.name().fullName()+ Keys.ENTER);
        // Keys.Enter is same as clicking enter button
        System.out.println(faker.address().city());
        System.out.println(faker.name().fullName());
    }
}
