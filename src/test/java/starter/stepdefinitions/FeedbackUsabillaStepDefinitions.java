package starter.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.navigation.NavigateToUsabilla;
import starter.feedback.FeedbackSubmit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class FeedbackUsabillaStepDefinitions {

    @Steps
    NavigateToUsabilla navigateTo;
    FeedbackSubmit feedbackSubmit;


    @Given("^(?:.*) is on the Usabilla home page")
    public void the_user_on_the_Usabilla_home_page() {
        navigateTo.theUsabillaHomePage();
    }

    @When("the user selects General feedback")
    public void i_select_general_feedback() {
        feedbackSubmit.selectGeneralFeedbackForm();
    }

    @When("the user selects Specific feedback")
    public void i_select_specific_feedback() {
        feedbackSubmit.selectSpecificFeedbackForm();
    }

    @When("the user fills in all fields")
    public void i_fill_in_all_fields_feedback_form() {
        feedbackSubmit.fillInFeedbackForm();
    }

    @Then("feedback should be submitted")
    public void success_dialog_should_have_continue_button(){
        assertThat(feedbackSubmit.IsContinueButtonVisible()).isTrue();
        getDriver().close();
    }

    @When("the user fills in all mandatory fields")
    public void  i_fill_in_all_mandatory_fields_feedback_form() {
        feedbackSubmit.fillInMandatoryFieldsFeedbackForm();
    }


    @Then("email validation error should be shown")
    public void email_validation_error_should_be_shown(){
        assertThat(feedbackSubmit.IsEmailValidationErrorVisible()).isTrue();
        getDriver().close();
    }

    @When("the user fills all mandatory fields with incorrect email")
    public void  i_fill_in_all_mandatory_fields_with_incorrect_mail() {
        feedbackSubmit.fillInMandatoryFieldsWithIncorrectEmail();
    }

}
