package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoqaPage {

    public DemoqaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='rt-tr']")
    public WebElement headerWE;

    @FindBy(xpath = "//div[@class='rt-th rt-resizable-header -cursor-pointer']")
    public List<WebElement> header2WE;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    public WebElement bodyWE;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    public List<WebElement> body2WE;

    @FindBy(xpath = "//div[@class='rt-td']")
    public List<WebElement> cellWE;

    @FindBy(xpath = "//div[@class='rt-tr-group']")
    public List<WebElement> rowWE;

    public void rowCaller(int row){
        int rowCount = rowWE.size();
        String dinamikXpath;
        WebElement tempElement;
        System.out.println(header2WE.get(row-1).getText());
        for (int i=1; i<=rowCount; i++){
            dinamikXpath = "((//div[@class='rt-tr-group'])[" + i + "]//div[@class='rt-td'])[" + row + "]";
            tempElement = Driver.getDriver().findElement(By.xpath(dinamikXpath));
            System.out.println(tempElement.getText());
        }
    }

    public void cell2cellCaller(String name){
        int rowCount = rowWE.size();
        String dinamikXpath;
        String rowinname;
        String salary;
        WebElement tempElement;

        for (int i=1; i<=rowCount; i++){
            dinamikXpath = "((//div[@class='rt-tr-group'])[" + i + "]//div[@class='rt-td'])[" + 1 + "]";
            rowinname = Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();
            dinamikXpath = "((//div[@class='rt-tr-group'])[" + i + "]//div[@class='rt-td'])[" + 5 + "]";
            salary = Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();
            if (rowinname.equals(name)){
                System.out.println(name + "'s Salary: " + salary);
            }
        }
    }

    public void cellCaller(int row, int column){
        WebElement dinamikXpath = Driver.getDriver().findElement(By.xpath("((//div[@class='rt-tr-group'])[" + row + "]//div[@class='rt-td'])[" + column + "]"));
        System.out.println(row+".satır, "+column+".sütundaki data: " + dinamikXpath.getText());

    }
}
