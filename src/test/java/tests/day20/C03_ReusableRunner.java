package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusableRunner {

    @Test
    public void test1(){
        //test excelindeki Sayfa1'de 11.index'teki satırın, 2.index'teki hücresinin Azerbaycan olduğunu test edin

        String path = "src/test/java/resources/test.xlsx";
        String expectedData = "Azerbaycan";
        String actualData = ReusableMethods_Excel.cellCaller(path, "Sayfa1", 11, 2).toString();
        Assert.assertEquals(actualData, expectedData);
    }
}
