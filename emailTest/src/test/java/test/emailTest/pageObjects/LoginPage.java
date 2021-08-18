package test.emailTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qualityLaboratory.testTask.AppProperties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//button[contains(text(),'Ввести пароль')]")
    private WebElement confirmLoginBtn;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox']/form[1]/button[2]")
    private WebElement confirmPasswordBtn;

    public LoginPage inputLogin(String login) {
        loginField.clear();
        loginField.sendKeys(AppProperties.getProperty("userLogin"));
        return new LoginPage(driver);
    }

    public LoginPage inputPassword(String password) {
        passwordField.sendKeys(AppProperties.getProperty("userPassword"));
        return new LoginPage(driver);
    }

    public LoginPage clickConfirmLoginBtn(){
        confirmLoginBtn.click();
        return new LoginPage(driver);
    }

    public void clickConfirmPasswordBtn(){
        confirmPasswordBtn.click();
    }
}
