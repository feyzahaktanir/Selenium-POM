package tests.day20;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ReusableMethods {
    //bir metod oluşturulam
    //dosya yolu ve satır, hücre indexini verince hücre bilgisini döndürsün

    public static Cell cellCaller(String path, String pageName, int rowIndex, int cellIndex){
        Cell cell = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path); //exception değil de surround to trycatch dersen metodu kullandığında exception fırlatmak istemez.
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            cell = workbook.getSheet(pageName).getRow(rowIndex).getCell(cellIndex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cell;
    }


    public static Map<String,String> createMAP(String path, String pageName){
        Map<String,String> excelMap = new HashMap();
        //Map<String,String> excelMap = new TreeMap(); //map şeklini değiştirdik
       // Map<String,String> excelMap = new IdentityHashMap<>();

        Workbook workbook = null;

        //1.excele ulaşalım
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int rowCount = workbook.getSheet(pageName).getLastRowNum();
        String key = "";
        String value = "";

        for (int i = 0; i < rowCount; i++) {

            //2.tablodaki hucreleri map'e uygun hale dönüştürmek
            key = workbook.getSheet(pageName).getRow(i).getCell(0).toString();
            value = workbook.getSheet(pageName).getRow(i).getCell(1).toString() +
                    ", " + workbook.getSheet(pageName).getRow(i).getCell(2).toString() +
                    ", " + workbook.getSheet(pageName).getRow(i).getCell(3).toString();

            //3. key-value haline getirddiğimiz satırları map'e eklemek
            excelMap.put(key,value);
        }
        return excelMap;
    }
}
