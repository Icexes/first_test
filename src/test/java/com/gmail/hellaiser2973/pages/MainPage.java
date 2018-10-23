package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "/html/body/div[3]/span/a")
   public WebElement logoutButton;

    @FindBy(linkText = "New Message")
    private WebElement newmsgButton;

    @FindBy(xpath = "/html/body/div[5]/div[1]/span/input")
    private WebElement ch_box_AllUsers;

 public void Click() {
        newmsgButton.click();
 }

 public void AllMessages() {
        ch_box_AllUsers.click();
 }

 public void isMainPage() {
        try {
            driver.findElement(By.className("list"));

        } catch (NoSuchElementException e) {
            System.out.println("Login page is not opened");
            driver.quit();
            throw new RuntimeException(("Test ended with critical error"));
        }
    }


    public void LogOut() {
        logoutButton.click();
    }
}
