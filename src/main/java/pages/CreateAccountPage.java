package pages;

import models.SocialTitle;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateAccountPage extends BasePage {

    @FindBy(css = ".radio-inline")
    private List<WebElement> socialTitleRadioButtons;

    @FindBy(css = "[name='firstname']")
    private WebElement firstNameTextField;

    @FindBy(css = "[name='lastname']")
    private WebElement lastNameTextField;

    @FindBy(css = "[name='email']:not([placeholder])")
    private WebElement emailTextFieldInForm;

    @FindBy(css = "[name='password']")
    private WebElement passwordTextField;

    @FindBy(css = "[type='button']")
    private WebElement showPasswordButton;

    @FindBy(css = "[name='birthday']")
    private WebElement birthdateTextField;

    @FindBy(css = "[type='checkbox']")
    private List<WebElement> checkboxesList;

    @FindBy(css = "[data-link-action='save-customer']")
    private WebElement saveNewUserButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage fillFormWithNewUserData(User createdUser){
        pickCorrectSocialTitleButton(createdUser.getTitle());
        firstNameTextField.sendKeys(createdUser.getFirstName());
        lastNameTextField.sendKeys(createdUser.getLastName());
        passwordTextField.sendKeys(createdUser.getPassword());
        emailTextFieldInForm.sendKeys(createdUser.getEmail());
        checkboxesList.get(1).click();
        checkboxesList.get(3).click();
        return this;
    }

    private void pickCorrectSocialTitleButton(SocialTitle socialTitle){
        if ((socialTitle.equals(SocialTitle.Mr))) {
            socialTitleRadioButtons.get(0).click();
        } else socialTitleRadioButtons.get(1).click();
    }

    public CreateAccountPage clickSaveNewUSerButton(){
        saveNewUserButton.click();
        return this;
    }

}
