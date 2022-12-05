package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class C02_WebTableDemoqa {

    DemoqaPage demoqaPage;

    @Test (groups = {"Smoke", "Regression"})
    public void demoqaTest(){
        // 1. "https://demoqa.com/webtables" sayfasına gidin.
        Driver.getDriver().get(ConfigReader.getProperty("demoqaURL"));

        demoqaPage = new DemoqaPage();

        // 2. Headers da bulunan departman isimlerini yazdırın.
        //      normalde //thead//th olurdu ancak bu tablo class isimleriyle organize edilmiş
        System.out.println("Başlık Satırı: " + demoqaPage.headerWE.getText());

        //      ikinci yöntem olarak başlıkları bir listeye koyabilirim.
        List<WebElement> allHeaderTitles = demoqaPage.header2WE;
        for (WebElement each: allHeaderTitles
             ) {
            System.out.println("All Header Title = " + each.getText());
        }

        // 3. 3.sütunun başlığını yazdırın
        System.out.println("3.sütun başlığı :" + demoqaPage.header2WE.get(2).getText());

        // 4. Tablodaki tüm dataları yazdırın
        System.out.println("All Body Element : \n" + demoqaPage.bodyWE.getText());

        //   ya da :
        List<WebElement> allbody = demoqaPage.body2WE;
        for (WebElement each: allbody
             ) {
            System.out.println(each.getText());
        }

        // 5. Tabloda kaç cell(data) olduğunu yazdırın
        System.out.println("Data sayısı : " + demoqaPage.cellWE.size());

        // 6. Tablodaki satır sayısnı yazdırın
        System.out.println("Satır sayısı : " + demoqaPage.rowWE.size());

        // 7. Tablodaki sütun sayısını yazdırın
        System.out.println("Sütun sayısı : " + demoqaPage.header2WE.size());

        // 8. Tabloda 3.kolonu yazdırın
        demoqaPage.rowCaller(3);

        // 9. Tabloda "First Name" i Kierra olan kişinin Salary'sini yazdırın
        //      isme göre maaşı getirecek
        demoqaPage.cell2cellCaller("Kierra");

        // 10. Page sayfasında bir metod oluşturun, Test sayfasından satır ve sütun sayısı girdiğimde bana datayı yazdırsın
        demoqaPage.cellCaller(2,3);

    }
}
