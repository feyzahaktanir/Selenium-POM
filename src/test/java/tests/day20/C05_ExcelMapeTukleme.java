package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExcelMapeTukleme {

    @Test
    public void test1(){
        //dosya yolu ve sayfa ismi verilen bir excel sheet'i map olarak kaydden
        //reusable bir method oluşturalım

        String path = "src/test/java/resources/test.xlsx";
        String pageName = "Sayfa1";

        //System.out.println(ReusableMethods.createMAP(path, pageName));

        Map<String,String> ulkeler = ReusableMethods_Excel.createMAP(path, pageName);

        //oluşturduğumuz map'i kullanarak Turkey'in bilgilerni yazdırın
        System.out.println(ulkeler.get("Turkey"));

        //listede netherlands olduğunu test edin
        Assert.assertTrue((ulkeler.containsKey("Netherlands")));
    }
}
