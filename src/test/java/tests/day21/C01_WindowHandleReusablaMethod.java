package tests.day21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.Set;

public class C01_WindowHandleReusablaMethod {

    @Test
    public void test1(){
        // https://the-internet.herokuapp.com/windows adresine gidelim
        // Click Here butonuna basalım
        // New Window'a geçip title'ın "New Window" olduğunu test edin

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String firstPageWH = Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> handleSet = Driver.getDriver().getWindowHandles();

        String secondPageWH = "";

        for (String each: handleSet
             ) {
            if (!each.equals(firstPageWH)){
                secondPageWH = each;
            }
        }

        Driver.getDriver().switchTo().window(secondPageWH);

        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        System.out.println("firstPageWH = " + firstPageWH);
        System.out.println("secondPageWH = " + secondPageWH);
        System.out.println("Actual Title = " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);

        Driver.closeDriver();
    }


    @Test
    public void whReusable() throws IOException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");

        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        System.out.println("Actual Title = " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);

        ReusableMethods.getScreenshot("WindowSwitch");

        Driver.quitDriver();
    }
}
