package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PropertiesFirstClass {

    HotelMyCampPage hmcp = new HotelMyCampPage();

    @Test
    public void positiveLoginTest() throws InterruptedException {
        //1-https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcURL"));
        if (hmcp.hmcGelismisButton.isDisplayed()){
            hmcp.hmcGelismisButton.click();
            hmcp.hmcSiteyeİlerle.click();
        }
        //2-Login butonuna bas
        hmcp.hmcLoginButton1.click();
        //test data username: manager
        hmcp.hmcUsername.sendKeys(ConfigReader.getProperty("hmcValidUsername"));
        //test data password: Manager1!
        hmcp.hmcPassword.sendKeys(ConfigReader.getProperty("hmcValidPassword"));
        //Değerleri girildiğinde sayfaya başarılı şekilde girebildiğini test et
        hmcp.hmcLoginButton2.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.hotelmycamp.com/Admin/UserAdmin"));

        Driver.closeDriver();
    }
}
