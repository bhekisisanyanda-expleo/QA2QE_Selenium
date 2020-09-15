package stepdefinitions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.searchPageObject;

public class NegativeTest
{
    private WebDriver driver;

    @Test
    public void negativeTest() throws InterruptedException {
        //Opens the HomePage using the link and extracts the gecko driver
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\NyandaB\\Desktop\\IntelliJ\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://magento.abox.co.za/");
        searchPageObject selectPage = PageFactory.initElements(driver, searchPageObject.class);
        selectPage.setSearch("Cars");

    }
}
