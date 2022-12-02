Feature: Registration


        @SmokeTest
        Scenario Outline: Register new users for Medunna  ORNEK

             Given user is on the registration page
             And user enters ssn number as "<SSN>"
             Then user enters firstname and lastname as "<firstname>" and "<lastname>"
             And user provides a username "<username>"
             Then user provides email id as "<email>"
             When user enters the password as "<firstpassword>"
             And user confirms the new password "<secondpassword>"
             Then user clicks on register button and sees the success message as "<message>"
             Then user reads all registrant data
             Examples:
             |SSN|firstname|lastname|username|email|firstpassword|secondpassword|message|
             |563-26-3726|Bahar|trk|sdet|bhrturk@gmail.com|Bhr@123?|Bhr@123?|Registration saved!|
             |564-24-3276|Ali|Veli|ali|ali@gmail.com|ali@123?|ali@123?|Registration saved!|


#        package stepDefinitions;
#        import com.github.javafaker.Faker;
#        import io.cucumber.java.en.Given;
#        import io.cucumber.java.en.Then;
#        import io.cucumber.java.en.When;
#
#        import static utilities.FileWriterForData.saveData
#
#        public class RegistrationSteps {

#        UIRegistrationSmokePage registrationPage = new UIRegistrationSmokePage();   LOCATER BURDA
#        Faker faker = new Faker();

#             @Given("user is on the registration page")
#        public void user_is_on_the_registration_page() {
#        Driver.getDriver().get("https://medunna.com/account/register");
#        }
#             @Given("user enters ssn number as {string}")
#        public void user_enters_ssn_number_as(String ssn) {
#        ssn = faker.idNumber().ssnValid();                     ISTER FAKERDAN ISTER FAKERI SILER FEATUREDEN PARAMETRE OLR
#        registrant = new RegistrantNew();
#        registrant.setSsn(ssn);
#        Driver.waitAndSendText(registrationPage.ssnTextbox,ssn,15);
#        }
#             @Then("user enters firstname and lastname as {string} and {string}")
#        public void user_enters_firstname_and_lastname_as_and(String firstname, String lastname) {
#        firstname = faker.name().firstName();
#        lastname = faker.name().lastName();
#        //save the records into pojo
#        registrant.setFirstName(firstname);
#        registrant.setLastName(lastname);
#        Driver.waitAndSendText(registrationPage.firstnameTextbox,firstname,5);
#        Driver.waitAndSendText(registrationPage.lastnameTextbox,lastname,7);
#        }
#             @Then("user provides a username {string}")
#        public void user_provides_a_username(String username) {
#        username = registrant.getFirstName() + registrant.getLastName();
#        registrant.setLogin(username);
#        Driver.waitAndSendText( registrationPage.usernameTextbox,username,5);
#        }
#             @Then("user provides email id as {string}")
#        public void user_provides_email_id_as(String email) {
#        email = registrant.getLogin() + "@gmail.com";
#        registrant.setEmail(email);
#        Driver.waitAndSendText(registrationPage.emailTextbox,email,5);
#        }
#             @When("user enters the password as {string}")
#        public void user_enters_the_password_as(String firstPassword) {
#        firstPassword = faker.internet().password(8,30,true,true);
#        registrant.setPassword(firstPassword);
#        Driver.waitAndSendText( registrationPage.firstPasswordTextbox,firstPassword,5);
#        }
#             @When("user confirms the new password {string}")
#        public void user_confirms_the_new_password(String secondPassword) {
#        secondPassword = registrant.getPassword();
#        Driver.waitAndSendText(registrationPage.newPasswordTextbox,secondPassword,5);
#        }
#             @Then("user clicks on register button and sees the success message as {string}")
#        public void user_clicks_on_register_button_and_sees_the_success_message_as(String expectedMessage) {
#        Driver.waitAndClick(registrationPage.registerButton);
#        saveData(registrant);
#        }
#             @Then("user reads all registrant data")
#        public void user_reads_all_registrant_data() {
#        }
#        }