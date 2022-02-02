package stepDefinitions;

import Base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.LoginPage;

public class HomePageSteps extends TestBase {

    LoginPage loginPage = new LoginPage();



    @Given("^User launch the application$")
    public void User_launch_the_application() throws Throwable {
        TestBase.initialization();

    }

    @Then("^User validate the application is loaded$")
    public void User_validate_the_application_is_loaded() throws Throwable {
        //String title = loginPage.validateFedexImage();


    }

    @Then("^User click on login button$")
    public void User_click_on_login_button() throws Throwable {

    }

    @Then("^home page is diplayed$")
    public void home_page_is_diplayed() throws Throwable {

    }

    @Then("^validate check the title$")
    public void validate_check_the_title() throws Throwable {

    }


}
