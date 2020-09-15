package stepdefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.searchPageObject;

public class searchstepdefinitions
{
    private WebDriver driver;
    private By ItemSelectLocator = By.linkText("Carina Basic Capri");
    private By Sizelocator = By.id("option-label-size-142-item-172");
    private By ColourLocator = By.id("option-label-color-93-item-57");
    private By QtyLocator = By.id("qty");
    private By AddToCartLocator = By.id("product-addtocart-button");


    @Given("I am a visitor")
    public void i_am_a_visitor() throws InterruptedException
    {
        //Opens the HomePage using the link and extracts the gecko driver
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\NyandaB\\Desktop\\IntelliJ\\drivers\\geckodriver.exe");
        // Opens the HomePage using FireFox Driver
        driver = new FirefoxDriver();
        driver.get("https://magento.abox.co.za/");
        String expectedTitle = "Home Page";
        String actualTitle = driver.getTitle();
        //Asserts to determine that the HomePage is the expected Title
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Home Page is displayed – Assert passed");
        WebDriverWait home = new WebDriverWait(driver, 200);
        home.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sale")));

    }

    @When("I search for a product")
    public void i_search_for_a_product() throws InterruptedException
    {
        // Visitor Searches using the Search Functionality - SearchObject, searching for Pants
        searchPageObject selectPage = PageFactory.initElements(driver, searchPageObject.class);
        selectPage.setSearch("Pants");

    }

    @When("I view a product")
    public void i_view_the_product() throws InterruptedException
    {
        // Visitor selects the Carina Basic Capri Pants from the Product List
        WebDriverWait wait = new WebDriverWait(driver, 100);
        // Waits until the Selected Item is displayed on the Page for selection
        wait.until(ExpectedConditions.visibilityOfElementLocated(ItemSelectLocator));
        driver.findElement(ItemSelectLocator).click();
        //Assert checks the Actual Title against the expected Title
        String expectedTitle = "Carina Basic Capri";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Carina Basic Capri Page is displayed – Assert passed");
    }

    @Then("I am able to select the product")
    public void i_view_product_list_page() throws InterruptedException
    {
       //Visitor selects the options available - Size, Colour, and Quantity
        WebDriverWait item = new WebDriverWait(driver, 200);
        item.until(ExpectedConditions.visibilityOfElementLocated(Sizelocator));
        //Assert to check if the Add to Cart Button is displayed
        WebElement Cart = driver.findElement(By.id("product-addtocart-button"));
        Assert.assertEquals(true, Cart.isDisplayed());
        System.out.println("Cart is displayed – Assert passed");
        //Selects the Size, Color, and Quantity of the Selected Carina Basic Capri Pants
        driver.findElement(Sizelocator).click();
        driver.findElement(ColourLocator).click();
        driver.findElement(QtyLocator).clear();
        driver.findElement(QtyLocator).sendKeys("12");
        //Visitor selects the add to cart button - item is added successfully
        driver.findElement(AddToCartLocator).click();

    }

}