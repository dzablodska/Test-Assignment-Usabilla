package starter.feedback;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.MouseEvent;

public class FeedbackSubmit extends UIInteractionSteps {

    @Step("Select General Feedback Form")
    public void selectGeneralFeedbackForm() {
        $(FeedbackForm.FEEDBACK_BUTTON).click();
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[title='Usabilla Feedback Form Frame']")));
        $(FeedbackForm.GENERIC_FEEDBACK_BUTTON).click();
        $(FeedbackForm.ACCEPT_COOKIES_BUTTON).waitUntilClickable();
        $(FeedbackForm.ACCEPT_COOKIES_BUTTON).click();
        $(FeedbackForm.ACCEPT_COOKIES_BUTTON).waitUntilNotVisible();
    }

    @Step("Select Specific Feedback Form")
    public void selectSpecificFeedbackForm() {
        $(FeedbackForm.FEEDBACK_BUTTON).click();
        $(FeedbackForm.ACCEPT_COOKIES_BUTTON).waitUntilClickable();
        $(FeedbackForm.ACCEPT_COOKIES_BUTTON).click();
        $(FeedbackForm.ACCEPT_COOKIES_BUTTON).waitUntilNotVisible();
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[title='Usabilla Feedback Form Frame']")));
        $(FeedbackForm.SPECIFIC_FEEDBACK_BUTTON).click();
        Actions action = new Actions(getDriver());
        action.moveToElement($(FeedbackForm.NAVIGATION_LOGO)).click().perform();
    }

    @Step("Fill in feedback form")
    public void fillInFeedbackForm() {
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[title='Usabilla Feedback Form Frame']")));
        $(FeedbackForm.RATING_BUTTON).click();
        $(FeedbackForm.SUBJECT_DROPDOWN_LIST).selectByValue("compliment");
        // Successful scenario with all form fields filled out
        $(FeedbackForm.SUBJECT_DROPDOWN_LIST).sendKeys(
                Keys.TAB, "Usabilla ROCKS!",
                Keys.TAB, "testing.usabilla@gmail.com",
                Keys.TAB, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT,
                Keys.ENTER
        );

    }

    @Step("Fill in all mandatory fields feedback form")
    public void fillInMandatoryFieldsFeedbackForm() {
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[title='Usabilla Feedback Form Frame']")));
        $(FeedbackForm.RATING_BUTTON).click();
        $(FeedbackForm.SUBJECT_DROPDOWN_LIST).selectByValue("compliment");
        $(FeedbackForm.SUBJECT_DROPDOWN_LIST).sendKeys(
                Keys.TAB, "Usabilla ROCKS!");
        $(FeedbackForm.FEEDBACK_SUBMIT).click();
    }

    @Step("Fill in all mandatory fields with incorrect email")
    public void  fillInMandatoryFieldsWithIncorrectEmail() {
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[title='Usabilla Feedback Form Frame']")));
        $(FeedbackForm.RATING_BUTTON).click();
        $(FeedbackForm.SUBJECT_DROPDOWN_LIST).selectByValue("compliment");
        $(FeedbackForm.SUBJECT_DROPDOWN_LIST).sendKeys(
                Keys.TAB, "Usabilla ROCKS!", Keys.TAB, "testing.usabillagmail.com", Keys.TAB,
                Keys.ENTER);
        $(FeedbackForm.FEEDBACK_SUBMIT).click();

    }

    @Step("Fill in optional fields feedback form")
    public void fillInOptionalFieldsFeedbackForm() {
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector("iframe[title='Usabilla Feedback Form Frame']")));
        $(FeedbackForm.RATING_BUTTON).click();
        $(FeedbackForm.SUBJECT_DROPDOWN_LIST).selectByValue("compliment");
        $(FeedbackForm.SUBJECT_DROPDOWN_LIST).sendKeys(
        Keys.TAB,
                Keys.TAB, "testing.usabilla@gmail.com",
                Keys.TAB,
                Keys.ENTER);
        $(FeedbackForm.FEEDBACK_SUBMIT).click();
    }

    @Step("feedback should be submitted")
    public Boolean IsContinueButtonVisible() {
        return $(FeedbackForm.CONTINUE_BUTTON).isVisible();
    }

    @Step("email validation error should be shown")
    public Boolean IsEmailValidationErrorVisible() {
        return $(FeedbackForm.EMAIL_VALIDATION_ERROR).isVisible();
    }
}
