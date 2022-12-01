package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.util.List;

public class C02_WebTables {
    //  //tbody//tr//td[text()='NewYork']  Webtable'da ilgili veriyi bulan xpath

    HotelMyCampPage hotelMyCampPage;

    //1-login() metodunu oluşturun ve oturum açın
    @Test
    public void login (){
        //2-https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //          Username: manager
        //          Password: Manager1!
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.logIn();
    }

    //3-table() metodu oluşturun
    @Test
    public void table(){
        hotelMyCampPage = new HotelMyCampPage();

        //          - Tüm table body'sinin boyutunu (sütun sayısını) bulun /tbody
        List<WebElement> headerDataList = hotelMyCampPage.wtHeaderTitles;
        System.out.println("headerDataList = " + headerDataList.size());

        //          - Table'daki tüm body'i ve başlıkları(headers) konsola yazdırın
        System.out.println(hotelMyCampPage.wtALLtbody.getText()); // bu şekilde tek başına bütün listedeki elementeleri gösterebiliyor.

        //Eğer body'yi tek bir webelement olarak locate edersek
        //içindeki tüm dataları getText() ile yazdırabiliriz.
        //ancak bu durumda bu elementler ayrı ayrı değil
        //body'nin içindeki tek bir String'in parçaları olurlar
        //dolayısıyla bu elementlere tek tek ulaşmamız mumkün olmaz
        //sadece constain method'u ile body'de olup olmadıklarını test edebilriz.
        List<WebElement> tbodytdDataList = hotelMyCampPage.wtALLtbodytd;
        System.out.println("tbodytdDataList = " + tbodytdDataList.size());

        //Eğer her bir datayı ayrı ayrı almak istersek
        // //tbody//td şeklinde locate edip bir list'e atabiliriz.

        Driver.closeDriver();
    }

    //4-printRows() metodu oluşturun //tr
    @Test
    public void printRows(){
        //          - table body'sinde bulunan toplam satır(row) sayısını bulun

        //          - table body'sinde bulunan satırları(rowa) konsolda yazdırın
        //          - 4.satırdaki elemetleri konsolda yazdırın


    }


}
