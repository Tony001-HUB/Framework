package page;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SpecificSearchResultsPage extends AbstractPage {

    @FindBy(className = "onsite-search__result-item")
    private List<WebElement> generalSearchResult;

    public SpecificSearchResultsPage()
    {
        super(DriverSingleton.getDriver());
    }

    @Override
    public SpecificSearchResultsPage openPage() { return this; }

    public int countGeneralNumberOfSearchResults()
    {
        waitForElementToBeClickable(this.driver, By.xpath("/html/body"));
        System.out.println("Number of results:" + generalSearchResult.size());
        return  generalSearchResult.size();
    }

}
