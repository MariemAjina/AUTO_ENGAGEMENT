package steps;

import Pages.AnatomyPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import globalData.Global_DataHomePage;

public class AnatomySteps {
    AnatomyPage anatomy = new AnatomyPage();

    @Given("^the welcome screen dispayed$")
    public void the_welcome_screen_dispayed() throws Throwable {
        anatomy.WelcomeDisplayed();
    }

    @When("^the user clicks on \"([^\"]*)\"$")
    public void the_user_clicks_on(String arg1) throws Throwable {
        anatomy.VisitWithoutAccount();
    }

    @When("^the user accepts \"([^\"]*)\"$")
    public void the_user_accepts(String arg1) throws Throwable {
        anatomy.HomePageDisplayed();
    }

    @Then("^the anatomy card should be displayed on the home page$")
    public void the_anatomy_card_should_be_displayed_on_the_home_page() throws Throwable {
        anatomy.VerifDipslayedCardBareBones();
        anatomy.ScrollVersHaut();

    }
    @Then("^Acess to the anatomy card$")
    public void acess_to_the_anatomy_card() throws Throwable {
        anatomy.ClickOnAnatomyTheBareBones();
    }
    @Given("^the user is on the anatomy module page$")
    public void the_user_is_on_the_anatomy_module_page() throws Throwable {
       anatomy.AnatomyModuleDisplayd();
    }

    @When("^a list of sub-contents for the anatomy module should be displayed$")
    public void a_list_of_sub_contents_for_the_anatomy_module_should_be_displayed() throws Throwable {
        anatomy.verifyTitlesDisplayed() ;
    }

    @Then("^the user selects one of the sub-content$")
    public void the_user_selects_one_of_the_sub_content() throws Throwable {
        anatomy.ClickOnElementAnatomicalPositionAndPlanes();
    }

}


