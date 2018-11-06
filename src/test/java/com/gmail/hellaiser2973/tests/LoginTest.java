package com.gmail.hellaiser2973.tests;
import com.gmail.hellaiser2973.pages.*;
import org.junit.Test;

public class LoginTest extends AbstractTest {

    @Test
    public  void loginTest() {

        LoginPage loginPage = startPage.openLoginPage();
        loginPage.isOpened(LoginPage.title);
        MainPage mainPage = loginPage.logIn(getAdminLogin(), getAdminPassword());
        mainPage.isOpened(MainPage.title);
        CreateMsgPage createMsgPage = mainPage.openCreateMsgPage();
        createMsgPage.isOpened(CreateMsgPage.title);
        head = createMsgPage.getRandomString(5);
        text = createMsgPage.getRandomString(6);
        ShowMessagePage showMessagePage = createMsgPage.createMessage(head, text);
        showMessagePage.isOpened(ShowMessagePage.title);
        MainPage mainPage1 = showMessagePage.openMainPage();
        mainPage1.isOpened(MainPage.title);
        mainPage1.openAllMessages();
        mainPage1.isMessageCreated(head, text);
        //todo задание
        //1. исправить замечания
        //2. понять, для чего BasePage
    }
}