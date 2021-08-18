package test.emailTest.tests;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import qualityLaboratory.testTask.AppProperties;
import test.emailTest.bisinessObject.*;
import test.emailTest.pageObjects.*;
import test.emailTest.services.*;
import test.emailTest.patterns.SingletonWebDriver;

public class MailServiceTest extends BaseTest {

    private static Registration registration;
    private static Creation creation;
    private static ProfilePage profilePage;
    private static SentPage sentPage;
    private User user;
    private Letter newLetter;

    @Before
    public void init() {
        SingletonWebDriver.getInstance().get(AppProperties.getProperty("url"));
        user = new User(
                AppProperties.getProperty("userLogin"),
                AppProperties.getProperty("userPassword"));
        newLetter = new Letter(
                AppProperties.getProperty("subject"),
                AppProperties.getProperty("mailBody"));
        registration = new Registration();
        creation = new Creation();
        profilePage = new ProfilePage(SingletonWebDriver.getInstance());
    }

    @Test
    public void correctAuthentication() {
        registration.entry(SingletonWebDriver.getInstance(), user);
        Assert.assertEquals(user.getLogin(), profilePage.getUserMailBoxName());
    }

    @Test
    public void creationNewLetter() {
        registration.entry(SingletonWebDriver.getInstance(), user);
        profilePage.clickOnWriteLetterLink();
        profilePage = creation.createNewLetter(SingletonWebDriver.getInstance(), newLetter);
        sentPage = profilePage.clickOnSentLink();
        Assert.assertTrue(sentPage.isLetterInSent(newLetter));
    }

    @After
    public void tearDown() {
        profilePage.clickOnLogOutLink();
    }
}