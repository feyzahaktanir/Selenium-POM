package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

import javax.swing.*;

public class C02_PageFirstClass {

    //POM'da farklı classlara farklı şekillerde ulaşılması benimsenmiştir.
    //Driver class için static yöntemi kullanıyoruz
    //Page class için ise obje üzerinden kullanılması tercih edilmiştir

    @Test
    public void test1() throws InterruptedException {
        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //arama kutusuna Nutella yazıp aratalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        //arama sonuçlarının Nutella içerdiğini test edelim
        String actualresultText = amazonPage.resultText.getText();
        Assert.assertTrue(actualresultText.contains("Nutella"));

        Driver.closeDriver();
    }

    @Test
    public void test2() throws InterruptedException {

        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //java için arama yapalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Java"+ Keys.ENTER);

        //sonucun java içerdiğini test edelim
        String actualresultText = amazonPage.resultText.getText();
        Assert.assertTrue(actualresultText.contains("Java"));

        Driver.closeDriver();
    }
}
