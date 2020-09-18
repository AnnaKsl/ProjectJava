package Steps;

import Pages.ChooseItemDetails;
import Pages.LoginPage;
import Pages.SearchforTheItem;
import Pages.User_shopping_card;
import cucumber.api.java.en.*;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Project_secondTask {
    private WebDriver driver;

    @Given("^user has an open page of CodersLab store$")
    public void user_has_an_open_page_of_CodersLab_store(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Then("^user logs in to his account using valid (.*) and (.*)$")
    public void user_logs_in_to_his_account_using_valid_kislaya_ann_mail_ru_and_a_a(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email,password);
    }

    @Then("^user finds the item (.*)$")
    public void user_finds_the_item(String item){
        SearchforTheItem search = new SearchforTheItem(driver);
        search.SearchTheItem(item);
    }

    @Then("^user is able to choose the size (.*) and the quantity (.*) and adds the product$")
    public void user_is_able_to_choose_the_size_and_the_quantity_and_add_the_product(String size, String quantity){
        ChooseItemDetails chooseItemDetails = new ChooseItemDetails(driver);
        chooseItemDetails.checkIfDiscountIsCorrect();
        chooseItemDetails.chooseSize(size);
        chooseItemDetails.chooseQuantity(quantity);
        chooseItemDetails.addItemToCard();



    }

    @Then("^user goes to checkout option and confirms the address$")
    public void user_goes_to_checkout_option_and_confirms_the_address(){
        ChooseItemDetails chooseItemDetails = new ChooseItemDetails(driver);
        chooseItemDetails.proceedToCheckout();
    }

    @Then("^user chooses the delivery method,payment option and clicks \"order with an obligation to pay\"$")
    public void user_chooses_the_delivery_method_and_payment_option() {
        User_shopping_card user_shopping_card = new User_shopping_card(driver);
        user_shopping_card.proceed_to_checkout();
        user_shopping_card.confirm_personal_information();

    }

    @Then("^it is possible to make screenshot of the order$")
    public void take_screenshot_of_the_order () throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File order = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(order, new File("./Screenshots/Order.png"));
        System.out.println("the Screenshot is taken");
        System.out.println(order.getAbsolutePath());

    }
}
