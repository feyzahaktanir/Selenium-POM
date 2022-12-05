package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel {
    @Test
    public void test1() throws IOException {
        //ulkeler exceline 5. sütun olarak NUFUS sütunu ekleyelim
        //3.satırdaki ülkenin nüfusunu 1000000 yapalım

        //1-dosyaya ulaşalım
        String path = "src/test/java/resources/test.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        //2-class'da çalışmak için dosyanın bir kopyası olan workbook oluşturalım
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //3-dosyada yapmak istediğimiz değişiklikleri kopya workbook'ta yapalım
        //ilk satırın 5.hücresine  NUFUS başlığını yazdıralım
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");

        //3.satırdaki ülkenin nüfusunu 1000000 yapalım
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1000000");

        //4-kopyaya yaptığımız değişiklikleri ana dosyaya kaydedelim
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos); //EXCEL'İN KAPALI OLDUĞUNDAN EMN OL YOKSA DOSYAYI BOZAR.

    }
}
