package com.gmail.hellaiser2973.pages;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    protected static String head;
    protected static String text;
    private static WebDriver driver;
    protected static StartPage startPage;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
        startPage = new StartPage(driver);
    }

    public void isOpened(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @AfterClass
    public static void afterClass() {
        MainPage mainPage = new MainPage(driver);
        mainPage.deleteLastMsg();
        mainPage.isMessageDeleted(head, text);
        mainPage.logOut();
    }
}
