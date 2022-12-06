package tests.day22;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_FacebookTesti extends TestBaseRapor {

    @Test
    public void facebookTest() {
        extentTest = extentReports.createTest("Facebook", "Fake isimle girilmediği tet edildi.");
        // 1 - https://www.facebook.com adresine gidin
        Driver.getDriver().get("https://www.facebook.com");
        extentTest.info("Giriş sayfasına gidildi.");

        // 2 - POM'a uygun olarak email, şifre kutularını ve giriş yap butonunu locate edin.
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage();

        // 3 - Faker kullanarak email ve şifre değerlerini yazdırıp giriş butonuna basın
        Faker faker = new Faker();
        facebookLoginPage.fbEmail.sendKeys(faker.internet().emailAddress());
        facebookLoginPage.fbPassword.sendKeys(faker.internet().password());
        extentTest.info("İgili alanlar faker ile dolduruldu.");

        facebookLoginPage.fbLogInbutton.click();


        // 4 - Başarılı giriş yapılmadığını test edin
        Assert.assertTrue(facebookLoginPage.fbnotLogInalert.isDisplayed());
        extentTest.pass("Giriş yapılmadığı test edildi.");

        Driver.closeDriver();
    }
}
