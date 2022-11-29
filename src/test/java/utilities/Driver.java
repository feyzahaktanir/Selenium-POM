package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();

        //bu if sayesinde kod çalışırken bir kere new keyword ile driver oluşturcak,
        // diğer kullanımlarda new devreye girmicek
        if (driver == null) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        //buraya koymamız gerekiyor, yoksa tekrar açamadığı için kapatırken hata verir.
        //açılmayan sayfayı kapatamazsın
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
