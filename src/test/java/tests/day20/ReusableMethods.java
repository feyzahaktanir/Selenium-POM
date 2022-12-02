package tests.day20;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
}
