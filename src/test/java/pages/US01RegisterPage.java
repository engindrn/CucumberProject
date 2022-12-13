package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US01RegisterPage {

    public US01RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);}



    @FindBy (xpath = "//*[@name='ssn']")
    public WebElement ssnBox;

    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//*[@name='firstPassword']")
    public WebElement firstPassword;

    @FindBy(xpath = "//*[@name='secondPassword']")
    public WebElement secondPassword;

    @FindBy(id = "register-submit")
    public WebElement registerSubmitButton;
}
