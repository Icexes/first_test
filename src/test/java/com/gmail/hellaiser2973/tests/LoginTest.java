package com.gmail.hellaiser2973.tests;
import com.gmail.hellaiser2973.pages.*;
import org.junit.Test;

public class LoginTest extends AbstractTest {

    @Test
    public  void loginTest() {
        LoginPage loginPage = startPage.openLoginPage();
        loginPage.isOpened(LoginPage.TITLE);
        MainPage mainPage = loginPage.logIn(getAdminLogin(), getAdminPassword());
        mainPage.isOpened(MainPage.TITLE);
        CreateMsgPage createMsgPage = mainPage.openCreateMsgPage();
        createMsgPage.isOpened(CreateMsgPage.TITLE);
        HEAD = createMsgPage.getRandomString(5);
        TEXT = createMsgPage.getRandomString(6);
        ShowMessagePage showMessagePage = createMsgPage.createMessage(HEAD, TEXT);
        showMessagePage.isOpened(ShowMessagePage.TITLE);
        mainPage = showMessagePage.openMainPage();
        mainPage.isOpened(MainPage.TITLE);
        mainPage.openAllMessages();
        mainPage.isMessageCreated(HEAD, TEXT);
        //todo задание
        //Реализовать алгоритм поиска сообщения в списке с помощью интерфейсов ITable, ITableCriterion
    }
}