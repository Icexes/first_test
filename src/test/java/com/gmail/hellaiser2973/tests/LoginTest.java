package com.gmail.hellaiser2973.tests;
import com.gmail.hellaiser2973.pages.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static String head;
    private static String text;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        startPage = new StartPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/QulixTeachingSite/");
        startPage.isOpened();
    }

    @Test
    public  void loginTest() {
        String login ="admin", password = "password";
        LoginPage loginPage = startPage.openLoginPage();
        loginPage.isOpened();
        MainPage mainPage = loginPage.logIn(login, password);
        mainPage.isOpened();
        CreateMsgPage createMsgPage = mainPage.openCreateMsgPage();
        createMsgPage.isOpened();
        head = createMsgPage.getRandomString(5);
        text = createMsgPage.getRandomString(6);
        ShowMessagePage showMessagePage = createMsgPage.createMessage(head, text);
        showMessagePage.isOpened();
        showMessagePage.openMainPage();
        mainPage.isOpened();
        mainPage.openAllMessages();
        //todo не забывай про синтаксис, в скобках нужен пробел после запятой
        mainPage.isMessageEntered(head, text);

        //todo задание
        //1. Добавить класс BasePage, который будет содержать общие для всех страниц элементы
        //2. Добавить класс AbstractTest и вынести в него то, что используется (или предполагается исп-ся) несколькими/всеми тестами
        //3. Добавить xml файлик, который будет содержать логины и пароли пользователей. Брать логин / пароль для пользователя из него

    }

    @AfterClass
    public static void afterClass() {
      MainPage mainPage = new MainPage(driver);
      mainPage.deleteLastMsg();
      mainPage.isMessageDeleted(head, text);
      mainPage.logOut();
    }
}