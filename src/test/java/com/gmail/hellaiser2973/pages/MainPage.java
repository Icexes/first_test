package com.gmail.hellaiser2973.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "/html/body/div[3]/span/a")
    public WebElement logoutButton;

    @FindBy(linkText = "New Message")
    private WebElement newmsgButton;

    @FindBy(xpath = "/html/body/div[5]/div[1]/span/input")
    private WebElement ch_box_AllUsers;
    @FindBy(linkText = "Следующая страница")
    private WebElement NextPage;

    @FindBy(xpath = "//tbody//tr[last()]/td[2]")
    private WebElement inpHeadline;

    @FindBy(xpath = "//tbody//tr[last()]/td[3]")
    private WebElement inpText;

    @FindBy(xpath = "//tbody//tr[last()]/td")
    private WebElement LastTd;

    public void Click() {
        newmsgButton.click();
    }

    public void AllMessages() {
        ch_box_AllUsers.click();
    }

    public void isMainPage() {
        Assert.assertEquals("Message List", driver.getTitle());
    }

    public void lastPage() {

        for (; ; ) {
            try {
                NextPage.click();
            } catch (NoSuchElementException e) {
                break;
            }

        }
    }

    public void isDataCorrect() {
        Assert.assertEquals(CreateMsgPage.head, inpHeadline.getText());
        Assert.assertEquals(CreateMsgPage.txt, inpText.getText());
    }

    public void DeleteLastMsg() {
        WebElement dltButton = LastTd.findElement(By.linkText("Delete"));
        dltButton.click();
    }

    public void LogOut() {
        logoutButton.click();
    }
}