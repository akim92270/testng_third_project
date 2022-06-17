package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaMercedesBenz {
    public CarvanaMercedesBenz(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "section[id='results-section'] picture")
    public List<WebElement> mercedesBenzImages;

    @FindBy(css = "svg[class='favorite-icon']")
    public List<WebElement> favoriteIcon;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> titleBody;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> trimMileage;

    @FindBy(css = ".price")
    public List<WebElement> carPrice;

    @FindBy(css = ".monthly-payment span")
    public List<WebElement> carEstimateMonthlyPrice;

    @FindBy(css = ".down-payment")
    public List<WebElement> carDownPaymentPrice;

    @FindBy(css = ".delivery-chip")
    public List<WebElement> deliveryChipFreeShipping;

    @FindBy(css = "div[data-test='BaseInventoryType']")
    public List<WebElement> inventoryTitle;
}
