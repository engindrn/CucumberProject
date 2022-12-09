

//package stepDefinitions;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import utilities.ConfigReader;
//import utilities.DatabaseUtility;
//import utilities.Driver;
//import java.io.IOException;
//import static baseUrl.api.MedunnaBaseUrl.medunnaSetup;
//public class Hooks {
//    //    What is hooks class in cucumber?
////    hooks has Before and After annotations.
////    hooks will run Before and After each Scenario
////    What is in your After in the hooks?
////    -In cucumber hooks I use reports and I take screenshot
////    -I designed my hooks. It takes screenshot when a test scenario fails.
//    @Before(order=2, value="@UIlogin")
//    public void beforeScenario() {
//        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//    }
//    @Before(order=3, value="@UIregistration")
//    public void beforeRegistration() {
//        Driver.getDriver().get("https://medunna.com/account/register");
//    }
//    @Before(order=3, value="@UIAppointment")
//    public void appointment() {
//        Driver.getDriver().get("https://medunna.com");
//    }
//    @Before(order=4, value="@APIRoomsGet")
//    public void beforeApi() {
//        medunnaSetup();
//    }
//    @Before(value ="@RoomGet" )
//    public void beforeRoomApi() {
//        medunnaSetup();
//    }
//    @Before(value ="@EndTOEnd" )
//    public void setUpDatabaseConnection() {
//        DatabaseUtility.createConnection(ConfigReader.getProperty("database_url"),
//                ConfigReader.getProperty("database_username"),
//                ConfigReader.getProperty("database_password"));
//    }
//    @Before(order=4, value="@DBtesting" )
//    public void beforeDatabase() {
//        DatabaseUtility.createConnection(ConfigReader.getProperty("db_credentials_url"),
//                ConfigReader.getProperty("db_username"),
//                ConfigReader.getProperty("db_password"));
//    }
//    @After(order=3, value="@UIregistration")
//    public void tearDown(Scenario scenario) throws IOException {
//        System.out.println();
////////        System.out.println("This is hooks after method");
////////        Getting the screenshot: getScreenshotAs method takes the screenshot
////        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//////       Attaching the screenshot to the scenarios in the default-cucumber-reports.html
////
////        if (scenario.isFailed()) {
////            scenario.attach(screenshot, "image/png", "Screenshot");
////        }
//    }
//}
//

//package stepDefinitions;
//import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import utilities.Driver;
//
//public class Hooks {
//
//    /* cucumburda stepDefinition package si içerisinde @Before @After gibi bir notasyon varsa
//       extends testbase dememize gerek kalmadan her scenariodan önce ve/veya sonra bu methodlar calisacaktir
//
//       Buda bizim isteyeceğimiz bir durum değildir
//
//       cucuburda @before @after kullanimina ihtiyac olursa bunu stepDefinition packagesi altında oluşturacağımız
//       hooks class ına koyariz
//
//       biz her senaryodan sonra test sonucunu kontrol edip faild olan scenariolar için screenschoot alması
//       amacıyşa @After notasyonu kullanacagız*/
//
//    //BU RAPORU ALABILMEK ICIN RUNNER CLASSINDAN CALISTIRMAMIZ GEREKIR
//
//
//    @After
//    public void tearDown(Scenario scenario) {
//        final byte[] screenshot = ((TakesScreenshot)
//                Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//        if (scenario.isFailed()) {
//            scenario.attach(screenshot, "image/png", "screenshots");
//        }
//        // Driver.closeDriver();
//    }
//}



package stepDefinitions;

        import io.cucumber.java.After;
        import io.cucumber.java.Scenario;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import utilities.Driver;

public class Hooks {
    @After
    public void tearDown(Scenario scenario) {

        final byte[] screenshot;
        if (scenario.isFailed()) {
            screenshot = ((TakesScreenshot)
                    Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
            Driver.closeDriver();
        }
    }
}

    //bu sekilde hertestten sonra sadece hata alinca resim alip kapatir. her test biterken data api da
         //tekrar driver sayfa acmaz

