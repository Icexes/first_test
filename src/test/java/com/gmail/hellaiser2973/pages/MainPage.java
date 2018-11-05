package com.gmail.hellaiser2973.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage {

    private static int numbOfRecord;      //Переменная, указывающая номер введенной записи в таблице. Статик т.к. используется в разных методах, нужно текущее значение
    public final String title = "Message List";

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

    public CreateMsgPage openCreateMsgPage() {
        newMsgButton.click();
        return new CreateMsgPage(driver);
    }

    public void openAllMessages() {
        if (!chBoxAllUsers.isSelected())
            chBoxAllUsers.click();
    }

    public void isMessageCreated(String head, String text) {
        Assert.assertEquals(true, findMessage(head,text));
    }

    public boolean findMessage(String head, String text) {
        int currCell;  //текущее поле в таблице
        int pageNumber; //номер страницы
        if (driver.findElements(By.className("step")).size() > 0) {       // если кнопки номера страницы есть, значит берем посл. номер страницы
            pageNumber = Integer.parseInt(lastPage.getText());
        }
        else pageNumber = 1;
        for (int i = 1; i <= pageNumber; i++) {
            currCell = 0;
            List<WebElement> allHeadlines = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
            List<WebElement> allText = driver.findElements(By.cssSelector("tr td:nth-child(3)"));
            for (WebElement column : allHeadlines) {
                System.out.println(allText.get(currCell).getText());
                if (column.getText().equals(head)) {
                    if (allText.get(currCell).getText().equals(text)) {
                        System.out.println(head);
                        MainPage.numbOfRecord = currCell + 1;
                        return true;
                    }
                }
                currCell++;
            }
              if (i!=pageNumber) nextPage.click();
        }
        return false;
    }

    public void deleteLastMsg() {
        String a = "//tbody/tr[" + MainPage.numbOfRecord + "]/td";
        WebElement dltButton = driver.findElement(By.xpath(a)).findElement(By.linkText("Delete"));
        dltButton.click();
    }

    public void isMessageDeleted(String head, String text) {
        Assert.assertEquals(false, findMessage(head,text));
    }

}


