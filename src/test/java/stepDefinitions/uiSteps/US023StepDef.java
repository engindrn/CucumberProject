package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.US023Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.io.IOException;

public class US023StepDef {

    US023Page medunna = new US023Page();

    Select select;

    @Given("USyirmiuc Doktor Medunna adresine gider")
    public void usyirmiucDoktorMedunnaAdresineGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("USyirmiuc Doktor Sing in simgesine tiklar")
    public void usyirmiucDoktorSingInSimgesineTiklar() {
        medunna.SinginSimgesi.click();
    }

    @And("USyirmiuc Doktor Sing in e tiklar")
    public void usyirmiucDoktorSingInETiklar() {
        medunna.Singin.click();
    }

    @And("USyirmiuc Doktor Username girer")
    public void usyirmiucDoktorUsernameGirer() {
        medunna.username.sendKeys(ConfigReader.getProperty("US023doktorusername"));
    }

    @And("USyirmiuc Doktor Password girer")
    public void usyirmiucDoktorPasswordGirer() {
        medunna.password.sendKeys(ConfigReader.getProperty("US023doktorsifre"));
    }

    @And("USyirmiuc Doktor Sing in butonuna tiklar")
    public void usyirmiucDoktorSingInButonunaTiklar() {
        medunna.giris.click();
    }

    @And("USyirmiuc Doktor My Page butonuna tiklar")
    public void usyirmiucDoktorMyPageButonunaTiklar() {
        medunna.myPage.click();

    }

    @And("USyirmiuc Doktor My Page sekmesinden My Appointments butonuna tiklar")
    public void usyirmiucDoktorMyPageSekmesindenMyAppointmentsButonunaTiklar() {
    medunna.myAppointments.click();
    }

    @And("USyirmiuc Doktor islemleri tamamlanan hastasi icin Edit butonuna tiklar")
    public void usyirmiucDoktorIslemleriTamamlananHastasiIcinEditButonunaTiklar() {
        medunna.edit.click();
    }

    @And("USyirmiuc Doktor status u Completed olarak secer")
    public void usyirmiucDoktorStatusUCompletedOlarakSecer() throws IOException {
        ReusableMethods.waitFor(2);
        ReusableMethods.jsScroll(medunna.tumSayfa);
        select=new Select(medunna.appointmentStatus);
        select.selectByVisibleText("COMPLETED");
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("US023 Status Dogrulama");


      // Select select1 =new Select(medunna.appointmentStatus);
      // select.selectByVisibleText("PENDING");

    }

    @And("USyirmiuc Doktor Save butonuna tiklar")
    public void usyirmiucDoktorSaveButonunaTiklar() {
    ReusableMethods.jsScrollClick(medunna.save);

    }

    @And("USyirmiuc Status u Completed olarak degistigini dogrular")
    public void usyirmiucStatusUCompletedOlarakDegistiginiDogrular() {
        Assert.assertEquals("COMPLETED",select.getFirstSelectedOption().getText());

    }

    @And("USyirmiuc sayfayi kapatir")
    public void usyirmiucSayfayiKapatir() {
      Driver.closeDriver();
    }

    @Given("USyirmiuc Personel Medunna adresine gider")
    public void usyirmiucPersonelMedunnaAdresineGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("USyirmiuc Personel Sing in simgesine tiklar")
    public void usyirmiucPersonelSingInSimgesineTiklar() {
        medunna.SinginSimgesi.click();
    }

    @And("USyirmiuc Personel Sing in e tiklar")
    public void usyirmiucPersonelSingInETiklar() {
        medunna.Singin.click();
    }

    @And("USyirmiuc Personel Username girer")
    public void usyirmiucPersonelUsernameGirer() {
        medunna.username.sendKeys(ConfigReader.getProperty("US023personelusername"));
    }

    @And("USyirmiuc Personel Password girer")
    public void usyirmiucPersonelPasswordGirer() {
        medunna.password.sendKeys(ConfigReader.getProperty("US023personelsifre"));
    }

