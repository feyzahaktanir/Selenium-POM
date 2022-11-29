package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookLoginPage {

    public FacebookLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement fbEmail;

    @FindBy(xpath = "//input[@name='pass']")
    public WebElement fbPassword;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement fbLogInbutton;

    @FindBy(className = "_9ay7")
    public WebElement fbnotLogInalert;


}
