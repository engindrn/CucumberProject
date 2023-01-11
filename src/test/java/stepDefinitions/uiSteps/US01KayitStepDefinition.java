package stepDefinitions.uiSteps;

import Pojos.Registrant;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.US01RegisterPage;
import utilities.Driver;

public class US01KayitStepDefinition {
    Faker faker = new Faker();
    public static Registrant registrant = new Registrant();

    US01RegisterPage page = new US01RegisterPage();

    @Given("CE kullanici register sayfasinda")
    public void ce_kullanici_register_sayfasinda() {
        Driver.getDriver().get("https://medunna.com/account/register");
    }

    @Given("CE kullanici ssn  girer")
    public void ce_kullanici_ssn_girer() {
        String ssn = faker.idNumber().ssnValid();
        System.out.println("ssn = " + ssn);
        registrant.setSsn(ssn);

        page.ssnBox.sendKeys(ssn);
        //Driver.waitAndSendText(page.ssnBox, ssn);      //ibrahim hocanin driver clasindan methodlar
    }

    @Given("CE kullanici firstName ve lastName girer")
    public void ce_kullanici_first_name_ve_last_name_girer() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        registrant.setFirstName(firstName);                   //pojo classa set ettık
        registrant.setLastName(lastName);

        page.firstName.sendKeys(firstName);
        page.lastName.sendKeys(lastName);

      //  Driver.waitAndSendText(page.firstNameBox, firstName);
      //  Driver.waitAndSendText(page.lastNameBox, lastName);
    }

    @Given("CE kullanici usrname olarak girer")
    public void ce_kullanici_usrname_olarak_girer() {
        String userName = registrant.getFirstName() + registrant.getLastName();
        registrant.setLogin(userName);

        page.username.sendKeys(userName);
        
      //  Driver.waitAndSendText(page.usernameBox, userName);
        
    }

    @Given("CE kullanici email olarak girer")
    public void ce_kullanici_email_olarak_girer() {
        String email = registrant.getLogin() + "@gmail.com";
        registrant.setEmail(email);
        
        page.email.sendKeys(email);

      //  Driver.waitAndSendText(page.emailBox, email);
    }

    @Given("CE kullanici firstpassword olarak girer")
    public void ce_kullanici_firstpassword_olarak_girer() {
        String firstPassword = faker.internet().password(4, 30, true, true, true);
        registrant.setPassword(firstPassword);

        page.firstPassword.sendKeys(firstPassword);
        
     //  Driver.waitAndSendText(page.firstPasswordBox, firstPassword);
    }

    @Given("CE kullanici secondpassword girer")
    public void ce_kullanici_secondpassword_girer() {
        String secondPassword = registrant.getPassword();

        page.secondPassword.sendKeys(secondPassword);
        
      //  Driver.waitAndSendText(page.secondPasswordBox, secondPassword, 5);
        
    }

    @Then("CE register butonuna tiklar")
    public void ce_register_butonuna_tiklar () {
        page.registerSubmitButton.click();
        
       // Driver.waitAndClick(page.registerSubmitButton);
    }

    @Then("CE tum datayi okur")
    public void ceTumDatayiOkur() {
    }
}