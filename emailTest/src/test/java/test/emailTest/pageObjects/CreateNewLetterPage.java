package test.emailTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.emailTest.patterns.SingletonWebDriver;

public class CreateNewLetterPage extends BasePage {

    @FindBy(xpath = "//div[@class='inputContainer--nsqFu']//input")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@role=\"textbox\"]")
    private WebElement mailBodyField;

    @FindBy(xpath = "//*[contains(@title,'Отправить')]")
    private WebElement sendBtn;

    public CreateNewLetterPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewLetterPage enterSubject(String userLogin) {
        subjectField.sendKeys(userLogin);
        return new CreateNewLetterPage(SingletonWebDriver.getInstance());
    }

    public CreateNewLetterPage enterMailBody(String mailBody) {
        mailBodyField.sendKeys(mailBody);
        return new CreateNewLetterPage(SingletonWebDriver.getInstance());
    }

    public void clickSendButton() {
        sendBtn.click();
    }
}
