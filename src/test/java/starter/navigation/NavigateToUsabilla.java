package starter.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateToUsabilla {

    UsabillaHomePage usabillaHomePage;

    @Step("Open the Usabilla home page")
    public void theUsabillaHomePage() {
        usabillaHomePage.open();
    }

}

