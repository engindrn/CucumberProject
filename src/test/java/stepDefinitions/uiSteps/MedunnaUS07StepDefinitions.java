package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.MedunnaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class MedunnaUS07StepDefinitions {
    MedunnaPage medunnaPage = new MedunnaPage();
    Faker faker = new Faker();
    Actions actions=new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();


    @Given("USyedi Hasta Medunna adresine gider")
    public void usyediHastaMedunnaAdresineGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("USyedi Hasta Sing in simgesine tiklar")
    public void usyediHastaSingInSimgesineTiklar() {
        medunnaPage.SinginSimgesi.click();
    }

    @Then("USyedi Hasta Sing in e tiklar")
    public void usyediHastaSingInETiklar() {
        medunnaPage.Singin.click();
    }

    @And("USyedi Hasta Username girer")
    public void usyediHastaUsernameGirer() {
        medunnaPage.username.sendKeys(ConfigReader.getProperty("US07hastausername"));
    }

    @And("USyedi Hasta Password girer")
    public void usyediHastaPasswordGirer() {
        medunnaPage.password.sendKeys(ConfigReader.getProperty("US07hastasifre"));
    }

    @And("USyedi Hasta Sing in butonuna tiklar")
    public void usyediHastaSingInButonunaTiklar() {
        medunnaPage.giris.click();
    }

    @And("USyedi Hasta My Pages\\(PATIENT) e tiklar")
    public void usyediHastaMyPagesPATIENTETiklar() {
        medunnaPage.myPages.click();
    }

    @And("USyedi Hasta Make an Appointment e tiklar")
    public void usyediHastaMakeAnAppointmentETiklar() {
        medunnaPage.makeanappointment.click();
    }

    @And("USyedi Hasta Phone numarasini girer")
    public void usyediHastaPhoneNumarasiniGirer() {
        medunnaPage.phoneNumber.sendKeys("555-555-5555");
    }

    @Given("USyedi Hasta Appointment DateTime e guncel tarihi girer")
    public void usyediHastaAppointmentDateTimeEGuncelTarihiGirer() {


      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate localDate = LocalDate.now();
      medunnaPage.appointmentDate.sendKeys(dtf.format(localDate));


        //sayfaya gidincede guncel tarih girilmis halde geliyor direk randevu al denebilir

        //public void WatchFromDate(){
        //    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //    LocalDate localDate = LocalDate.now();
        //    driver.findElement(fromDate).sendKeys(dtf.format(localDate));
        //}

        /*2.yol*/
     //  LocalDate date= LocalDate.now();
     //  actions.sendKeys(Keys.TAB)
     //          .sendKeys(""+(date.getDayOfMonth()+""))
     //          .sendKeys(""+date.getMonthValue()+"")
     //          .sendKeys("2022")
     //          .perform();


    }

    @Then("USyedi Hasta Send an Appointment Request e tiklar")
    public void usyediHastaSendAnAppointmentRequestETiklar() {
        medunnaPage.sendAnAppointmentRequest.click();
    }

    @Given("USyedi Guncel tarihle randevu talebinin kaydedildigi dogrulanir")
    public void usyediGuncelTarihleRandevuTalebininKaydedildigiDogrulanir() {
        String expectedData = "Appointment registration saved!";
        String actualData = medunnaPage.appointmentRequestSaved.getText();

        Assert.assertEquals(actualData, expectedData);
        //  Assert.assertTrue(medunnaPage.appointmentRequestSaved.isDisplayed());
    }

    @And("USyedi Sayfayi kapatir")
    public void usyediSayfayiKapatir() {
        Driver.closeDriver();
    }

    @Given("USyedi Hasta Appointment DateTime e gelecekte bir tarih girer")
    public void usyediHastaAppointmentDateTimeEGelecekteBirTarihGirer() {
        SimpleDateFormat yeniFormat = new SimpleDateFormat("dd/MM/yyyy");
        String tarih = yeniFormat.format(faker.date().future(100, TimeUnit.DAYS));

        medunnaPage.appointmentDate.sendKeys(tarih);


        /*busekilde format uymadi*/
        //  medunnaPage.appointmentDate.sendKeys((CharSequence) faker.date().future(10 , TimeUnit.DAYS));
        //  System.out.println("tarih " +faker.date().future(1, TimeUnit.DAYS)); //tarih= Fri Nov 25 16:42:35 CET 2022

        /*bu kodla formati degistirdim*/
        // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        // Faker faker = new Faker();
        // String dob = sdf.format(faker.date().birthday());
        // System.out.println(dob);


        /*2.yol*/
       // LocalDate date= LocalDate.now();
       // actions.sendKeys(Keys.TAB)
       //         .sendKeys(""+(date.getDayOfMonth()+2))
       //         .sendKeys(""+date.getMonthValue()+"")
       //         .sendKeys("2022")
       //         .perform();
    }

    @Given("USyedi Gelecekteki tarihle randevu talebinin kaydedildigi dogrulanir")
    public void usyediGelecektekiTarihleRandevuTalebininKaydedildigiDogrulanir() {
        String expectedData = "Appointment registration saved!";
        String actualData = medunnaPage.appointmentRequestSaved.getText();

        Assert.assertEquals(actualData, expectedData);
        //  Assert.assertTrue(medunnaPage.appointmentRequestSaved.isDisplayed());
    }

    @Given("USyedi Hasta Appointment DateTime e gecmis bir tarih girer")
    public void usyediHastaAppointmentDateTimeEGecmisBirTarihGirer() {
        SimpleDateFormat yeniFormat = new SimpleDateFormat("dd/MM/yyyy");
        String tarih = yeniFormat.format(faker.date().past(20, TimeUnit.DAYS));

        medunnaPage.appointmentDate.sendKeys(tarih);

    }

    @Given("USyedi Gecmis tarihle randevu talebinin olusturalamadigi dogrulanir")
    public void usyediGecmisTarihleRandevuTalebininOlusturalamadigiDogrulanir() {

        String expectedData = "Appointment date can not be past date!";
        String actualData = medunnaPage.appointmentRequestSaved.getText(); //appointment request saved! bug var

        softAssert.assertEquals(actualData, expectedData);                //bilerek hata alip hooks la foto aldim
        softAssert.assertAll();                                         //normalde equals degil

    }


    @And("USyedi Kullanici {int} saniye bekler")
    public void usKullaniciIntSaniyeBekler(int beklemeSuresi) {
        try {
            Thread.sleep(beklemeSuresi * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("USyedi Hasta Appointment DateTime e GUN-AY-YIL formatta tarihi girer")
    public void usyediHastaAppointmentDateTimeEGUNAYYILFormattaTarihiGirer() {

        SimpleDateFormat yeniFormat = new SimpleDateFormat("dd/MM/yyyy");
        String tarih = yeniFormat.format(faker.date().future(5, TimeUnit.DAYS));

        medunnaPage.appointmentDate.sendKeys(tarih);
        
    }

    @Then("USyedi Formatin GUN-AY-YIL seklinde oldugu dogrulanir")
    public void usyediFormatinGUNAYYILSeklindeOlduguDogrulanir() {
        Assert.assertEquals(0,medunnaPage.uyariMesaji.size());
        System.out.println(medunnaPage.uyariMesaji.size());

        /*web elementin textini list olarak alip size dan o an sayfada olup olmadigina baktik size 0 ise sayfada yok */

    }

    @Given("USyedi Hasta Appointment DateTime e  AY-GUN-YIL formatta tarihi girer")
    public void usyediHastaAppointmentDateTimeEAYGUNYILFormattaTarihiGirer() {
        medunnaPage.appointmentDate.sendKeys("01-31-2022");
    }

    @Then("USyedi Formatin AY-GUN-YIL seklinde olmadigi dogrulanir")
    public void usyediFormatinAYGUNYILSeklindeOlmadigiDogrulanir() {
        Assert.assertEquals(1,medunnaPage.uyariMesaji.size());
        System.out.println(medunnaPage.uyariMesaji.size());


    }
}
