package tests.day16;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.Driver;

import javax.swing.*;

public class C03_FacebookLogin {



    @Test ( groups = {"Miniregression", "Regression"})
    public void facebookTest() throws InterruptedException {
        // 1 - https://www.facebook.com adresine gidin
        Driver.getDriver().get("https://www.facebook.com");

        // 2 - POM'a uygun olarak email, şifre kutularını ve giriş yap butonunu locate edin.
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage();

        // 3 - Faker kullanarak email ve şifre değerlerini yazdırıp giriş butonuna basın
        Faker faker = new Faker();
        facebookLoginPage.fbEmail.sendKeys(faker.internet().emailAddress());
        facebookLoginPage.fbPassword.sendKeys(faker.internet().password());
        facebookLoginPage.fbLogInbutton.click();

        // 4 - Başarılı giriş yapılmadığını test edin
        Assert.assertTrue(facebookLoginPage.fbnotLogInalert.isDisplayed());

        Driver.closeDriver();
    }

}
