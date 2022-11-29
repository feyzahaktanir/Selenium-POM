package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    //Bir page classı açtığımızda ilk yapmamız gereken
    // parametresiz bir constructor oluşturp
    //bu constructor içinde pagefactory ile drivera ilk değer atamasını yapmak olmalıdır.

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement resultText;
}
