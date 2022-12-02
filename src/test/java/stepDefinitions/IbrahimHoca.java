//@E2ETest
//Feature: end to end test
//        Scenario Outline: Register new users for GMI Bank
//        Given user is on the registration page
//        And user enters ssn number as "<SSN>"
//        Then user enters firstname and lastname as "<firstname>" and "<lastname>"
//        And user provides a username "<username>"
//        Then user provides email id as "<email>"
//        When user enters the password as "<firstpassword>"
//        And user confirms the new password "<secondpassword>"
//        Then user clicks on register button and sees the success message as "<message>"
//        Then user reads all registrant data
//        Examples:
//        |SSN|firstname|lastname|username|email|firstpassword|secondpassword|message|
//        |563-26-3726|Bahar|trk|sdet|bhrturk@gmail.com|Bhr@123?|Bhr@123?|Registration saved!|


//        Scenario Outline: kullanici db test
//        Given kullanci connection kuarar
//        And Kullanici tum yeni kayitli bilgileri ceker "<query>" ve "<columnName>"
//        Then Kullanici kullanici bilgilerini dogrular
//        Examples: test verileri
//        |query    |columnName|
//        |SELECT * FROM jhi_user|ssn|

//***************************************************************

    //package stepdefinitions.seleniumuisteps;
    //import com.github.javafaker.Faker;
    //import io.cucumber.java.en.Given;
    //import io.cucumber.java.en.Then;
    //import io.cucumber.java.en.When;
    //import org.junit.Assert;
    //import pages.RegistrationPage;
    //import pojos.Registrant;
    //import pojos.RegistrantBatch8687;
    //import pojos.RegistrantNew;
    //import utilities.*;
    //import java.util.List;
    //import static utilities.DatabaseUtility.registrant;
    //import static utilities.FileWriterForData.saveData;

    //public class RegistrationSteps {

    //    RegistrationPage registrationPage = new RegistrationPage();
    //    Faker faker = new Faker();
    //    @Given("user is on the registration page")
    //    public void user_is_on_the_registration_page() {
    //        Driver.getDriver().get("https://medunna.com/account/register");
    //    }
    //    @Given("user enters ssn number as {string}")
    //    public void user_enters_ssn_number_as(String ssn) {
    //        ssn = faker.idNumber().ssnValid();
    //        registrant = new RegistrantNew();
    //        registrant.setSsn(ssn);
    //        Driver.waitAndSendText(registrationPage.ssnTextbox,ssn,15);
    //    }
    //    @Then("user enters firstname and lastname as {string} and {string}")
    //    public void user_enters_firstname_and_lastname_as_and(String firstname, String lastname) {
    //        firstname = faker.name().firstName();
    //        lastname = faker.name().lastName();
    //        //save the records into pojo
    //        registrant.setFirstName(firstname);
    //        registrant.setLastName(lastname);
    //        Driver.waitAndSendText(registrationPage.firstnameTextbox,firstname,5);
    //        Driver.waitAndSendText(registrationPage.lastnameTextbox,lastname,7);
    //    }
    //    @Then("user provides a username {string}")
    //    public void user_provides_a_username(String username) {
    //        username = registrant.getFirstName() + registrant.getLastName();
    //        registrant.setLogin(username);
    //        Driver.waitAndSendText( registrationPage.usernameTextbox,username,5);
    //    }
    //    @Then("user provides email id as {string}")
    //    public void user_provides_email_id_as(String email) {
    //        email = registrant.getLogin() + "@gmail.com";
    //        registrant.setEmail(email);
    //        Driver.waitAndSendText(registrationPage.emailTextbox,email,5);
    //    }
    //    @When("user enters the password as {string}")
    //    public void user_enters_the_password_as(String firstPassword) {
    //        firstPassword = faker.internet().password(8,30,true,true);
    //        registrant.setPassword(firstPassword);
    //        Driver.waitAndSendText( registrationPage.firstPasswordTextbox,firstPassword,5);
    //    }
    //    @When("user confirms the new password {string}")
    //    public void user_confirms_the_new_password(String secondPassword) {
    //        secondPassword = registrant.getPassword();
    //        Driver.waitAndSendText(registrationPage.newPasswordTextbox,secondPassword,5);
    //    }
    //    @Then("user clicks on register button and sees the success message as {string}")
    //    public void user_clicks_on_register_button_and_sees_the_success_message_as(String expectedMessage) {
    //        Driver.waitAndClick(registrationPage.registerButton);
    //        saveData(registrant);
    //    }
    //    @Then("user reads all registrant data")
    //    public void user_reads_all_registrant_data() {
    //    }
    //}
