package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarvanaTest extends Base {

    /*
    Test name = Validate Carvana home page title and url
    Test priority = 1
    Given user is on "https://www.carvana.com/"
    Then validate title equals to "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
    And validate url equals to "https://www.carvana.com/"
     */
    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testCarvanaTitleAndUrl(){
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    /*
    Test Case 2:
    Test name = Validate the Carvana logo
    Test priority = 2
    Given user is on "https://www.carvana.com/"
    Then validate the logo of the “Carvana” is displayed
     */

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void testCarvanaLogo(){
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.logoIcon.isDisplayed());
    }

    /*
    Test Case 3:
    Test name = Validate the main navigation section items
    Test priority = 3
    Given user is on "https://www.carvana.com/"
    Then validate the navigation section items below are displayed
    |HOW IT WORKS     	|
    |ABOUT CARVANA    	|
    |SUPPORT & CONTACT	|
     */

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testMainNavigation(){
        driver.get("https://www.carvana.com/");
        String[] expectedMainNavigationSectionText = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(carvanaHomePage.mainNavigationSection.get(i).isDisplayed());
            Assert.assertEquals(carvanaHomePage.mainNavigationSection.get(i).getText(), expectedMainNavigationSectionText[i]);
        }
    }

    /*
    Test name = Validate the sign in error message
    Test priority = 4
    Given user is on "https://www.carvana.com/"
    When user clicks on “SIGN IN” button
    Then user should be navigated to “Sign in” modal
    When user enters email as “johndoe@gmail.com”
    And user enters password as "abcd1234"
    And user clicks on "SIGN IN" button
    Then user should see error message as "Email address and/or password combination is incorrect
    Please try again or reset your password."
     */

    @Test(priority = 4, description = "Validate the sign in error message")
    public void testSignErrorMessage(){
        driver.get("https://www.carvana.com/");
        carvanaHomePage.signInButton.click();
        carvanaHomePage.userNameInputBox.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        carvanaHomePage.signInSummitButton.click();
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }

    /*
    Test name = Validate the search filter options and search button
    Test priority = 5
    Given user is on "https://www.carvana.com/"
    When user clicks on "SEARCH CARS" link
    Then user should be routed to "https://www.carvana.com/cars"
    And user should see filter options
    |PAYMENT & PRICE     	|
    |MAKE & MODEL	    	|
    |BODY TYPE		|
    |YEAR & MILEAGE     	|
    |FEATURES	    	|
    |MORE FILTERS		|
     */

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testSearchFilterOptionsAndSearchButton() {
        driver.get("https://www.carvana.com/");
        String[] expectedFilterOptions = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        carvanaHomePage.searchCarsButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        for (int i = 0; i < carvanaSearchCarsPage.filterOptionsSearchButton.size(); i++) {
            Assert.assertTrue(carvanaSearchCarsPage.filterOptionsSearchButton.get(i).isDisplayed());
            Assert.assertEquals(carvanaSearchCarsPage.filterOptionsSearchButton.get(i).getText(), expectedFilterOptions[i]);
        }
    }

    /*
    Test name = Validate the search result tiles
    Test priority = 6
    Given user is on "https://www.carvana.com/"
    When user clicks on "SEARCH CARS" link
    Then user should be routed to "https://www.carvana.com/cars"
    When user enters "mercedes-benz" to the search input box
    And user clicks on "GO" button in the search input box
    Then user should see "mercedes-benz" in the url
    And validate each result tile


    VALIDATION OF EACH TILE INCLUDES BELOW
    Make sure each result tile is displayed with below information
    1. an image
    2. add to favorite button
    3. tile body
    ALSO VALIDATE EACH TILE BODY:
    Make sure each tile body has below information
    1. Inventory type - text should be displayed and should not be null
    2. Year-Make-Model information - text should be displayed and should not be null
    3. Trim-Mileage information - text should be displayed and should not be null
    4. Price - Make sure that each price is more than zero
    5. Monthly Payment information - text should be displayed and should not be null
    6. Down Payment information - text should be displayed and should not be null
    7. Delivery chip must be displayed as “Free Shipping”


    NOTE: After completing all scripts, create an xml file called “test.xml” and make sure that you can run all scripts using “mvn test -Dsurefire.xmlSuiteFiles=test.xml”
     */

    @Test(priority = 6, description = "Validate the search result tiles")
    public void testSearchResultTitles() {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaSearchCarsPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaSearchCarsPage.goButton.click();
        //Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
        driver.getTitle();
        for (int i = 0; i < carvanaMercedesBenz.mercedesBenzImages.size(); i++) {
            Assert.assertTrue(carvanaMercedesBenz.mercedesBenzImages.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenz.favoriteIcon.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenz.titleBody.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenz.inventoryTitle.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenz.trimMileage.get(i).isDisplayed());
            //Assert.assertTrue(Integer.parseInt(carvanaMercedesBenz.carPrice.get(i).getText())>0);
            Assert.assertTrue(carvanaMercedesBenz.carEstimateMonthlyPrice.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenz.carDownPaymentPrice.get(i).isDisplayed());
            Assert.assertTrue(carvanaMercedesBenz.inventoryTitle.get(i).isDisplayed());
        }

    }
}
