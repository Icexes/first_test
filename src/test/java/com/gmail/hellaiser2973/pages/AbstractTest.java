package com.gmail.hellaiser2973.pages;

import com.gmail.hellaiser2973.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigProperties;
import utils.Log;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
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
    public void beforeClass(Method method, ITestContext testContext) {
        Test testAnnotation = method.getAnnotation(Test.class);
        Log.startLog(testAnnotation.testName());
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        Log.info("ChromeDriver initialized");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
        testContext.setAttribute("WebDriver", this.driver);
        Log.info("Open StartPage");
        startPage = new StartPage(getDriver());
        startPage.isOpened(StartPage.TITLE);
    }

    @AfterMethod(alwaysRun = true)
    public final void afterClass(ITestResult result) {
        Log.endLog();
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void customAfterMethod() {

    }

}