//*************************************************

    //package utilities;
    //import io.github.bonigarcia.wdm.WebDriverManager;
    //import org.openqa.selenium.*;
    //import org.openqa.selenium.chrome.ChromeDriver;
    //import org.openqa.selenium.chrome.ChromeOptions;
    //import org.openqa.selenium.firefox.FirefoxDriver;
    //import org.openqa.selenium.ie.InternetExplorerDriver;
    //import org.openqa.selenium.interactions.Actions;
    //import org.openqa.selenium.support.ui.*;
    //import java.time.Duration;
    //import java.util.*;
    //import java.util.NoSuchElementException;
    //import java.util.concurrent.TimeUnit;
    //public abstract class Driver {
    //    //My Driver class is abstract so I do not create an object of this class
    ////TestBase class is also abstract
    //    private Wait<WebDriver> shortWait;
    //    private static int timeout = 5;
    //    private Driver(){
    //    }
    //    private static WebDriver driver;
    //    public static WebDriver getDriver(){
    //        if(driver==null) {
    //            switch (ConfigReader.getProperty("browser")) {
    //                case "chrome":
    //                    WebDriverManager.chromedriver().setup();
    //                    driver                      = new ChromeDriver();
    //                    //Abstraction ve Inheritance
    //                    break;
    //                case "firefox":
    //                    WebDriverManager.firefoxdriver().setup();
    //                    driver = new FirefoxDriver();
    //                    break;
    //                case "ie":
    //                    WebDriverManager.iedriver().setup();
    //                    driver = new InternetExplorerDriver();
    //                    break;
    //                case "chrome-headless":
    ////                    WebDriverManager.chromedriver().setup();
    ////                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
    //                    WebDriverManager.chromedriver().setup();
    //                    ChromeOptions options = new ChromeOptions();
    //                    options.addArguments("headless");
    //                    options.addArguments("disable-gpu");
    //                    driver = new ChromeDriver(options);
    //                    break;
    //            }
    //        }
    //        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    //        driver.manage().window().maximize();
    //        return driver;
    //    }
    //    public void setDriver() {
    //        ChromeOptions options = new ChromeOptions();
    //        Map<String, Object> prefs = new HashMap<>();
    //        prefs.put("plugins.always_open_pdf_externally", true);
    //        prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
    //        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
    //        options.setExperimentalOption("prefs", prefs);
    //        options.addArguments("start-maximized");
    //        options.addArguments("ignore-certificate-errors");
    //        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    //        this.driver = new ChromeDriver(options);
    //        driver.manage().window().maximize();
    //        shortWait = new FluentWait<WebDriver>(this.driver)
    //                .withTimeout(Duration.ofSeconds(5))
    //                .pollingEvery(Duration.ofMillis(600))
    //                .ignoring(NoSuchElementException.class)
    //                .ignoring(ElementClickInterceptedException.class)
    //                .ignoring(ElementNotVisibleException.class)
    //                .ignoring(StaleElementReferenceException.class);
    //    }
    //    public static void waitAndClick(WebElement element, int timeout) {
    //        for (int i = 0; i < timeout; i++) {
    //            try {
    //                element.click();
    //                return;
    //            } catch (WebDriverException e) {
    //                wait(1);
    //            }
    //        }
    //    }
    //    public static void waitAndClick(WebElement element) {
    //        for (int i = 0; i < timeout; i++) {
    //            try {
    //                element.click();
    //                return;
    //            } catch (WebDriverException e) {
    //                wait(1);
    //            }
    //        }
    //    }
    //    public static void waitAndSendText(WebElement element,String text, int timeout) {
    //        for (int i = 0; i < timeout; i++) {
    //            try {
    //                element.sendKeys(text);
    //                return;
    //            } catch (WebDriverException e) {
    //                wait(1);
    //            }
    //        }
    //    }
    //    public static void waitAndSendText(WebElement element,String text) {
    //        for (int i = 0; i < timeout; i++) {
    //            try {
    //                element.sendKeys(text);
    //                return;
    //            } catch (WebDriverException e) {
    //                wait(1);
    //            }
    //        }
    //    }
    //    public static void waitAndSendTextWithDefaultTime(WebElement element,String text) {
    //        for (int i = 0; i < timeout; i++) {
    //            try {
    //                element.sendKeys(text);
    //                return;
    //            } catch (WebDriverException e) {
    //                wait(1);
    //            }
    //        }
    //    }
    //    public static String waitAndGetText(WebElement element, int timeout) {
    //        String text="";
    //        for (int i = 0; i < timeout; i++) {
    //            try {
    //                text = element.getText();
    //                return text;
    //            } catch (WebDriverException e) {
    //                wait(1);
    //            }
    //        }
    //        return null;
    //    }
    //    //Webdriver
    //    //ChromeDriver
    //    //Iedriver
    //    //FirefoxDriver
    //    public static void wait2(int sec){
    //        try {
    //            Thread.sleep(1000*sec);
    //        }catch (NoSuchElementException e){
    //            e.printStackTrace();
    //        }catch (TimeoutException e){
    //            e.printStackTrace();
    //        }catch (StaleElementReferenceException e){
    //            e.printStackTrace();
    //        }catch (ElementClickInterceptedException e){
    //            e.printStackTrace();
    //        }catch (Exception e){
    //            e.printStackTrace();
    //        }
    //    }
    //    //5 seconds
    //    public static void waitAndClickElement(WebElement element , int seconds){
    //        for (int i = 0; i < seconds ; i++) {
    //            try {
    //                element.click();
    //                break;
    //            }catch (Exception e){
    //                wait2(1);
    //            }
    //        }
    //    }
    //    public static void closeDriver(){
    //        if (driver!=null) {
    //            driver.quit();
    //            driver=null;
    //        }
    //    }
    //    public static void wait(int secs) {
    //        try {
    //            Thread.sleep(1000 * secs);
    //        } catch (InterruptedException e) {
    //            e.printStackTrace();
    //        } catch (TimeoutException e) {
    //            e.printStackTrace();
    //        } catch (NoSuchElementException e) {
    //            e.printStackTrace();
    //        }catch (StaleElementReferenceException e) {
    //            e.printStackTrace();
    //        }catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //    }
    //    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
    //        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
    //        return wait.until(ExpectedConditions.visibilityOf(element));
    //    }
    //    public static WebElement waitForVisibility(By locator, int timeout) {
    //        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
    //        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    //    }
    //    public static Boolean waitForInVisibility(By locator, int timeout) {
    //        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
    //        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    //    }
    //    public static WebElement waitForClickablility(WebElement element, int timeout) {
    //        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
    //        return wait.until(ExpectedConditions.elementToBeClickable(element));
    //    }
    //    public static WebElement waitForClickablility(By locator, int timeout) {
    //        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
    //        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    //    }
    //    public static void waitForPageToLoad(long timeOutInSeconds) {
    //        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
    //            public Boolean apply(WebDriver driver) {
    //                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    //            }
    //        };
    //        try {
    //            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
    //            wait.until(expectation);
    //        } catch (Exception error) {
    //            error.printStackTrace();
    //        }
    //    }
    //    public static void executeJScommand(WebElement element, String command) {
    //        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    //        jse.executeScript(command, element);
    //    }
    //    public static void selectAnItemFromDropdown(WebElement item, String selectableItem){
    //        wait(5);
    //        Select select = new Select(item);
    //        for (int i =0;i<select.getOptions().size();i++){
    //            if(select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)){
    //                select.getOptions().get(i).click();
    //                break;
    //            }
    //        }
    //    }
    //    public static List<String> returnActiveElements(List<WebElement> elements){
    //        List<String> activeElements = new ArrayList<>();
    //        for (int i = 0; i < elements.size(); i++) {
    //            activeElements.add(elements.get(i).getText());
    //        }
    //        return activeElements;
    //    }
    //    /**
    //     * Clicks on an element using JavaScript
    //     *
    //     * @param element
    //     */
    //    public static void clickWithJS(WebElement element) {
    //        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    //        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    //    }
    //    /**
    //     * Clicks on an element using JavaScript
    //     *
    //     * @param elements
    //     */
    //    public static void clickWithJSAsList(List<WebElement> elements) {
    //        for (WebElement each : elements) {
    //            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(each,5));
    //            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", each);
    //        }
    //    }
    //    /**
    //     * Performs double click action on an element
    //     *
    //     * @param element
    //     */
    //    public static void doubleClick(WebElement element) {
    //        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    //    }
    //    public static void selectByVisibleText(WebElement element, String text){
    //        Select objSelect =new Select(element);
    //        objSelect.selectByVisibleText(text);
    //    }
    //    public static void selectByIndex(WebElement element, int index){
    //        Select objSelect =new Select(element);
    //        objSelect.selectByIndex(index);
    //    }
    //    public static void selectByValue(WebElement element, String value) {
    //        Select objSelect = new Select(element);
    //        List<WebElement> elementCount = objSelect.getOptions();
    //        objSelect.selectByValue(value);
    //        System.out.println("number of elements: "+elementCount.size());
    //    }
    //    public static void sleep(int timeOut){
    //        try {
    //            Thread.sleep(timeOut);
    //        }catch (Exception e){
    //            e.printStackTrace();
    //        }
    //    }
    //    public static void waitAndClickLocationText(WebElement element, String value){
    //        Driver.getDriver().findElement(By.xpath("//*[text()='"+value+"']")).click();
    //    }
    //    public static void navigateToUrl(String url){
    //        Driver.getDriver().get(url);
    //    }
    //}

