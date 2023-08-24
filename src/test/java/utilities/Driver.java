package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver() {  //bu klassdan obje oluşturulup kullanılmasını engellmek için singletor patten yaptık yani
    }                   //parametresiz private bir contracter oluşturup burdakini (görünmeyen) iptal ettik
    //artık başks classdan obje oluşturarak ulaşılamaz sadece Driver.getDriver() methodu ile ulaşılır

    static WebDriver driver;


    /*
    Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu için her test methodu
    için yeni bir pencere(driver) açıyor. Eğer driver'a bir değer atanmamışsa yani driver==null ise
    bir kere driver'i çalıştır diyerek bir kere if içini çalıştıracak. Ve driver artık bir kere
    çalıştığı için ve değer atandığı için null olmayacak ve direk return edecek ve diğer
    teslerimiz aynı pencere(driver) üzerinde çalışacak
     */

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")){    //hangi browserda çalıştıracaksak properties claasında
                //bulunan browser key ine value olr case i ekleriz.
                //ConfigReader bize configuration.properties file indan key i
                //browser olan value yu getir dedik.
                case "chrome":
                    //  WebDriverManager.edgedriver().setup();  seleniumu 4.11 yaptik buna gerek kalmadi
                    driver=new ChromeDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "safari" :
                    driver=new SafariDriver();
                    break;
                case "headless-chrome":
                    ChromeOptions chromeOptions= new ChromeOptions();
                    chromeOptions.addArguments("--headless=new");
                    driver=new ChromeDriver(chromeOptions);
                    break;
                default:
                    //hiçbiri seçili değilse choreme çalışır
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) { // driver'a değer atanmışsa kapat
            driver.close();
            driver = null; // Kapandıktan sonra sonraki açmaları garanti altına almak için driver'i tekrar null yaptık
        }
    }
    public static void quitDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }
}