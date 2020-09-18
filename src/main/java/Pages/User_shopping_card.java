package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User_shopping_card {
    public WebDriver driver;

    public User_shopping_card(WebDriver driver) {
        this.driver = driver;
    }

    public void proceed_to_checkout() {
       // WebDriverWait wait = new WebDriverWait(driver,10);
      //  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-primary")));
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
    }

    public void confirm_personal_information() {
        driver.findElement(By.name("confirm-addresses")).click();
        //user chooses the delivery option
        driver.findElement(By.id("delivery_option_1")).isSelected();
        driver.findElement(By.name("confirmDeliveryOption")).click();
        //user chooses the payment option by-check
        driver.findElement(By.id("payment-option-1")).click();
        //user agrees with the terms of the service
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        //user clicks "the order with an obligation to pay" button
        driver.findElement(By.cssSelector("button.btn.btn-primary.center-block")).click();

    }
}
