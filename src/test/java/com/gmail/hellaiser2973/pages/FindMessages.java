package com.gmail.hellaiser2973.pages;

import com.gmail.hellaiser2973.ui.tables.ITableCriterion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindMessages implements ITableCriterion {

    private String head, text;

    FindMessages(String head, String text) {
        this.head = head;
        this.text = text;
    }

    public boolean matches(WebElement rowElement) {
        WebElement headCell = rowElement.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement textCell = rowElement.findElement((By.cssSelector("td:nth-child(3)")));
        boolean t = headCell.getText().equals(head) && textCell.getText().equals(text);
        return t;
    }
}
