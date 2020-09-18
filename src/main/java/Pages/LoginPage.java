package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver= driver;
    }

    public void loginAs (String email, String password) {
       WebElement signInButton = driver.findElement(By.id("_desktop_user_info"));
       signInButton.click();
       WebElement userEmail = driver.findElement(By.name("email"));
       userEmail.sendKeys(email);
       WebElement userPassword = driver.findElement(By.name("password"));
       userPassword.sendKeys(password);

       WebElement signIn = driver.findElement(By.id("submit-login"));
        signIn.click();
       // WebElement userInfo = driver.findElement(By.id("identity-link"));
      //  userInfo.click();
    }

    public String getLoggedUserName () {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }
}
