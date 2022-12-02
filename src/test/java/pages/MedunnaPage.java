package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.WatchEvent;
import java.util.List;

public class MedunnaPage {

    public MedunnaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="account-menu")
    public WebElement SinginSimgesi;

    @FindBy (id="login-item")
    public  WebElement Singin;

    @FindBy (xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy (xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement giris;

    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy (xpath = "(//*[@class='dropdown-item'])[1]")
    public WebElement settings;

    @FindBy(id="settings-title")
    public WebElement settingsTitle;

   // @FindBy(xpath = "//input[@name='firstName']")
   // public WebElement firstname;
    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstname;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastname;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy (xpath = "//*[text()='Save']")
    public WebElement saveButton;

    @FindBy (xpath = "//div/span/Strong")
    public WebElement settingsSaved;


    //************** US007 ***************//

    @FindBy(id = "entity-menu")
    public WebElement myPages;

    @FindBy(xpath = "//div/a[2][1]")
    public WebElement makeanappointment;

    @FindBy(xpath = "//*[@placeholder='000-000-0000']")
    public WebElement phoneNumber;

    @FindBy(id="appoDate")
    public WebElement appointmentDate;

    @FindBy (id ="register-submit")
    public WebElement sendAnAppointmentRequest;

    @FindBy(xpath = "//div/span/strong")
    public WebElement appointmentRequestSaved;

    @FindBy(xpath = "//*[.='Appointment date can not be past date!']")
    public List<WebElement> uyariMesaji;




}
