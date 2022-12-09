package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US026Page {

    public US026Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

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

   @FindBy(xpath = "//a[starts-with(@href,'/contact')]")
   public WebElement contact;

    @FindBy(xpath = "//*[text()='Contact']")
    public WebElement contactEnable;

    @FindBy(xpath = "//div[@class='info']")
    public List<WebElement> uclu;

    @FindBy(xpath = "//p[starts-with(text(),'575')]")
    public WebElement location;

    @FindBy(xpath = "//p[starts-with(text(),'contact@')]")
    public WebElement email;

    @FindBy(xpath = "(//p[starts-with(text(),'+1 (336)')])[1]")
    public WebElement call;

    @FindBy(id="register-form")
    public WebElement mesajForm;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailsend;

    @FindBy(xpath = "//input[@id='subject']")
    public WebElement subject;

    @FindBy (xpath = "//textarea[@name='message']")
    public WebElement message;

    @FindBy(id = "register-submit")
    public WebElement send;

    @FindBy(xpath = "//div/span/strong")        //*[contains(text(),'received')]
    public WebElement popUpMessage;

}

