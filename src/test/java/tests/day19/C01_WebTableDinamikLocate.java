package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_WebTableDinamikLocate {

    // 3 test metodu oluşturalım

    HotelMyCampPage hotelMyCampPage;

    //      1-satır numarası verdiğimde bana o satırdaki dataları yazdırsın
    @Test
    public void rowCaller(){
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.logIn();
        WebElement thirdRow = hotelMyCampPage.rowCall(3);
        System.out.println("3.Row = " + thirdRow.getText());

        Driver.closeDriver();

    }

    //      2-satır no ve data numarası girdiğimde verdiğim datayı yazdırsın
    @Test
    public void cellCaller(){
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.logIn();
        System.out.println("2.satırın 4.hücresi = " + hotelMyCampPage.cellCall(2,4));
    }

    //      3-sütun numarası verdiğimde bana tüm sütunu yazdırsın
    @Test
    public void columnCaller(){
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.logIn();
        hotelMyCampPage.columnCall(2);
    }
}
