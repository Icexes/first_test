package com.gmail.hellaiser2973.tests;
import com.gmail.hellaiser2973.pages.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;
    public static FirstPage firstPage;
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static CreateMsgPage createMsgPage;
    public static ShowMessage showMessage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        firstPage = new FirstPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        createMsgPage = new CreateMsgPage(driver);
        showMessage = new ShowMessage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/QulixTeachingSite/");
        firstPage.isFirstPage();
    }

    @Test
    public void loginTest() {
        firstPage.Click();
        loginPage.isLoginPage();
        loginPage.inputLogin("admin");
        loginPage.inputPassword("password");
        loginPage.Click();
        mainPage.isMainPage();
        mainPage.Click();
        createMsgPage.inputHeadline("Alex");
        createMsgPage.inputText("Go home");
        createMsgPage.Click();
        showMessage.Click();
        mainPage.AllMessages();
    }




    }

