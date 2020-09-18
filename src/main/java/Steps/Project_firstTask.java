package Steps;

import Pages.AddNewAddress;
import Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project_firstTask {

    public WebDriver driver;
    AddNewAddress addNewAddress;

    @Given("^user has an open browser with open coderslab shop$")
    public void user_has_open_browser_with_open_coderslab_shop() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @When("^user logs in to his account$")
    public void user_logs_in_to_his_account () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("kislaya.ann@mail.ru", "a1234567a");
    }
    @Then("^user goes to addresses and adds new (.*),(.*),(.*),(.*)$")
    public  void user_goes_to_addresses_and_ads_new_address (String alias, String city, String address, String postcode){
        addNewAddress = new AddNewAddress(driver);
        addNewAddress.add_New_Address(alias,address,city,postcode);
    }
    @And("^new address contains correct (.*),(.*),(.*),(.*)$")
    public void user_is_able_to_see_his_new_address (String alias, String city, String address, String postcode) {
        addNewAddress = new AddNewAddress(driver);
        addNewAddress.information_about_address_update(alias, city, address, postcode);

    }

    @Then("^user can delete the address$")
    public void user_can_delete_the_address () {
        addNewAddress = new AddNewAddress(driver);
        addNewAddress.delete_the_address();

    }


}
