package com.gmail.hellaiser2973.tests;

import com.gmail.hellaiser2973.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class LoginTest extends AbstractTest {

    private static String head;
    private static String text;

    @Test(testName = "Login Test")
    public  void loginTest() {

        LoginPage loginPage = startPage.openLoginPage();
        loginPage.isOpened(LoginPage.TITLE);

        MainPage mainPage = loginPage.logIn(getAdminLogin(), getAdminPassword());
        mainPage.isOpened(MainPage.TITLE);

        CreateMsgPage createMsgPage = mainPage.openCreateMsgPage();
        createMsgPage.isOpened(CreateMsgPage.TITLE);

        head = createMsgPage.getRandomString(5);
        text = createMsgPage.getRandomString(6);

        ShowMessagePage showMessagePage = createMsgPage.createMessage(head, text);
        showMessagePage.isOpened(ShowMessagePage.TITLE);

        mainPage = showMessagePage.openMainPage();
        mainPage.isOpened(MainPage.TITLE);
        mainPage.openAllMessages();
        mainPage.verifyMessageCreated(head, text);

        //Perfect job, мой юный падаван!

        //todo задание
        //добавить к тестам логирование, используя log4j
        //в случае, если тест падает - делать скриншот
        //отправить мне на проверку


        //todo задания по Java:
        //изучить работы со строками + практически потренироваться с ними работать
        //изучить коллекции + практически потренироваться с ними работать


    }

    @AfterMethod
    public void customAfterMethod() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.deleteLastMessage(head, text);
        mainPage.logOut();
    }
}