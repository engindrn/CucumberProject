package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MedunnaUS06_07Page;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;

public class MedunnaUS006StepDefinitions {

    MedunnaUS06_07Page medunnaPage = new MedunnaUS06_07Page();
    Actions actions=new Actions(Driver.getDriver());

    @Given("US06 Kullanici Medunna adresine gider")
    public void kullaniciMedunnaAdresineGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Then("US06 Kullanici Sing in simgesine tiklar")
    public void kullaniciSingInSimgesineTiklar() {
        medunnaPage.SinginSimgesi.click();
    }

    @Then("US06 Kullanici Sing in e tiklar")
    public void kullaniciSingInETiklar() {
        medunnaPage.Singin.click();
    }

    @When("US06 Kullanici {string} girer")
    public void kullaniciGirer(String username) {
        medunnaPage.username.sendKeys(ConfigReader.getProperty("US06username"));
    }

    @Then("US06 Kullanici password {string} girer")
    public void kullaniciPasswordGirer(String password) {
        medunnaPage.password.sendKeys(ConfigReader.getProperty("US06password"));
    }

    @And("US06 Kullanici Sing in butonuna tiklar")
    public void kullaniciSingInButonunaTiklar() {
        medunnaPage.giris.click();
    }

    @And("US06 Kullanici account-menu \\(Efe Efe) tiklar")
    public void kullaniciAccountMenuEfeEfeTiklar() {
        medunnaPage.accountMenu.click();
    }

    @Then("US06 Kullanici Settings i tiklar")
    public void kullaniciSettingsITiklar() {
        medunnaPage.settings.click();
    }


    @Given("US06 User settings sayfasinda oldugunu dogrular")
    public void userSettingsSayfasindaOldugunuDogrular() {
        medunnaPage.settingsTitle.isDisplayed();
    }

    @Then("US06 Firstname kayit olurken girilen firstname ile ayni olmalidir")
    public void firstnameKayitOlurkenGirilenFirstnameIleAyniOlmalidir() {
        String expectedFirstName="Efe";
        String actualFirstName =  medunnaPage.firstname.getAttribute("value");   //atrinutenin degerini aldik
        Assert.assertEquals(actualFirstName,expectedFirstName);

    }

    @And("US06 Lastname kayit olurken girilen lastname ile ayni olmalidir")
    public void lastnameKayitOlurkenGirilenLastnameIleAyniOlmalidir() {
        String expectedLastName= "Ahmet";
        String actualLastName= medunnaPage.lastname.getAttribute("value");
        Assert.assertEquals(actualLastName,expectedLastName);

    }

    @Then("US06 Email kayit olurken girilen email ile ayni olmalidir")
    public void emailKayitOlurkenGirilenEmailIleAyniOlmalidir() {
        String expectedEmail="efe@gmail.com";
        String actualEmail=medunnaPage.email.getAttribute("value");
        Assert.assertEquals(actualEmail,expectedEmail);

    }

    @Given("US06 Kullanici yeni bir firstname girer")
    public void kullaniciYeniBirFirstnameGirer() {

      //  String actualFirstname= medunnaPage.firstname.getAttribute("value");
      //  for (int i = actualFirstname.length()-1; i >=0 ; i--) {                           //once yazili olani sildik
      //      actions.click(medunnaPage.firstname).sendKeys(Keys.BACK_SPACE).perform();     //sendKeys(Keys.CLEAR) calismadi
      //  }

        medunnaPage.firstname.clear();
        medunnaPage.firstname.sendKeys("Zeynep");

    }

    @When("US06 Kullanici save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {
        medunnaPage.saveButton.click();
    }

    @Then("US06 Firstname nin guncellendigini dogrular")
    public void firstnameNinGuncellendiginiDogrular() {
        String expectedResault= "Settings saved!";
       String actualResault= medunnaPage.settingsSaved.getText();
       Assert.assertEquals(actualResault,expectedResault);
    }

    @Given("US06 Kullanici yeni bir lastname girer")
    public void kullaniciYeniBirLastnameGirer() {

       // String actualLastName= medunnaPage.lastname.getAttribute("value");
       // for (int i = actualLastName.length()-1; i >=0 ; i--) {                             //once yazili olani sildik
       //     actions.click(medunnaPage.lastname).sendKeys(Keys.BACK_SPACE).perform();       //sendKeys(Keys.CLEAR) calismadi
      //  }
        medunnaPage.lastname.clear();
        medunnaPage.lastname.sendKeys("Durna");
    }

    @And("US06 Lastname nin guncellendigini dogrular")
    public void lastnameNinGuncellendiginiDogrular() {
        String expectedResault= "Settings saved!";
        String actualResault= medunnaPage.settingsSaved.getText();
        Assert.assertEquals(actualResault,expectedResault);
    }

    @Given("US06 Kullanici yeni bir Email girer")
    public void kullaniciYeniBirEmailGirer() {

      // String actualEmail= medunnaPage.email.getAttribute("value");
      // for (int i = actualEmail.length()-1; i >=0 ; i--) {                             //once yazili olani sildik
      //     actions.click(medunnaPage.email).sendKeys(Keys.BACK_SPACE).perform();       //sendKeys(Keys.CLEAR) calismadi
      // }

        medunnaPage.email.clear();
        medunnaPage.email.sendKeys("zeynepp@gmail.com");

    }

    @And("US06 Email in guncellendigini dogrular")
    public void emailInGuncellendiginiDogrular() {
        String expectedResault= "Settings saved!";
        String actualResault= medunnaPage.settingsSaved.getText();
        Assert.assertEquals(actualResault,expectedResault);
    }

    @When("US06 Kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int beklemeSuresi) {
        try {
            Thread.sleep(beklemeSuresi * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @And("US06 Sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }


//REUSABLE METHOD HALI  (alttakinin)
    // public static String  getValueWithJs(String elementId){
  //     JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
  //     String value=js.executeScript("return document.getElementById('"+elementId+"').value").toString();
  //     return value;
  // }


  // String isim=  medunnaPage.firstname.getAttribute("value");    //atributenin ismini girdik ve degerini aldik
  //     System.out.println("isim ="+isim);                    //html yerine javascript le yazildigi icin oyle gorunuiyor
}


      /*sayfa boyutunu küçültme işlemini */
      // Robot robot = new Robot();
      // for (int i = 0; i <2 ; i++) {
      // robot.keyPress(KeyEvent.VK_CONTROL); //CTRL ye tiklandi
      // robot.keyPress(KeyEvent.VK_SUBTRACT); // - ye tiklandi
      // robot.keyRelease(KeyEvent.VK_SUBTRACT); // CTRL yi birakti
      // robot.keyRelease(KeyEvent.VK_CONTROL); //- yi birakti
      // // CTRL (-) ye basılarak ekran belirlenen miktarda küçültülmüş oldu.
      // }


            /*bekleme*/
        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOf(page.update));
        //  Assert.assertTrue(page.update.isDisplayed());


       //  WebDriverWait wait=new WebDriverWait(Driver.getDriver(),15);
       //   wait.until(ExpectedConditions.visibilityOf(medunnaPage.popUpMessage));
       //        Assert.assertTrue(medunnaPage.popUpMessage.isDisplayed());