package pageObjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class searchPageObject
{
    private WebElement search;

    public void setSearch(String searchProduct) throws InterruptedException
    {
        //Visitor will input and search the specific item
        search.clear();
        search.sendKeys(searchProduct);
        search.sendKeys(Keys.RETURN);

    }

}
