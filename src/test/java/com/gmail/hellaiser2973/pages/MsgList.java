package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MsgList {

        public MsgList(WebDriver driver) {
            PageFactory.initElements(driver,this);
            this.driver = driver;
        }
        WebDriver driver;
}
