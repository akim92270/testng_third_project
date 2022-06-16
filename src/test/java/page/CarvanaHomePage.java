package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[title^='Carvana | Buy & '")
    public WebElement titlePage;

    @FindBy(css = "div[data-qa*='logo']")
    public WebElement logoIcon;

    @FindBy(css = "div[data-qa*='navigation']>div>a")
    public List<WebElement> mainNavigationSection;

    @FindBy(css = "div[data-qa*='sign-in-'] a")
    public WebElement signInButton;

    @FindBy(id = "usernameField")
    public WebElement userNameInputBox;

    @FindBy(id = "passwordField")
    public WebElement passwordInputBox;

    @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement signInSummitButton;

    @FindBy(css = "div[class*='ErrorMessageContainer']")
    public WebElement errorMessage;

    @FindBy(css = "a[data-cv-test*='headerSearchLink']")
    public WebElement searchCarsButton;

}
