package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_SatırSayisi {

    @Test
    public void test1() throws IOException {
        //test excelindeki sayfa1 ve sayfa2deki satır sayılarını
        // ve kullanılan satır sayılarını bulun

        String path = "src/test/java/resources/test.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        int sayfa1rowCount = workbook.getSheet("Sayfa1").getLastRowNum();
        int sayfa1FizikiKullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        System.out.println("sayfa1rowCount = " + sayfa1rowCount);
        System.out.println("sayfa1FizikiKullanilanSatirSayisi = " + sayfa1FizikiKullanilanSatirSayisi);
        //fiziki kullanılan satır sayısı index ile değil sayma sayıları ile çalışır.

        int sayfa2rowCount = workbook.getSheet("Sayfa2").getLastRowNum();
        int sayfa2FizikiKullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("sayfa2rowCount = " + sayfa2rowCount);
        System.out.println("sayfa2FizikiKullanilanSatirSayisi = " + sayfa2FizikiKullanilanSatirSayisi);
    }
}
