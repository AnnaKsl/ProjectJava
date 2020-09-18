package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddNewAddress {

    public WebDriver driver;
    @FindBy(id = "addresses-link") WebElement UserAddress;
    @FindBy(xpath = "//*[text()='Create new address']") WebElement createNewAddress;
    @FindBy(name = "alias") WebElement input_alias;
    @FindBy(name ="address1") WebElement input_address;
    @FindBy(name= "city") WebElement input_city;
    @FindBy(name ="postcode") WebElement input_postcode;
    @FindBy(css = "button.float-xs-right") WebElement button_submit;
    @FindBy(css="article.alert-success") WebElement addressUpdateInfo;
    @FindBy(css="article.address") List<WebElement> addressBody;
    @FindBy(xpath = "//a[@data-link-action=\"delete-address\"]") List <WebElement> deleteTheAddress;



    public AddNewAddress( WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void add_New_Address (String alias, String address, String city, String postcode) {
        UserAddress.click();
        createNewAddress.click();
        input_alias.sendKeys(alias);
        input_address.sendKeys(address);
        input_city.sendKeys(city);
        input_postcode.sendKeys(postcode);
        Select selectCountry = new Select(driver.findElement(By.name("id_country")));
        selectCountry.selectByVisibleText("United Kingdom");
        button_submit.click();
    }
    public void information_about_address_update (String alias, String address, String city, String postcode) {
        System.out.println("method is working");
        for (WebElement oneAddress: addressBody) {
            String singleAddress = oneAddress.getText();
            Assert.assertTrue(singleAddress.contains(alias));
            Assert.assertTrue(singleAddress.contains(address));
            Assert.assertTrue(singleAddress.contains(city));
            Assert.assertTrue(singleAddress.contains(postcode));
        }

    }

    public void delete_the_address () {
        deleteTheAddress.get(deleteTheAddress.size()-1).click();
        WebElement addressUpdateInfo =driver.findElement(By.cssSelector("article.alert-success"));
        Assert.assertTrue(addressUpdateInfo.getText().contains("successfully deleted"));

    }



}
