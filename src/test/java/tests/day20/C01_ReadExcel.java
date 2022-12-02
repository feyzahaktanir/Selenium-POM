package tests.day20;

import org.apache.poi.ss.usermodel.*; //yıldız koyarsan ona ait bütün kütüphaneleri getirir, hepsini tek tek eklemesine gerek kalmaz.
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test1() throws IOException {

        String path = "src/test/java/resources/test.xlsx";
        FileInputStream fis = new FileInputStream(path);

        //Biz FileInputStream ile okuduğumuz excel dosyasını projemiz içerisinde kullanabilmek için
        //Apachi POI dependency yardımı ile bir Workbook oluşturduk

        //Bu Workbook bizim projemizin içerisinde ülkeler excelinin bir kopyasını kullanmamızı sağlıyor.

        //Excel'in yapısı gereği bir hücreye ulaşabilmek için workbooktan başlayarak
        //sırasıyla sheet, row , cell objelerini oluşturmamız gerekiyor

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(4);
        Cell cell = row.getCell(2);

        System.out.println("cell = " + cell);

        //indexi 4 olan satırdaki indexi 2 olan hücrenin Andorra olduğunu test ediniz.

        String expectedData = "Andorra";
        Assert.assertEquals(cell.getStringCellValue(), expectedData); //cell, Cell formatında, bunu string'e çevirmemiz lazım.

        row = sheet.getRow(5);
        cell = row.getCell(3);
        System.out.println("cell = " + cell);
        
    }

}
