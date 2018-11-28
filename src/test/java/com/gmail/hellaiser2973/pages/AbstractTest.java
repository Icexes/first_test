package com.gmail.hellaiser2973.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigProperties;
import utils.Log;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

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

    @AfterMethod(alwaysRun = true)
    public static void afterClass(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
// Create refernce of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;

// Call method to capture screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);

// Copy files to specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));

                System.out.println("Screenshot taken");
            } catch (Exception e) {

                System.out.println("Exception while taking screenshot " + e.getMessage());
            }

            Log.endLog();

        }
    }

    protected WebDriver getDriver() {
        return driver;
    }

}
