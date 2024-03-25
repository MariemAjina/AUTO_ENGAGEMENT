package Pages;

import globalData.Global_Data;
import globalData.Global_DataHomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import locators.Anatomy.AnatomyLoactors;
import locators.Home.HomeLocators;
import locators.WelcomeScreen.WelcomeLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AppiumDriverFactory;
import utils.MobileUtils;
import globalData.Anatomy.Anatomy_Data;

import java.util.List;
import java.util.NoSuchElementException;

import static utils.MobileUtils.*;

public class AnatomyPage {
    Global_DataHomePage global_DataHomePage = new Global_DataHomePage();
    Anatomy_Data global_Data_ANATOMY_BARE_BONES = new Anatomy_Data();
    AnatomyLoactors locators_ANATOMY_BARE_BONES = new AnatomyLoactors();

    AppiumDriver driver = null;
    AppiumDriverFactory appiumDriverFactory = AppiumDriverFactory.getInstanceOfAppiumDriverFactory();
    MobileUtils mobileUtils;


    public void VerifDipslayedCardBareBones() throws InterruptedException {
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        Global_DataHomePage globalData = new Global_DataHomePage();

        for (String NamePackage : packagePrefixes) {
            // Définir un indicateur pour vérifier si de nouveaux éléments sont trouvés après le défilement
            boolean newElementsFound = true;
            boolean isTextDisplayed = false;
            // Tant que de nouveaux éléments sont trouvés après le défilement
            while (newElementsFound) {
                // Trouver tous les éléments correspondant à votre XPath actuel
                List<WebElement> elements = driver.findElements(By.xpath(HomeLocators.CARD_TITLE_PART1 + NamePackage + HomeLocators.CARD_TITLE_PART2));
                for (WebElement element : elements) {
                    System.out.println("elemen" + element);
                    // Récupérer et afficher le texte de chaque élément
                    String text = element.getText();
                    // Vérifier si le texte souhaité est affiché
                    if (text.equals(globalData.LastCardTitleToVerify)) {
                        newElementsFound = false;
                        break; // Sortir de la boucle for
                    }
                    // Vérifier si le texte "Get started with introductory anatomy" est affiché
                    if (text.equals(globalData.CardTitleToVerify)) {
                        isTextDisplayed = true;
                    }
                }
                // Effectuer un défilement vers le bas
                driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
                // Attendre un court instant pour que les nouveaux éléments soient chargés
                Thread.sleep(700);
            }
            // Assertion pour vérifier si le texte "Get started with introductory anatomy" est affiché
            Assert.assertTrue(isTextDisplayed, global_Data_ANATOMY_BARE_BONES.ErrorMsg);
        }

    }

    public void ScrollVersHaut() throws InterruptedException {
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        Global_DataHomePage globalData = new Global_DataHomePage();
        for (String NamePackage : packagePrefixes) {
            // Définir un indicateur pour vérifier si de nouveaux éléments sont trouvés après le défilement
            boolean newElementsFound = true;
            // Tant que de nouveaux éléments sont trouvés après le défilement
            while (newElementsFound) {
                // Trouver tous les éléments correspondant à votre XPath actuel
                List<WebElement> elements = driver.findElements(By.xpath(HomeLocators.CARD_TITLE_PART1 + NamePackage + HomeLocators.CARD_TITLE_PART2));
                for (WebElement element : elements) {
                    // Récupérer et afficher le texte de chaque élément
                    String text = element.getText();
                    // Vérifier si le texte souhaité est affiché
                    if (text.equals(globalData.CardTitleToVerify)) {
                        newElementsFound = false;
                        break; // Sortir de la boucle for
                    }
                }
                // Effectuer un défilement vers le haut
                driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
                // Attendre un court instant pour que les nouveaux éléments soient chargés

            }
        }
    }

    public void ClickOnAnatomyTheBareBones() {
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        for (String NamePackage : packagePrefixes) {
            driver.findElement(By.xpath(locators_ANATOMY_BARE_BONES.ELEMENT_OnAnatomyTheBareBones_PART1 + NamePackage + locators_ANATOMY_BARE_BONES.ELEMENT_OnAnatomyTheBareBones_PART2)).click();
        }
    }

