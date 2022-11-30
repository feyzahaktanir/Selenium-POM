package tests.day17;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_HotelMyCampNegativeLogin {
    @Test
    public void negativeLoginTest() throws InterruptedException {
        //1-https://www.hotelmycamp.com adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com");
        //2-Login butonuna bas
        HotelMyCampPage hmcp = new HotelMyCampPage();
        hmcp.hmcLoginButton1.click();
        //test data username: manager
        hmcp.hmcUsername.sendKeys("manager1");
        //test data password: Manager1!
        hmcp.hmcPassword.sendKeys("manager1!");
        //Değerleri girildiğinde sayfaya BAŞARISIZ şekilde uyarı geldiğini test et
        hmcp.hmcLoginButton2.click();
        Assert.assertTrue(hmcp.hmcNegativeLoginAlert.isDisplayed());

        Driver.closeDriver();
    }
}
