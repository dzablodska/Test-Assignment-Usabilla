package starter.feedback;

import org.openqa.selenium.By;

class FeedbackForm {
    static By ACCEPT_COOKIES_BUTTON = By.cssSelector(" .optanon-button-allow");
    static By NAVIGATION_LOGO = By.cssSelector(" .navigation--logo");
    static By FEEDBACK_BUTTON = By.cssSelector(" .usabilla_live_button_container");
    static By GENERIC_FEEDBACK_BUTTON = By.cssSelector(" .choice_general");
    static By SPECIFIC_FEEDBACK_BUTTON = By.cssSelector(" .choice_specific");
    static By RATING_BUTTON = By.cssSelector("li.rating_5");
    static By SUBJECT_DROPDOWN_LIST = By.cssSelector("select[name=subject]");
    static By FEEDBACK_SUBMIT = By.cssSelector("button.submit");
    static By CONTINUE_BUTTON = By.cssSelector("a.continue");
    static By EMAIL_VALIDATION_ERROR = By.cssSelector("p[aria-describedby=email-input-compliment]");
}
