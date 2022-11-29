package tests.day16;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;


public class C04_HotelMyCampPositiveLogin {

    Faker faker = new Faker();
    @Test
    public void positiveLoginTest() throws InterruptedException {
        //1-https://www.hotelmycamp.com adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com");
        //2-Login butonuna bas
        HotelMyCampPage hmcp = new HotelMyCampPage();
        hmcp.hmcLoginButton1.click();
        //test data username: manager
        hmcp.hmcUsername.sendKeys("manager");
        //test data password: Manager1!
        hmcp.hmcPassword.sendKeys("Manager1!");
        //Değerleri girildiğinde sayfaya başarılı şekilde girebildiğini test et
        hmcp.hmcLoginButton2.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.hotelmycamp.com/Admin/UserAdmin"));

        Driver.closeDriver();
    }
}
