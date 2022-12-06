package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import java.time.Duration;

public class Driver {

    private Driver(){} //kimse driver classından obje oluşturamaz (SingletonPattern)

    public static WebDriver driver;

    public static WebDriver getDriver(){

        //bu if sayesinde kod çalışırken bir kere new keyword ile driver oluşturcak,
        // diğer kullanımlarda new devreye girmicek
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
//                case "opera":
//                    WebDriverManager.operadriver().setup();
//                    driver = new OperaDriver();
//                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void closeDriver() {
        //buraya koymamız gerekiyor, yoksa tekrar açamadığı için kapatırken hata verir.
        //açılmayan sayfayı kapatamazsın
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
