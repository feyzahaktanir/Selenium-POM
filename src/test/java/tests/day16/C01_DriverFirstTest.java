package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverFirstTest {

    @Test
    public void test1() throws InterruptedException {
        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //amazona gittiğimizi test edelim
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));

        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains("https://www.amazon.com"));

        //Driver.getDriver metodu her çalıştığında
        //driver = new ChromeDriver(); komutundan ötürü yeni bir driver oluşturuyor
        //biz driver class'tan getdriver'ı ilk çalıştırdığımızda new ataması olsun
        //sonraki çalıştırmalarda atama olmasın istiyoruz.
        //bunun için driver = new ChromeDriver(); satırı bir if blogu içine alacağız.
        //Driver.java classına bak
        Driver.closeDriver();
    }

    @Test
    public void test2() throws InterruptedException {
        //bestbuy anasayfaya gidelim
        Driver.getDriver().get("https://www.bestbuy.com");

        //bestbuya gittiğimizi test edelim
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains("https://www.bestbuy.com"));

        Driver.closeDriver();
    }
}
