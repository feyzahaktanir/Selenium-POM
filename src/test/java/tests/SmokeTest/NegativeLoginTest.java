package tests.SmokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {


    @Test
    public void wrongPasswordTest() throws InterruptedException {
        //1-https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcURL"));
        HotelMyCampPage hmcp = new HotelMyCampPage();
        if (hmcp.hmcGelismisButton.isDisplayed()){
            hmcp.hmcGelismisButton.click();
            hmcp.hmcSiteyeİlerle.click();
        }
        //2-Login butonuna bas
        hmcp.hmcLoginButton1.click();
        //test data username: manager
        hmcp.hmcUsername.sendKeys(ConfigReader.getProperty("hmcValidUsername"));
        //test data password: Manager1!
        hmcp.hmcPassword.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));

        hmcp.wait(3);

        //Değerleri girildiğinde sayfaya başarılı şekilde girebildiğini test et
        hmcp.hmcLoginButton2.click();
        Assert.assertTrue(hmcp.hmcNegativeLoginAlert.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void wrongUsernameTest() throws InterruptedException {
        //1-https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcURL"));
        HotelMyCampPage hmcp = new HotelMyCampPage();
        if (hmcp.hmcGelismisButton.isDisplayed()){
            hmcp.hmcGelismisButton.click();
            hmcp.hmcSiteyeİlerle.click();
        }
        //2-Login butonuna bas
        hmcp.hmcLoginButton1.click();
        //test data username: manager
        hmcp.hmcUsername.sendKeys(ConfigReader.getProperty("hmcWrongUsername"));
        //test data password: Manager1!
        hmcp.hmcPassword.sendKeys(ConfigReader.getProperty("hmcValidPassword"));

        hmcp.wait(3);

        //Değerleri girildiğinde sayfaya başarılı şekilde girebildiğini test et
        hmcp.hmcLoginButton2.click();
        Assert.assertTrue(hmcp.hmcNegativeLoginAlert.isDisplayed());

        Driver.closeDriver();
    }


    @Test
    public void wrongUsernamePasswordTest() throws InterruptedException {
        //1-https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcURL"));
        HotelMyCampPage hmcp = new HotelMyCampPage();
        if (hmcp.hmcGelismisButton.isDisplayed()){
            hmcp.hmcGelismisButton.click();
            hmcp.hmcSiteyeİlerle.click();
        }
        //2-Login butonuna bas
        hmcp.hmcLoginButton1.click();
        //test data username: manager
        hmcp.hmcUsername.sendKeys(ConfigReader.getProperty("hmcWrongUsername"));
        //test data password: Manager1!
        hmcp.hmcPassword.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));

        hmcp.wait(3);

        //Değerleri girildiğinde sayfaya başarılı şekilde girebildiğini test et
        hmcp.hmcLoginButton2.click();
        Assert.assertTrue(hmcp.hmcNegativeLoginAlert.isDisplayed());

        Driver.closeDriver();
    }
}
