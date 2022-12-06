package tests.day22;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C01_TestNGReports  extends TestBaseRapor{

    @Test
    public void whReusable() throws IOException {
        extentTest = extentReports.createTest("Window Handle","Title ile 2.sayfaya geçiş yapıldığı test edilir.");

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("herokuapp sayfasına gidildi");

        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("Clik Here butonuna tıklandı");

        ReusableMethods.switchToWindow("New Window");

        String expectedTitle = "New WindowS";
        String actualTitle = Driver.getDriver().getTitle();

        System.out.println("Actual Title = " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);
        extentTest.pass("Beklenen değer ve gerçekleşen değer birbirine eşittir");
        ReusableMethods.getScreenshot("WindowSwitch");

        Driver.quitDriver();
    }
}
