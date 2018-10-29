package com.gmail.hellaiser2973.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MainPage {

    static int numbOfRecord;                    //Переменная, указывающая номер введенной записи в таблице. Статик т.к. используется в разных методах, нужно текущее значение

    String title = "Message List";

    public WebDriver driver;


    @FindBy(css = "a[href*='logout']")
    public WebElement logoutButton;

    @FindBy(css = "a.create")
    private WebElement newmsgButton;

    @FindBy(css = "input[name='allUsers']")
    private WebElement ch_box_AllUsers;

    @FindBy(css = "a.nextLink")
    private WebElement nextPage;

    @FindBy(xpath = "//tbody//tr[last()]/td[2]")
    private WebElement inpHeadline;

    @FindBy(xpath = "//tbody//tr[last()]/td[3]")
    private WebElement inpText;

    @FindBy(xpath = "//div[@class='paginateButtons']/a[last()-1]")
    private WebElement lastPage;

    @FindBy (css = "a.step")
    private WebElement pageButton;


    public MainPage(WebDriver driver) {

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

    public void isMessageEntered(String head, String text) {
        Assert.assertEquals(true, findMessage(head,text));
    }

    public boolean isPageButtonDisplayed() {    //метод помогает определить кол-во страниц в табл: 1 или более.
        try {
            pageButton.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean findMessage(String head, String text) {

        int curRecord;  //текущее поле в таблице
        int numOfPages; //текущая страница

        if (isPageButtonDisplayed())       // если кнопки номера страницы есть, значит берем посл. номер страницы
                numOfPages = Integer.parseInt(lastPage.getText());
        else numOfPages = 1;

        for (int i = 1; i <= numOfPages; i++) {
              curRecord = 0;
              List<WebElement> allHeadlines = driver.findElements(By.cssSelector(" tr td:nth-child(2)"));
              List<WebElement> allText = driver.findElements((By.cssSelector("tr td:nth-child(3)")));
            for (WebElement column : allHeadlines) {
                System.out.println(allText.get(curRecord).getText());

                if (column.getText().equals(head)) {
                    if (allText.get(curRecord).getText().equals(text))
                        System.out.println(head);
                        MainPage.numbOfRecord = curRecord+1;
                        return true;
                }
                curRecord++;
            }
              if (i!=numOfPages)
            nextPage.click();
        }
        return false;
    }

    public void deleteLastMsg()
    {
        String a = "//tbody/tr[" + MainPage.numbOfRecord + "]/td";
        WebElement dltButton = driver.findElement(By.xpath(a)).findElement(By.linkText("Delete"));
        dltButton.click();
    }

    public void isMessageDeleted(String head, String text) {
        Assert.assertEquals(false, findMessage(head,text));
    }

    public void logOut()
    {
        logoutButton.click();
    }

}


