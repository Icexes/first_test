package com.gmail.hellaiser2973.pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    private final String title = "Welcome to Grails";
    private WebDriver driver;

    @FindBy (linkText = "qulixteachingsite.UserController")
    private WebElement link;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        link.click();
        return new LoginPage(driver);
    }

    public void isOpened() {
        Assert.assertEquals(title, driver.getTitle());
    }
}
