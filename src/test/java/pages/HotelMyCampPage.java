package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class HotelMyCampPage {
    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Login locates
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

    //Bağlantı Gizliliği Locates
    @FindBy(id = "details-button")
    public WebElement hmcGelismisButton;

    @FindBy(id = "proceed-link")
    public WebElement hmcSiteyeİlerle;

    //Pnael Locates
    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hmcHotelManagementLink;

    @FindBy(xpath = "//a[text()='\n" +
            "\t\t\t\t\t\t\t            Hotel List']")
    public WebElement hmcHotelList;

    //Otel ekleme locates
    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement hmcAddHotel;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement chotelCode;
    @FindBy(xpath = "//input[@id='Name']")
    public WebElement chotelName;
    @FindBy(xpath = "//input[@id='Address']")
    public WebElement chotelAddress;
    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement chotelPhone;
    @FindBy(xpath = "//input[@id='Email']")
    public WebElement chotelEmail;
    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement chotelIDGroup;
    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement chotelSAVE;
    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement chotelAlert;
    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement chotelAlertAccept;

    public void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void logIn(){
        Driver.getDriver().get(ConfigReader.getProperty("hmcURL"));
        //baglantiGizliDegil();
        hmcLoginButton1.click();
        hmcUsername.sendKeys(ConfigReader.getProperty("hmcValidUsername"));
        hmcPassword.sendKeys(ConfigReader.getProperty("hmcValidPassword"));
        hmcLoginButton2.click();
    }

    public void baglantiGizliDegil(){
        if (hmcGelismisButton.isDisplayed()){
            hmcGelismisButton.click();
            hmcSiteyeİlerle.click();
        }
    }

    //Panel Users List Locates
    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> wtHeaderTitles;
    @FindBy(xpath = "//tbody")
    public WebElement wtALLtbody;
    @FindBy(xpath = "//tbody//td")
    public List<WebElement> wtALLtbodytd;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> wtRows;


    public WebElement rowCall(int rowNo){
        //2.satırı yazdır //tbody//tr[2]
        //7.satırı yazdır //tbody//tr[7]
        String rowDinamikXpath = "//tbody//tr[" + rowNo + "]";
        WebElement row = Driver.getDriver().findElement(By.xpath(rowDinamikXpath));
        return row; //burada webelement döndürmek istedik
    }

    public String cellCall(int rowNo, int cellNo){
        //2.satırın 4.datası //tbody//tr[2]//td[4]
        //4.satırın 5.datası //tbody//tr[4]//td[5]
        String cellDinamikXpath = "//tbody//tr[" + rowNo + "]//td[" + cellNo + "]";
        WebElement cell = Driver.getDriver().findElement(By.xpath(cellDinamikXpath));
        String scell = cell.getText();
        return scell; //burada string döndürmek istedik
    }

    public void columnCall(int columnNo){
        //4.sütunun tamamı //tbody//td[4]
        int rows = wtRows.size();
        for (int i=1; i<= wtRows.size(); i++){
            System.out.println(i + ". column: " + cellCall(i, columnNo));
        }
    }

}