    public void ClickOnElementAnatomicalPositionAndPlanes() {
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        for (String NamePackage : packagePrefixes) {
            driver.findElement(By.id(NamePackage + locators_ANATOMY_BARE_BONES.ELEMENT_AnatomicalPositionAndPlanes)).click();
        }
    }

    public void ClickOnElementMovement() {
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        AnatomyLoactors OBJ = new AnatomyLoactors();
        for (String NamePackage : packagePrefixes) {
            WebElement element = driver.findElement(By.xpath(OBJ.ELEMENT_Movement));
            element.click();
        }
    }

    public void ClickOnElementDermatomes() {
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        AnatomyLoactors OBJ = new AnatomyLoactors();
        for (String NamePackage : packagePrefixes) {
            WebElement element = driver.findElement(By.xpath(OBJ.ELEMENT_Dermatomes));
            element.click();
        }
    }

    public void ClickOnElementNervousSystem() {
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        AnatomyLoactors OBJ = new AnatomyLoactors();
        for (String NamePackage : packagePrefixes) {
            WebElement element = driver.findElement(By.xpath(OBJ.ELEMENT_Nervous_System));
            element.click();
        }
    }

    //    public void CheckZoom(){
//        driver = appiumDriverFactory.getDriver();
//        mobileUtils = new MobileUtils(driver);
//        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
//        for (String NamePackage : packagePrefixes) {
//            driver.findElement(By.xpath(locators_ANATOMY_BARE_BONES.Picture)).click();
//            driver.findElement(By.id(NamePackage + locators_ANATOMY_BARE_BONES.Picture_FullScreen)).click();
//            WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.mobelite.emeeApp:id/txt_title_full_image']"));
//            String content = element.getText();
//            Assert.assertEquals(content, global_Data_ANATOMY_BARE_BONES.TitlePicture_ANATOMY_BARE_BONES, global_Data_ANATOMY_BARE_BONES.ErrorMsg);
//            driver.findElement(By.id(NamePackage + locators_ANATOMY_BARE_BONES.IdClosePicture)).click();
//        }
//    }
    public void CheckZoom() throws InterruptedException {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();

        for (String NamePackage : packagePrefixes) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators_ANATOMY_BARE_BONES.Picture)));
            Thread.sleep(4000);
            elements.click();


