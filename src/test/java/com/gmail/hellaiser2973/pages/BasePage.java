package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.WebElement;

abstract class BasePage {
    public void Click(WebElement element) {
        element.click();
    }
}
