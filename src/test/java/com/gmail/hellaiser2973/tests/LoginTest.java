package com.gmail.hellaiser2973.tests;
import com.gmail.hellaiser2973.pages.*;
import org.junit.Test;
import utils.ConfigProperties;

public class LoginTest extends AbstractTest {

    @Test
    public  void loginTest() {
        //todo убрать в бефортест
        isOpened(startPage.title);

        LoginPage loginPage = startPage.openLoginPage();

        //todo isOpened метод должен выглядеть как
        //loginPage.isOpened(loginPage.title);
        isOpened(loginPage.title);
        //todo прописывать доставание конфигов в тесте - плохо. Сделай доставание логина и пароля юзера в методе getAdminUser
        //т.е loginPage.logIn(User.getAdminUser()) или не админ, в зав-ти от сценария
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
        //1. исправить замечания
        //2. понять, для чего BasePage

    }
}