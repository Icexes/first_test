package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UselessThings {
/*


    private boolean findMessage(String head, String text) {
        int currCell;  //текущее поле в таблице
        int pageNumber; //номер страницы
        if (driver.findElements(By.className("step")).size() > 0) {       // если кнопки номера страницы есть, значит берем посл. номер страницы
            pageNumber = Integer.parseInt(lastPage.getText());
        } else pageNumber = 1;
        for (int i = 1; i <= pageNumber; i++) {
            currCell = 0;
            List<WebElement> allHeadlines = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
            List<WebElement> allText = driver.findElements(By.cssSelector("tr td:nth-child(3)"));
            for (WebElement column : allHeadlines) {
                if (column.getText().equals(head)) {
                    if (allText.get(currCell).getText().equals(text)) {
                        MainPage.numbOfRecord = currCell + 1;
                        return true;
                    }
                }
                currCell++;
            }
            if (i != pageNumber) nextPage.click();
        }
        return false;
    }
/*
    void deleteLastMsg() {
        String a = "//tbody/tr[" + MainPage.numbOfRecord + "]/td";
        WebElement dltButton = driver.findElement(By.xpath(a)).findElement(By.linkText("Delete"));
        dltButton.click();
    }

  //  void isMessageDeleted(String head, String text) {
  //      Assert.assertFalse(findMessage(head, text));
  //  }
  */
}