//******************************
    //package stepdefinitions.database_step_defs;
    //import io.cucumber.java.en.Given;
    //import io.cucumber.java.en.Then;
    //import utilities.ConfigReader;
    //import utilities.DatabaseUtility;
    //import utilities.ReadTxt;
    //import utilities.WriteToTxt;
    //import java.util.ArrayList;
    //import java.util.List;
    //import static org.junit.Assert.assertTrue;
    //import static utilities.DatabaseUtility.registrant;

    //public class DatabaseSteps {

    //    List<Object> actualData;
    //    String fileName = ConfigReader.getProperty("db_user_ssn");
    //    @Given("user creates a connection with DB using {string} , {string} and {string}")
    //    public void user_creates_a_connection_with_db_using_and(String url, String username, String password) {
    ////        DatabaseUtility.createConnection(url, username,password);
    //    }
    //    @Given("user sends the query to db and gets the column data {string} and {string}")
    //    public void user_sends_the_query_to_db_and_gets_the_column_data_and(String query, String columnName) {
    //        actualData = DatabaseUtility.getColumnData(query,columnName );
    //    }
    //    @Given("user saves the DB data to correspondent files")
    //    public void user_saves_the_db_data_to_correspondent_files() {
    //        //WriteToTxt.saveDBUserData(fileName, actualData);
    //    }
    //    @Then("user validates DB data")
    //    public void user_validates_db_data() {
    //        List<String> actualSSNs = ReadTxt.returnUserSSNs(fileName);
    //        List<String> expectedSsns = new ArrayList<>();
    //        assertTrue("The Data For SSN ids are not matching!!",actualData.contains(registrant.getSsn()));
    //        System.out.println("Assertion success!!");
    //    }
    //}
//********************************
    //package pages;
    //import org.openqa.selenium.WebElement;
    //import org.openqa.selenium.support.FindBy;
    //import org.openqa.selenium.support.PageFactory;
    //import utilities.Driver;
    //public class RegistrationPage extends CommonPageElements{
    //    public RegistrationPage(){
    //        PageFactory.initElements(Driver.getDriver(), this);
    //    }
    //    @FindBy(id = "ssn")
    //    public WebElement ssnTextbox;
    //    @FindBy(name = "firstName")
    //    public WebElement firstnameTextbox;
    //    @FindBy(name = "lastName")
    //    public WebElement lastnameTextbox;
    //    @FindBy(name = "username")
    //    public WebElement usernameTextbox;
    //    @FindBy(id = "email")
    //    public WebElement emailTextbox;
    //    @FindBy(name = "firstPassword")
    //    public WebElement firstPasswordTextbox;
    //    @FindBy(name = "secondPassword")
    //    public WebElement newPasswordTextbox;
    //    @FindBy(id = "register-submit")
    //    public WebElement registerButton;
    //    @FindBy(xpath = "//*[text()='Registration saved!']")
    //    public WebElement successMessageToastContainer;
    //}
