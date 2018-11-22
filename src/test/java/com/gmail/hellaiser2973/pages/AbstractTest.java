package com.gmail.hellaiser2973.pages;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    protected static String HEAD;
    protected static String TEXT;
    private static WebDriver driver;
    protected static StartPage startPage;

    protected String getAdminLogin() {
        return ConfigProperties.getTestProperty("login");
    }

    protected String getAdminPassword() {
        return ConfigProperties.getTestProperty("password");
    }

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
        startPage = new StartPage(driver);
        startPage.isOpened(StartPage.TITLE);
    }

    @AfterClass
    public static void afterClass() {
        MainPage mainPage = new MainPage(driver);
        mainPage.deleteLastMessage(HEAD, TEXT);
        mainPage.logOut();
    }
}
