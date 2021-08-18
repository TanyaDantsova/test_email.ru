package test.emailTest.pageObjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.emailTest.bisinessObject.Letter;

import java.util.List;

public class SentPage extends BasePage {
    public SentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='dataset__items']")
    private List<WebElement> listSentLetters;

    @FindBy(xpath = "//div[@class='letter-list-item-adv']/following-sibling::a")
    private WebElement lastLetter;

    @FindBy(xpath = "//div[@class='llc__item llc__item_correspondent']//span")
    private WebElement subjectLastLetter;

    @FindBy(xpath = "//*[@class='ll-sp__normal']")
    private WebElement bodyLastLetter;

    public boolean isLetterInSent(Letter letter) {
        boolean status = false;
        if (subjectLastLetter.getText().equals(letter.getSubject()) &&
                StringUtils.substringBefore(bodyLastLetter.getText(), "--").trim().equals(letter.getMailBody())) {
            status = true;
        }
        return status;
    }
    //                .(".+?(?=--)")


}
