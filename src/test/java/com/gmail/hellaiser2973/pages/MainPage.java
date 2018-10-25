package com.gmail.hellaiser2973.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    String title = "Message List";

    public WebDriver driver;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;

    @FindBy(linkText = "New Message")
    private WebElement newmsgButton;

    @FindBy(css = "input[name='allUsers']")
    private WebElement ch_box_AllUsers;

    @FindBy(linkText = "Следующая страница")

    private WebElement nextPage;

    @FindBy(xpath = "//tbody//tr[last()]/td[2]")
    private WebElement inpHeadline;

    @FindBy(xpath = "//tbody//tr[last()]/td[3]")
    private WebElement inpText;

    @FindBy(xpath = "//tbody//tr[last()]/td")
    private WebElement lastTd;

    @FindBy(xpath = "//div[@class='paginateButtons']/a[last()-1]")
    private WebElement lastPage;

    public MainPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CreateMsgPage openCreateMsgPage()
    {
        newmsgButton.click();
        return new CreateMsgPage(driver);
    }

    public void openAllMessages()
    {
        if (!ch_box_AllUsers.isSelected())
        ch_box_AllUsers.click();
    }

    public void isOpened()
    {
        Assert.assertEquals(title, driver.getTitle());
    }

    public void openLastPage()
    {
        if (isDisplayed())
        lastPage.click();
    }

    public void isDataCorrect(String head, String text)
    {
        Assert.assertEquals(head, inpHeadline.getText());
        Assert.assertEquals(text, inpText.getText());
    }

    public void deleteLastMsg()
    {
        WebElement dltButton = lastTd.findElement(By.linkText("Delete"));
        dltButton.click();
    }

    public void isMessageDelited(String head, String text)
    {
        openLastPage();
        Assert.assertNotEquals(head, inpHeadline.getText());
        Assert.assertNotEquals(text,inpText.getText());
    }

    public void logOut()
    {
        logoutButton.click();
    }

    public boolean isDisplayed() {
        try {
            nextPage.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
