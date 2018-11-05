package com.gmail.hellaiser2973.tests;
import com.gmail.hellaiser2973.pages.*;
import org.junit.Test;
import utils.ConfigProperties;

public class LoginTest extends AbstractTest {

    @Test
    public  void loginTest() {
        isOpened(startPage.title);
        LoginPage loginPage = startPage.openLoginPage();
        isOpened(loginPage.title);
        MainPage mainPage = loginPage.logIn(ConfigProperties.getTestProperty("login"), ConfigProperties.getTestProperty("password"));
        isOpened(mainPage.title);
        CreateMsgPage createMsgPage = mainPage.openCreateMsgPage();
        isOpened(createMsgPage.title);
        head = createMsgPage.getRandomString(5);
        text = createMsgPage.getRandomString(6);
        ShowMessagePage showMessagePage = createMsgPage.createMessage(head, text);
        isOpened(showMessagePage.title);
        showMessagePage.openMainPage();
        isOpened(mainPage.title);
        mainPage.openAllMessages();
        mainPage.isMessageCreated(head, text);

        //todo задание
        //1. Добавить класс BasePage, который будет содержать общие для всех страниц элементы
        //2. Добавить класс AbstractTest и вынести в него то, что используется (или предполагается исп-ся) несколькими/всеми тестами
        //3. Добавить xml файлик, который будет содержать логины и пароли пользователей. Брать логин / пароль для пользователя из него
    }
}