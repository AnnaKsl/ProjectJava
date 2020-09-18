package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchforTheItem {
    private WebDriver driver;
    @FindBy(name = "s")  WebElement searchInput;
    @FindBy(css="h2.product-title") List<WebElement> foundProducts;

    public SearchforTheItem (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void SearchTheItem (String itemTitle) {
        searchInput.sendKeys(itemTitle);
        searchInput.submit();
        foundProducts.get(0).click();

    }
}