//        driver.findElement(By.id(NamePackage + locators_ANATOMY_BARE_BONES.Picture_FullScreen)).click();
//
//        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.mobelite.emeeApp:id/txt_title_full_image']"));
//
//        String content = element.getText();
//
//        Assert.assertEquals(content, global_Data_ANATOMY_BARE_BONES.TitlePicture_ANATOMY_BARE_BONES, global_Data_ANATOMY_BARE_BONES.ErrorMsg);

            //driver.findElement(By.id(NamePackage + locators_ANATOMY_BARE_BONES.IdClosePicture)).click();

        }

    }

    public void CheckZoomOUT() throws InterruptedException {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();

        for (String NamePackage : packagePrefixes) {


            driver.findElement(By.id(NamePackage + locators_ANATOMY_BARE_BONES.IdClosePicture)).click();

        }

    }

    public void CheckImageFullScreen() throws InterruptedException {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();

        for (String NamePackage : packagePrefixes) {

            driver.findElement(By.id(NamePackage + locators_ANATOMY_BARE_BONES.Picture_FullScreen)).click();

            WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.mobelite.emeeApp:id/txt_title_full_image']"));

            String content = element.getText();

            Assert.assertEquals(content, global_Data_ANATOMY_BARE_BONES.TitlePicture_ANATOMY_BARE_BONES, global_Data_ANATOMY_BARE_BONES.ErrorMsg);

            //driver.findElement(By.id(NamePackage + locators_ANATOMY_BARE_BONES.IdClosePicture)).click();

        }

    }

    //android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView[2]
    public void VisitWithoutAccount() {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        // Obtenez le package actuel de l'application
        //String currentPackage = ((AndroidDriver) driver).getCurrentPackage();
        String currentBundleId = null;
        if (driver instanceof AndroidDriver) {
            currentBundleId = ((AndroidDriver<MobileElement>) driver).getCurrentPackage();
        } else if (driver instanceof IOSDriver) {
            currentBundleId = getCurrentBundleId((IOSDriver<MobileElement>) driver);
        }
        // System.out.println("Package actuel : " + currentPackage);
        System.out.println("Bundle ID actuel : " + currentBundleId);
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        //String elementId = UiSelectors.LOGIN_SCREEN_WELCOME_LAYOUT;

        for (String NamePackage : packagePrefixes) {
            String btn_loginScreenWelcome = MobileUtils.getFullId(NamePackage, WelcomeLocators.BUTTON_VISITEUR);
            String btn_scrollContinueLayout = MobileUtils.getFullId(NamePackage, WelcomeLocators.SCROLL_CONTINUE_LAYOUT);
            String termsAndConditions = MobileUtils.getFullId(NamePackage, WelcomeLocators.TERMS_CONDITIONS_CHECKBOX);
            String privacyPolicy = MobileUtils.getFullId(NamePackage, WelcomeLocators.PRIVACY_POLICY_CHECKBOX);
            String buttonContinue = MobileUtils.getFullId(NamePackage, WelcomeLocators.BUTTON_CONTINUE);
            String constraintLayoutHomeItem = MobileUtils.getFullId(NamePackage, WelcomeLocators.CONSTRAINT_LAYOUT_HOME_ITEM);
            // System.out.println(btn_loginScreenWelcome);
            // Cliquez sur les éléments correspondant au package actuel
            clickElementByIdWithPackage(driver, NamePackage, btn_loginScreenWelcome);
            clickElementByIdWithPackage(driver, NamePackage, btn_scrollContinueLayout);
            for (int i = 0; i < 3; i++) {
                clickElementByIdWithPackage(driver, NamePackage, btn_scrollContinueLayout);
            }
            clickElementByIdWithPackage(driver, NamePackage, termsAndConditions);
            clickElementByIdWithPackage(driver, NamePackage, privacyPolicy);
            clickElementByIdWithPackage(driver, NamePackage, buttonContinue);
            // AndroidUtils.clickElementByIdWithPackage(driver, NamePackage,constraintLayoutHomeItem );
        }
    }


    public void VisitWithAccount() {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        // Obtenez le package actuel de l'application
        //String currentPackage = ((AndroidDriver) driver).getCurrentPackage();
        //System.out.println("Package actuel : " + currentPackage);
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        //String elementId = UiSelectors.LOGIN_SCREEN_WELCOME_LAYOUT;
        for (String NamePackage : packagePrefixes) {
            String btn_loginScreenWelcome = MobileUtils.getFullId(NamePackage, WelcomeLocators.BUTTON_Enregistrer);
            String btn_scrollContinueLayout = MobileUtils.getFullId(NamePackage, WelcomeLocators.SCROLL_CONTINUE_LAYOUT);
            String termsAndConditions = MobileUtils.getFullId(NamePackage, WelcomeLocators.TERMS_CONDITIONS_CHECKBOX);
            String privacyPolicy = MobileUtils.getFullId(NamePackage, WelcomeLocators.PRIVACY_POLICY_CHECKBOX);
            String buttonContinue = MobileUtils.getFullId(NamePackage, WelcomeLocators.BUTTON_CONTINUE);
            String constraintLayoutHomeItem = MobileUtils.getFullId(NamePackage, WelcomeLocators.CONSTRAINT_LAYOUT_HOME_ITEM);
            // System.out.println(btn_loginScreenWelcome);
            // Cliquez sur les éléments correspondant au package actuel
            clickElementByIdWithPackage(driver, NamePackage, btn_loginScreenWelcome);
            clickElementByIdWithPackage(driver, NamePackage, btn_scrollContinueLayout);
            for (int i = 0; i < 3; i++) {
                clickElementByIdWithPackage(driver, NamePackage, btn_scrollContinueLayout);
            }
            clickElementByIdWithPackage(driver, NamePackage, termsAndConditions);
            clickElementByIdWithPackage(driver, NamePackage, privacyPolicy);
            clickElementByIdWithPackage(driver, NamePackage, buttonContinue);
            // AndroidUtils.clickElementByIdWithPackage(driver, NamePackage,constraintLayoutHomeItem );
        }
    }

    public void WelcomeDisplayed() {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();

        for (String NamePackage : packagePrefixes) {
            String welcomeElementSelector = MobileUtils.getFullId(NamePackage, WelcomeLocators.WELCOME_SCREEN);

            // Utilisez la fonction objectExists en lui passant le sélecteur que vous avez créé
            boolean isWelcomeDisplayed = objectExists(By.id(welcomeElementSelector));

            // Vous pouvez maintenant utiliser la valeur de retour pour effectuer les actions nécessaires, par exemple, afficher un message
            if (isWelcomeDisplayed) {
                System.out.println("Welcome Screen is displayed for package: " + NamePackage);
            } else {
                System.out.println("Welcome Screen is not displayed for package: " + NamePackage);
            }
        }
    }

    public void HomePageDisplayed() {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();

        for (String NamePackage : packagePrefixes) {
            String welcomeElementSelector = MobileUtils.getFullId(NamePackage, HomeLocators.Home);

            // Utilisez la fonction objectExists en lui passant le sélecteur que vous avez créé
            boolean isWelcomeDisplayed = objectExists(By.id(welcomeElementSelector));

            // Vous pouvez maintenant utiliser la valeur de retour pour effectuer les actions nécessaires, par exemple, afficher un message
            if (isWelcomeDisplayed) {
                System.out.println("Welcome Screen is displayed for package: " + NamePackage);
            } else {
                System.out.println("Welcome Screen is not displayed for package: " + NamePackage);
            }
        }
    }

    public void AnatomyModuleDisplayd() {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();
        AnatomyLoactors OBJ = new AnatomyLoactors();

        for (String NamePackage : packagePrefixes) {
            String welcomeElementSelector = MobileUtils.getFullId(NamePackage, OBJ.Title_Module_anatomy);

            // Utilisez la fonction objectExists en lui passant le sélecteur que vous avez créé
            boolean isWelcomeDisplayed = objectExists(By.id(welcomeElementSelector));

            // Vous pouvez maintenant utiliser la valeur de retour pour effectuer les actions nécessaires, par exemple, afficher un message
            if (isWelcomeDisplayed) {
                System.out.println("Anatomy Screen is displayed for package: " + NamePackage);
            } else {
                System.out.println("Anatomy Screen is not displayed for package: " + NamePackage);
            }
        }
    }

    public void verifyElementDisplayedById(String packageName, String resourceId) {
        try {
            WebElement element = driver.findElement(By.xpath(resourceId));
            Assert.assertTrue(element.isDisplayed(), "Element is displayed: " + resourceId);
            System.out.println("Element  found: " + resourceId);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + resourceId);
            Assert.fail("Element not found: " + resourceId);
        }
    }

    public void verifyTitlesDisplayed() {
        Anatomy_Data globalData = new Anatomy_Data();
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();

        for (String packageName : packagePrefixes) {
            for (String title : globalData.getTitlesToVerify()) {
                String resourceId = getResourceIdForTitle(title);
                verifyElementDisplayedById(packageName, resourceId);
            }
        }
    }

    public String getResourceIdForTitle(String title) {
        AnatomyLoactors elements = new AnatomyLoactors();
        // Associez chaque titre à son ID de ressource correspondant dans votre application
        switch (title) {
            case "Anatomical Position and Planes":
                return elements.elementId1;
            case "Movement":
                return elements.elementId2;
            case "Dermatomes":
                return elements.elementId3;
            case "Nervous System":
                return elements.elementId4;
            default:
                return "";
        }
    }

    public void backButton() throws InterruptedException {
        driver = appiumDriverFactory.getDriver();
        mobileUtils = new MobileUtils(driver);
        AnatomyLoactors button = new AnatomyLoactors();
        List<String> packagePrefixes = Global_Data.getAppPackagePrefixes();

        //String elementId = UiSelectors.LOGIN_SCREEN_WELCOME_LAYOUT;
        for (String NamePackage : packagePrefixes) {
            String btn_back = MobileUtils.getFullId(NamePackage, button.back);

            // Cliquez sur les éléments correspondant au package actuel
            clickElementByIdWithPackage(driver, NamePackage, btn_back);

        }

    }

}

