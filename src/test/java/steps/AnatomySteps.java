package steps;

import Pages.AnatomyPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import globalData.Global_DataHomePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverFactory;
import utils.MobileUtils;

public class AnatomySteps {
    AnatomyPage anatomy = new AnatomyPage();
    AppiumDriver driver = null;
    AppiumDriverFactory appiumDriverFactory = AppiumDriverFactory.getInstanceOfAppiumDriverFactory();
    MobileUtils mobileUtils;
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
//        Thread.sleep(1000);

    }
    @Given("^Title & content & image displyed$")
    public void title_content_image_displyed() throws Throwable {
        anatomy.AnatomyModuleDisplayd();


    }

    @When("^user click on the loop button to zooms in on the figure$")
    public void user_click_on_the_loop_button_to_zooms_in_on_the_figure() throws Throwable {
        Thread.sleep(1000);
      anatomy.CheckZoom();
        System.out.println("zoom");

    }

    @Then("^the figure should be enlarged for detailes exmination$")
    public void the_figure_should_be_enlarged_for_detailes_exmination() throws Throwable {
        Thread.sleep(1000);
        anatomy.CheckImageFullScreen();
        System.out.println("image big");

    }

    @Then("^the user should be able to zoom out to the original size(\\d+)$")
    public void the_user_should_be_able_to_zoom_out_to_the_original_size(int arg1) throws Throwable {
        Thread.sleep(1000);
        anatomy.CheckZoomOUT();
        System.out.println("zoom out");
        anatomy.backButton();
    }
    @When("^the user selects the second sub-content$")
    public void the_user_selects_the_second_sub_content() throws Throwable {
        anatomy.ClickOnElementMovement();
    }
    @When("^the user selects the Third sub-content$")
    public void the_user_selects_the_Third_sub_content() throws Throwable {
      anatomy.ClickOnElementDermatomes();
    }

    @When("^the user selects the fourth sub-content$")
    public void the_user_selects_the_fourth_sub_content() throws Throwable {
       anatomy.ClickOnElementNervousSystem();
    }
}


