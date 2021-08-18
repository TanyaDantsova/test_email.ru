package test.emailTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'ph-project__account')]")
    private WebElement userBoxName;

    @FindBy(xpath = "//*[contains(@title,'Написать письмо')]")
    private WebElement writeLetterBtn;

    @FindBy(xpath = "//span[contains(text(),'Отправить')]")
    private WebElement sendBtn;

    @FindBy(xpath = "//*[contains(@title,'Отправленные')]")
    private WebElement sentLink;

    @FindBy(xpath = "//*[contains(@class,'ph-accounts')]/a[3]")
    private WebElement logOutLink;

    public String getUserMailBoxName() {
        return userBoxName.getText();
    }

    public CreateNewLetterPage clickOnWriteLetterLink() {
        writeLetterBtn.click();
        return new CreateNewLetterPage(driver);
    }

    public SentPage clickOnSentLink() {
        sentLink.click();
        return new SentPage(driver);
    }

    public void clickOnLogOutLink() {
        userBoxName.click();
        logOutLink.click();
    }

}
