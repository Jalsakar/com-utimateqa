package com_ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Com_ULtiMateQA {
    //1. Set up Multi Browser
    static String browser = "Chrome";
    //static String browser = "FireFox";
    // static String browser = "Edge";
    //Base Url
    static String baseUrl = "https://courses.ultimateqa.com/";
    // Launch the browser
    static WebDriver driver;

    public void multiBrowserTest() {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser input");
        }
        //open the URl into the browser
        driver.get(baseUrl);

        //maximise the browser
        driver.manage().window().maximize();

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Print the title of the page
        System.out.println("Title of the page : " + driver.getTitle());

        //Print the current URL
        System.out.println("Current URL : " + driver.getCurrentUrl());

        //print the page source
        System.out.println("Page source : " + driver.getPageSource());

        //Click on ‘Sign In’ link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        //Print the current url
        System.out.println("Current URL : " + driver.getCurrentUrl());

        //Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("abc123@gmail.com");

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("abc@123");

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Click on login button
        WebElement login = driver.findElement(By.xpath("(//button [@type='submit'])"));
        //WebElement login = driver.findElement(By.partialLinkText("Sign"));
        login.click();

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Navigate to the base URL
        driver.navigate().to(baseUrl);
        System.out.println("Base Url : " + driver.getCurrentUrl());

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Navigate forward to Homepage.
        driver.navigate().forward();
        System.out.println("Forward to Homepage : " + driver.getCurrentUrl());

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Navigate back to baseUrl.
        driver.navigate().back();
        System.out.println("Back to the BaseUrl : " + driver.getCurrentUrl());

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Refresh the page
        driver.navigate().refresh();
        System.out.println("Refresh the page : " + driver.getCurrentUrl());

        //Close the browser
        driver.quit();
    }

    public static void main(String[] args) {
        Com_ULtiMateQA obj = new Com_ULtiMateQA();
        obj.multiBrowserTest();
    }
}//Run the program