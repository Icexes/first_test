package com.gmail.hellaiser2973.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigProperties;
import utils.Log;

import java.io.File;
import java.lang.reflect.Method;
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


    @BeforeMethod

    public static void beforeClass(Method method) {
        Test testAnnotation = method.getAnnotation(Test.class);
        Log.startLog(testAnnotation.testName());
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        Log.info("ChromeDriver initialized");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
        Log.info("Open StartPage");
        startPage = new StartPage(driver);
        startPage.isOpened(StartPage.TITLE);

    }

    @AfterMethod

    public static void afterClass() {
        public static void checkStatus (ITestResult result) throws IOException {
            if (result.isSuccess()) {
            } else {

                File screenshot = ((TakesScreenshot) driver).
                        getScreenshotAs(OutputType.FILE);
                String path = "./target/screenshots/" + screenshot.getName();
                FileUtils.copyFile(screenshot, new File(path));
            }
        }
        MainPage mainPage = new MainPage(driver);
        mainPage.deleteLastMessage(HEAD, TEXT);
        mainPage.logOut();
        Log.endLog();

    }
}
