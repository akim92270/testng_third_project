package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaSearchCarsPage {

    public CarvanaSearchCarsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[class*='HeaderFacetsstyles'] button")
    public List<WebElement> filterOptionsSearchButton;


    @FindBy(css = ".react-autosuggest__input")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;
}
