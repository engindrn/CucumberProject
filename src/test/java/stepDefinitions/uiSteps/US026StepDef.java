package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.US026Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class US026StepDef {

    US026Page medunna=new US026Page();

    Actions actions=new Actions(Driver.getDriver());

    Faker faker=new Faker();

    @Given("USyirmiAlti Hasta Medunna adresine gider")
    public void usyirmialtiHastaMedunnaAdresineGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("USyirmiAlti Hasta Sing in simgesine tiklar")
    public void usyirmialtiHastaSingInSimgesineTiklar() {
        medunna.SinginSimgesi.click();
    }

    @Then("USyirmiAlti Hasta Sing in e tiklar")
    public void usyirmialtiHastaSingInETiklar() {
        medunna.Singin.click();
    }

    @And("USyirmiAlti Hasta Username girer")
    public void usyirmialtiHastaUsernameGirer() {
        medunna.username.sendKeys(ConfigReader.getProperty("US07hastausername"));

    }

    @And("USyirmiAlti Hasta Password girer")
    public void usyirmialtiHastaPasswordGirer() {
        medunna.password.sendKeys(ConfigReader.getProperty("US07hastasifre"));
    }

    @And("USyirmiAlti Hasta Sing in butonuna tiklar")
    public void usyirmialtiHastaSingInButonunaTiklar() {
          medunna.giris.click();
    }

    @And("USyirmiAlti Hasta Contact a tiklar")
    public void usyirmialtiHastaContactATiklar() {
        ReusableMethods.waitForClickablility(medunna.contact,15);
        medunna.contact.click();


        //  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        //  wait.until(ExpectedConditions.elementToBeClickable(medunna.contact));
        //  medunna.contact.click();

    }
    @Given("USyirmiAlti Contact sayfasinda oldugu dogrulanir")
    public void usyirmialtiContactSayfasindaOlduguDogrulanir() {

        Assert.assertTrue( medunna.contactEnable.isEnabled());


       // String expectedData="https://www.medunna.com/contact";
       // String actualData= Driver.getDriver().getCurrentUrl();
       // Assert.assertEquals(expectedData,actualData);
    }

    @Then("USyirmiAlti Location Email Call bilgileri dogrulanir")
    public void usyirmialtiLocationEmailCallBilgileriDogrulanir() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        List<WebElement> LocEmaCall= medunna.uclu;
        for (WebElement w:   LocEmaCall ) {
            Assert.assertTrue(w.isDisplayed());
        }

      String expectedLocation="575 Eighth Avenue New York, NY 10018";
      String actualLocation=medunna.location.getText();
      Assert.assertEquals(actualLocation,expectedLocation);

      String expectedEmail="contact@medunna.com";
      String actulaEmail=medunna.email.getText();
      Assert.assertEquals(actulaEmail,expectedEmail);

      String expectedCall="+1 (336) 546-5245";
      String actualCall=medunna.call.getText();
      Assert.assertEquals(actualCall,expectedCall);

    }

    @And("USyirmiAlti Mesaj Formunun oldugu dogrulanir")
    public void usyirmialtiMesajFormununOlduguDogrulanir() {
       Assert.assertTrue(medunna.mesajForm.isDisplayed());

    }

    @Given("USyirmiAlti Mesaj formuna {string} ,{string}, {string}, {string} girilir")
    public void usyirmialtiMesajFormunaGirilir(String Name, String Email, String Subject, String Message) {
        Name=faker.name().firstName();
        Email=faker.internet().emailAddress();
        //subject i featureden aldi
        Message=faker.expression("appointment");

        medunna.name.sendKeys(Name);
        medunna.emailsend.sendKeys(Email);
        medunna.subject.sendKeys(Subject);
        medunna.message.sendKeys(Message);

    }

    @Then("USyirmiAlti Send butonuna tiklanir mesaj gonderilir")
    public void usyirmialtiSendButonunaTiklanirMesajGonderilir() {
        medunna.send.click();
    }

    @And("USyirmiAlti Sistem mesaj gonderilme isleminin basariyla tamamlandigina dair bilgi mesaji verir")
    public void usyirmialtiSistemMesajGonderilmeIslemininBasariylaTamamlandiginaDairBilgiMesajiVerir() throws InterruptedException {
        String expectedMessage="Your message has been received";
        String actualMessage= medunna.popUpMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);


    }
    @And("USyirmiAlti Kullanici {int} saniye bekler")
    public void usKullaniciIntSaniyeBekler(int beklemeSuresi) {
        try {
            Thread.sleep(beklemeSuresi * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("USyirmiAlti sayfayi kapatir")
    public void usyirmialtiSayfayiKapatir() {
        Driver.closeDriver();
    }
}
