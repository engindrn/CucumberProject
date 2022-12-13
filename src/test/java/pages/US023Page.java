package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US023Page {

    public US023Page(){PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(id="account-menu")
    public WebElement SinginSimgesi;

    @FindBy (id="login-item")
    public  WebElement Singin;

    @FindBy (xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy (xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement giris;

    @FindBy(id = "entity-menu")
    public WebElement myPage;

    @FindBy(xpath = "//*[text()='My Appointments']")
    public WebElement myAppointments;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr/td[13]/div/a")
    public WebElement edit;

    @FindBy(xpath = "//*[@id='appointment-status']")
    public WebElement appointmentStatus;

    @FindBy(className = "no-js")
    public WebElement tumSayfa;        //butun sayfanin locato jsScroll ile safayi kaydiracaz

    @FindBy(id = "save-entity")
    public WebElement save;

    @FindBy(xpath = "//*[contains(text(),'The Appointment is')]")
    public WebElement dogrulamaMesaji;

    @FindBy(xpath = "//*[text()='Search Patient']")
    public WebElement searchPatient;

    @FindBy(className = "form-control")
    public WebElement patientSsn;

    @FindBy(xpath = "//*[contains(text(),'Show')]")
    public WebElement showappointments;

    @FindBy(xpath = "//*[contains(@href,'/appointment-update/365563')]")
    public WebElement appointmentEdit;

    @FindBy(xpath = "(//*[@class='text-right'])[40]")
     public List <WebElement> paymentbutondogrulama;

    @FindBy(xpath = "//tbody/tr/td[4][.='COMPLETED']")
    public List <WebElement> completedList;                //tabloda 4 sutuna geldik ve orda text olrak
                                                           //status durumu completed olan hastayi sectik

    @FindBy(xpath = "//*[contains(@href,'/payment-detail/361692')]")
    public WebElement paymentInvoiceProcess;

    @FindBy(xpath = "//*[text()='PAYMENT DETAIL']")
    public WebElement paymentDetail;

    @FindBy(xpath = " //*[text()=' Show Invoice']")
    public WebElement showInvoice;

    @FindBy(xpath = "//*[text()='INVOICE']")
    public WebElement invoice;

}
