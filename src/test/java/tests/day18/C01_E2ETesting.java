package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.security.Key;

public class C01_E2ETesting {

    // 1. birtest packageının altına class oluşturun: CreateHotel
    // 2. bir metod oluşturun: createHotel
    @Test
    public void createHotel(){
        // 3. https://www.hotelmycamp.com adresine git
        // 4. username textbox ve password textboxlarını locate edin
        // 5. giriş yapın
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.logIn();

        // 6. Hotel Management / Hotel List menüsünden ADD HOTEL butonuna tıklayın.
        hotelMyCampPage.hmcHotelManagementLink.click();
        hotelMyCampPage.hmcHotelList.click();
        hotelMyCampPage.hmcAddHotel.click();

        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.click(hotelMyCampPage.chotelCode)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        Select select = new Select(hotelMyCampPage.chotelIDGroup);
        select.selectByVisibleText("Hotel Type2");

        // 8. save butonuna tıklayın
        hotelMyCampPage.chotelSAVE.click();
        hotelMyCampPage.wait(2);


        // 9. "Hotel was inserted successfully" textinin göründüğünü test edin
        Assert.assertTrue(hotelMyCampPage.chotelAlert.getText().contains("Hotel was inserted successfully"));

        // 10. OK butonunaa tıklayın
        hotelMyCampPage.chotelAlertAccept.click();

        Driver.closeDriver();
    }
}
