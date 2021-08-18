package test.emailTest.services;

import org.openqa.selenium.WebDriver;
import test.emailTest.bisinessObject.Letter;
import test.emailTest.pageObjects.CreateNewLetterPage;
import test.emailTest.pageObjects.ProfilePage;
import test.emailTest.patterns.SingletonWebDriver;

public class Creation {

    private CreateNewLetterPage createNewLetterPage;

    public ProfilePage createNewLetter(WebDriver driver, Letter newLetter) {
        createNewLetterPage = new CreateNewLetterPage(driver);
        createNewLetterPage
                .enterSubject(newLetter.getSubject())
                .enterMailBody(newLetter.getMailBody())
                .clickSendButton();
        return new ProfilePage(SingletonWebDriver.getInstance());
    }
}