    @And("USyirmiuc Personel Sing in butonuna tiklar")
    public void usyirmiucPersonelSingInButonunaTiklar() {
        medunna.giris.click();
    }

    @And("USyirmiuc Personel My Page sekmesine tiklar")
    public void usyirmiucPersonelMyPageSekmesineTiklar() {
        medunna.myPage.click();
    }

    @And("USyirmiuc Personel My Page sekmesinde Search Patient sekmesine tiklar")
    public void usyirmiucPersonelMyPageSekmesindeSearchPatientSekmesineTiklar() {
        medunna.searchPatient.click();
    }

    @And("USyirmiuc Personel Patient SSN searchbox a hastanin SSN numarasini girer")
    public void usyirmiucPersonelPatientSSNSearchboxAHastaninSSNNumarasiniGirer() {
        medunna.patientSsn.sendKeys("500-10-5002");
    }

    @And("USyirmiuc Personel Show Appointments kutucugunu tiklar")
    public void usyirmiucPersonelShowAppointmentsKutucugunuTiklar() throws AWTException {
       // ReusableMethods.sayfaKucult();
        ReusableMethods.waitFor(2);
        medunna.showappointments.click();

    }

    @And("USyirmiuc Personel Cencelled olacak rendevu icin Edit e tiklar")
    public void usyirmiucPersonelCencelledOlacakRendevuIcinEditETiklar() {
        ReusableMethods.jsScrollClick(medunna.appointmentEdit);
    }

    @And("USyirmiuc Personel Status u Cancelled olarak ayarlar")
    public void usyirmiucPersonelStatusUCancelledOlarakAyarlar() {
        ReusableMethods.waitFor(2);
        ReusableMethods.jsScroll(medunna.tumSayfa);
        Select select=new Select(medunna.appointmentStatus);
        select.selectByVisibleText("CANCELLED");
    }

    @And("USyirmiuc Personel Save buttonuna basar")
    public void usyirmiucPersonelSaveButtonunaBasar() {
        ReusableMethods.jsScrollClick(medunna.save);
    }

    @And("USyirmiuc Status u Cancelled olarak degistigini dogrular")
    public void usyirmiucStatusUCancelledOlarakDegistiginiDogrular() {
        medunna.dogrulamaMesaji.isDisplayed();
    }

    @And("USyirmiuc Statusu Cancelled olan hastada Payment Invoice Process  olmadigini dogrula")
    public void usyirmiucStatusuCancelledOlanHastadaPaymentInvoiceProcessOlmadiginiDogrula() {
        Assert.assertFalse(medunna.paymentbutondogrulama.contains("Payment / Invoice Process"));
    }

    @And("USyirmiuc Statusu Completed olan hastada Payment Invoice Process i tiklar")
    public void usyirmiucStatusuCompletedOlanHastadaPaymentInvoiceProcessITiklar() {
            ReusableMethods.jsScrollClick(medunna.paymentInvoiceProcess);
    }

    @And("USyirmiuc Personel Patment Detail i gorur")
    public void usyirmiucPersonelPatmentDetailIGorur() {
        Assert.assertTrue(medunna.paymentDetail.isDisplayed());
    }

    @And("USyirmiuc Personel Show Invoice tiklar")
    public void usyirmiucPersonelShowInvoiceTiklar() {
        medunna.showInvoice.click();
    }

    @And("USyirmiuc Personel hastaya gondereilen faturayi gorur")
    public void usyirmiucPersonelHastayaGondereilenFaturayiGorur() {
        Assert.assertTrue(medunna.invoice.isDisplayed());
    }

    @And("USyirmiuc Statusu Completed olan hastada icin Creat Invoice butonu olmadigini dogrular")
    public void usyirmiucStatusuCompletedOlanHastadaIcinCreatInvoiceButonuOlmadiginiDogrular() {
        Assert.assertFalse(medunna.paymentbutondogrulama.contains("Creat Invoice"));
    }

    @And("USyirmiuc Kullanici {int} saniye bekler")
    public void usyirmiucKullaniciIntSaniyeBekler(int beklemeSuresi) {
        try {
            Thread.sleep(beklemeSuresi * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
