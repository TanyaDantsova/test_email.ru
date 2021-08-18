package test.emailTest.services;

import org.openqa.selenium.WebDriver;
import test.emailTest.bisinessObject.User;
import test.emailTest.pageObjects.LoginPage;
import test.emailTest.pageObjects.ProfilePage;

public class Registration {

    public ProfilePage entry(WebDriver driver, User user) {
        new LoginPage(driver)
                .inputLogin(user.getLogin())
                .clickConfirmLoginBtn()
                .inputPassword(user.getPassword())
                .clickConfirmPasswordBtn();
        return new ProfilePage(driver);
    }
}
