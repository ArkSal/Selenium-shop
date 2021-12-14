package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {

    @FindBy(css = "#category-3")
    private WebElement clothesCategoryButton;

    @FindBy(css = "a[title^='Log in']")
    private WebElement signInButton;

    @FindBy(css = ".account")
    private WebElement loggedAccountInfo;

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderPage clickSignInButton(){
        signInButton.click();
        return this;
    }

    public String getloggetAccountFullName(){
        return loggedAccountInfo.getText();
    }
}
