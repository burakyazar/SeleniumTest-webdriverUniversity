package stepDefinitions;

import com.sun.source.tree.WhileLoopTree;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Contact_PO;
import pageObject.Login_PO;


public class Contact_Us_Steps extends Base_PO {
//burayi da login page gibi baglamalisin base po dan cekmelisin
private WebDriver driver = getDriver();

    private Contact_PO contact_po;
    public Contact_Us_Steps(Contact_PO contact_po){
        this.contact_po = contact_po;

    }




    @Given ("i access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
contact_po.navigateTo_WebdriverUniversity_Contact_Page();
    }

    @When("i enter a unique first name")
    public void i_enter_a_unique_first_name() {
contact_po.setUnique_FirstName();
    }
// bu kısmı da yukarıdakı gıbı yapabılırız.
    @And("i enter a unique last name")
    public void i_enter_a_unique_last_name() {
contact_po.setUnique_LastName();
    }

    @And("i enter a unique e-mail adress")
    public void i_enter_a_unique_e_mail_address() {
contact_po.setUnique_EmailAdress();
   }

    @And("i enter a unique comment")
    public void i_enter_a_unique_comment() {
contact_po.setUnique_Comment();
    }
    @And("i click on the submit botton")
    public void i_click_on_the_submit_button() {

 contact_po.clickOn_Submit_Button();
    }

    @Then("i should be presented with a succesful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message= driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(),"Thank You for your Message!");
    }
    @And("i want to run the scenario 10 times")
    public void i_want_to_run_the_scenario_10_times() {
        for (int i = 0; i < 10; i++) {
            i_access_the_webdriver_university_contact_us_page();
            i_enter_a_unique_first_name();
            i_enter_a_unique_last_name();
            i_enter_a_unique_e_mail_address();
            i_enter_a_unique_comment();
            i_click_on_the_submit_button();

        }
    }

    @When("i enter a specific first name {word}")
    public void i_enter_a_specific_first_name_burak(String firstName) {
contact_po.setSpecific_FirstName(firstName);

    }
    @When("i enter a specific last name {word}")
    public void i_enter_a_specific_last_name_yazar(String lastName) {
contact_po.setSpecific_LastName(lastName);


    }
    @When("i enter a specific email adress {word}")
    public void i_enter_a_specific_email_adress_burakyazar_gmail_com(String email) {
contact_po.setSpecific_Email(email);

    }
    @When("i enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
contact_po.setSpecific_Comment(comment);
    }






}
