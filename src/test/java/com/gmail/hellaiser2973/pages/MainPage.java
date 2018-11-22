package com.gmail.hellaiser2973.pages;

import com.gmail.hellaiser2973.ui.tables.ITable;
import com.gmail.hellaiser2973.ui.tables.ITableCriterion;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage implements ITable {

    private static int numbOfRecord;
    public static final String TITLE = "Message List";

    @FindBy(css = "a.nextLink")
    private WebElement nextPage;
    @FindBy(xpath = "//tbody//tr[last()]/td[2]")
    private WebElement inpHeadline;
    @FindBy(xpath = "//tbody//tr[last()]/td[3]")
    private WebElement inpText;
    @FindBy(xpath = "//div[@class='paginateButtons']/a[last()-1]")
    private WebElement lastPage;
    @FindBy(css = "a.step")
    private WebElement pageButton;

    MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement currentRow;

    public boolean rowExistsOnThisPage(ITableCriterion rowCriterion) {
        List<WebElement> tableRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row : tableRows) {
            if (rowCriterion.matches(row)) {
                currentRow = row;
                return true;
            }
        }
        return false;
    }

    public boolean rowExists(ITableCriterion rowCriterion) {
        int pageNumber;

        if (driver.findElements(By.className("step")).size() > 0) {
            pageNumber = Integer.parseInt(lastPage.getText());
        } else pageNumber = 1;
        for (int i = 1; i <= pageNumber; i++) {
            if (rowExistsOnThisPage(rowCriterion)) {
                return true;
            }
            if (i != pageNumber) nextPage.click();
        }
        return false;
    }

    public WebElement getRow(ITableCriterion rowCriterion) {
        Assert.assertTrue(rowExists(rowCriterion));
        return currentRow;
    }

    public WebElement getRowOnThisPage(ITableCriterion rowCriterion) {
        Assert.assertTrue(rowExistsOnThisPage(rowCriterion));
        return currentRow;
    }

    public void isMessageCreated(String head, String text) {
        FindMessages rowCriterion = new FindMessages(head, text);
        Assert.assertTrue(rowExists(rowCriterion));
    }

    public void deleteLastMessage(String head, String text) {
        FindMessages rowCriterion = new FindMessages(head, text);
        WebElement row = getRowOnThisPage(rowCriterion);
        row.findElement(By.linkText("Delete")).click();
    }
}


