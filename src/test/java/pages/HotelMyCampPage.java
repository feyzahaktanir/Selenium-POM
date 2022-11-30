package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement hmcLoginButton1;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement hmcUsername;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement hmcPassword;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement hmcLoginButton2;

    @FindBy(id = "divMessageResult")
    public WebElement hmcNegativeLoginAlert;

    @FindBy(id = "details-button")
    public WebElement hmcGelismisButton;

    @FindBy(id = "proceed-link")
    public WebElement hmcSiteyeİlerle;
    
    public void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
