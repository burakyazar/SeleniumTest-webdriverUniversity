package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.Base_PO;
import pageObject.Login_PO;
import stepDefinitions.base.Hooks;

import java.time.Duration;

import static driver.DriverFactory.getDriver;


public class Login_Page extends Base_PO {
    private WebDriver driver = getDriver();

private Login_PO login_po;
public Login_Page(Login_PO login_po){
    this.login_po = login_po;

}


    @Given("i access the webdriver university Login Page")
    public void i_access_the_webdriver_university_login_page() {
login_po.navigateTo_WebdriverUniversity_Login_Page();
   }
    @When("i enter a specific username")
    public void i_enter_a_specific_username() {
        driver.findElement(By.xpath("/html//input[@id='text']")).sendKeys("webdriver");

    }
    @And("i enter a specific password")
    public void i_enter_a_specific_password() {
        driver.findElement(By.id("password")).sendKeys("webdriver123");

    }
    @And("i click on the login botton")
    public void i_click_on_the_login_botton() {
        // Write code here that turns the phrase above into concrete actions
        login_po.clickOn_Login_Button();
}
    @Then("i should get a succession pop-up")
    public void i_should_get_a_succession_pop_up() {

  login_po.validate_SuccesfulLogin_Message();



        //noinspection deprecation
       /* WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String actualMessage = alert.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        alert.accept(); // Pop-up'ı kabul etmek için*/
    }

    @When("i enter a username {string}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
    }

    @When("i enter a unique username {word}")
    public void i_enter_a_unique_username(String username) {
        driver.findElement(By.xpath("/html//input[@id='text']")).sendKeys(username);

    }

    @And("i enter a password {word}")
    public void i_enter_a_password_webdriver123(String password) {
        login_po.setPassword(password);


    }
    @Then("i should get an unseccesful login pop-up")
    public void i_should_get_an_unseccesful_login_pop_up() {
        login_po.validate_UnsuccesfulLogin_Message();




    }
    @Then("i should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {

  waitForAlert_And_ValidateText(expectedMessage);
    }



}

