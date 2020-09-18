package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;

public class ChooseItemDetails {
    public WebDriver driver;

    @FindBy(id = "quantity_wanted")
    WebElement chooseQuantity;

    public ChooseItemDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void checkIfDiscountIsCorrect (){
      String regularPrice =  driver.findElement(By.cssSelector("span.regular-price")).getText();
      String priceWithDiscount = driver.findElement(By.xpath("//span[@itemprop=\"price\"]")).getText();
      double regularCost = Double.parseDouble(regularPrice.substring(1));
      double priceWithDiscountApplied = Double.parseDouble(priceWithDiscount.substring(1));
      double priceExpected = regularCost*0.8;
        Assert.assertEquals(priceExpected,priceWithDiscountApplied,0.0);
    }

    public void chooseSize(String size){

        Select sizeSelect = new Select(driver.findElement(By.id("group_1")));
        System.out.println("Hello");
        if (size.equals("S")) {
            sizeSelect.selectByValue("1");
        } else if (size.equals("M")) {
            sizeSelect.selectByValue("2");
        } else if (size.equals("L")) {
            sizeSelect.selectByValue("3");
        } else {
            sizeSelect.selectByValue("4");
        }

    }
    public void chooseQuantity(String quantity){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.add-to-cart")));
        chooseQuantity.clear();
        chooseQuantity.sendKeys(quantity);
    }
    public void addItemToCard() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.add-to-cart")));
        driver.findElement(By.cssSelector("button.add-to-cart")).click();
    }
    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary")));
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
    }
}