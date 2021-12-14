import models.TestBase;
import models.User;
import models.UserDatabase;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CreateAccountPage;
import pages.HeaderPage;
import pages.LogInPage;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterUserTest extends TestBase {
    private Logger logger = LoggerFactory.getLogger(RegisterUserTest.class);
    HeaderPage headerPage;
    LogInPage logInPage;
    CreateAccountPage createAccountPage;
    UserDatabase userDatabase = new UserDatabase();


    @BeforeEach
    void testSetup() {
        driver.get("http://146.59.32.4/index.php");
        logger.info("Window opened");
    }

    @Test
    void loginWithNonExistingUser(){
        headerPage = new HeaderPage(driver);
        headerPage.clickSignInButton();

        logInPage = new LogInPage(driver);
        logInPage.loginWithNonExistingUser();
        logger.info("Logged with nonexisting user");
        assertThat(logInPage.getloginAlertText(), equalTo("Authentication failed."));
        logger.info("Assertion completed");
    }

    @Test
    void loginWithExistingUser(){
        headerPage = new HeaderPage(driver);
        headerPage.clickSignInButton();

        logInPage = new LogInPage(driver);
        User existingUser = userDatabase.getExistingUser();
        logInPage.loginWithAlreadyDefinedUser(existingUser);
        logger.info("Logged with already existing user");
        assertThat(headerPage.getloggetAccountFullName(), equalTo(existingUser.getUserFullName()));
        logger.info("Assertion completed");
    }

    @Test
    void registerNewUser() {
        headerPage = new HeaderPage(driver);
        headerPage.clickSignInButton();

        logInPage = new LogInPage(driver);
        logInPage.goToNewAccountCreation();

        User newRandomUser = UserFactory.getRandomUser();
        userDatabase.addUserToDatabase(newRandomUser);
        logger.info("Created random user");

        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.fillFormWithNewUserData(newRandomUser)
                .clickSaveNewUSerButton();
        logger.info("New user form filled with new user");
        assertThat(headerPage.getloggetAccountFullName(), equalTo(newRandomUser.getUserFullName()));
        logger.info("Assertion completed");
    }
}
