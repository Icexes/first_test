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
    //public static LoginPage loginPage;
    public static MainPage mainPage;
    public static CreateMsgPage createMsgPage;
    public static ShowMessagePage showMessagePage;

    @BeforeClass
    //todo переименуй метод в beforeClass
    public static void setup() {
        //todo не стоит инициализировать все страницы перед тестом, лучше непосредственно перед использованием
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        firstPage = new FirstPage(driver);
        //loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        createMsgPage = new CreateMsgPage(driver);
        showMessagePage = new ShowMessagePage(driver);

        //фактически в beforeTest должны остаться только эти строки
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/QulixTeachingSite/");
        firstPage.isFirstPage();
    }

    @Test
    public void loginTest() {
        //вот пример, как должны открываться страницы по коду
        LoginPage loginPage = firstPage.openLoginPage();
        //firstPage.Click();
        //todo из названия метода не совсем понятно его назначение, переименуй подобные просто в isOpened
        loginPage.isLoginPage();
        //todo тестовые данные должны быть определены в переменных перед тестом String login = "admin"
        loginPage.inputLogin("admin");
        loginPage.inputPassword("password");
        loginPage.Click();
        mainPage.isMainPage();
        mainPage.Click();
        createMsgPage.isCreateMsgPage();
        createMsgPage.inputHeadline();
        createMsgPage.inputText();
        createMsgPage.Click();
        showMessagePage.isShowMessagePage();
        showMessagePage.Click();
        mainPage.AllMessages();
        mainPage.lastPage();
        mainPage.isDataCorrect();
    }


    @AfterClass
    //todo переименуй метод в afterClass
    public static void TheEnds() {
        //todo после делита проверь, что из таблички действительно пропала такая запись
        mainPage.DeleteLastMsg();
        mainPage.LogOut();
    }
    }

