package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import page.CarvanaHomePage;
import page.CarvanaMercedesBenz;
import page.CarvanaSearchCarsPage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait wait;
    Wait fluentWait;
    SoftAssert softAssert;
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchCarsPage carvanaSearchCarsPage;
    CarvanaMercedesBenz carvanaMercedesBenz;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,15);
        Wait fluentWait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaSearchCarsPage = new CarvanaSearchCarsPage(driver);
        carvanaMercedesBenz = new CarvanaMercedesBenz(driver);

    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}