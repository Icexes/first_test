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
    public static StartPage startPage;
    static String head;
    static String txt;

    @BeforeClass
    public static void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        startPage = new StartPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/QulixTeachingSite/");
        startPage.isOpened();
    }

    @Test
    public  void LoginTest()
    {
        String login ="admin", password = "password";
        LoginPage loginPage = startPage.openLoginPage();
        loginPage.isOpened();
        MainPage mainPage = loginPage.login(login,password);
        mainPage.isOpened();
        CreateMsgPage createMsgPage = mainPage.openCreateMsgPage();
        createMsgPage.isOpened();
        head = createMsgPage.getRandomString(5) ;
        txt = createMsgPage.getRandomString(6);
        ShowMessagePage showMessagePage = createMsgPage.createMessage(head,txt);
        showMessagePage.isOpened();
        showMessagePage.openMainPage();
        mainPage.isOpened();
        mainPage.openAllMessages();
        mainPage.openLastPage();
        mainPage.isDataCorrect(head,txt);
    }

    @AfterClass
    public static void afterClass()
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.deleteLastMsg();
        mainPage.isMessageDelited(head,txt);
        mainPage.logOut();
    }
}