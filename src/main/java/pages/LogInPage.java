package pages;

import models.User;
import models.UserDatabase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    @FindBy(css = "[name='email']:not([placeholder])")
    private WebElement emailTextField;

    @FindBy(css = "[name='password']")
    private WebElement passwordTextField;

    @FindBy(css = ".input-group-btn")
    private WebElement showPasswordButton;

    @FindBy(css = "[data-link-action='sign-in']")
    private WebElement sigInButton;

    @FindBy(css = ".no-account")
    private WebElement createNewAccountButton;

    @FindBy(css = ".alert-danger")
    private WebElement loginAlertInfo;

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LogInPage goToNewAccountCreation(){
        createNewAccountButton.click();
        return this;
    }

    public void loginWithNonExistingUser(){
        emailTextField.sendKeys("Nonexisting@email.com");
        passwordTextField.sendKeys("SomePassword1");
        sigInButton.click();
    }

    public String getloginAlertText(){
        return loginAlertInfo.getText();
    }

    public void loginWithAlreadyDefinedUser(User existingUser){
        emailTextField.sendKeys(existingUser.getEmail());
        passwordTextField.sendKeys(existingUser.getPassword());
        sigInButton.click();
    }

}
