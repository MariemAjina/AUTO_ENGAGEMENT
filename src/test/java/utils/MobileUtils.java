package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;

public class MobileUtils {
    //private AppiumDriver driver;

    //MobileUtils
    private static AppiumDriver<MobileElement> driver;



//    public AndroidUtils(AppiumDriver driver) {
//        this.driver = driver;
//    }

    //MobileUtils
    public MobileUtils(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    /**
     * Function to pause the execution for the specified time period
     *
     * @param milliSeconds The wait time in milliseconds
     */
    public void waitFor(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public static boolean objectExists(By by) {
        try {
            return driver.findElements(by).size() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public boolean enterValueInTextBox(String text, By by) {
        boolean flag = false;
        try {
            if (driver.findElement(by).isDisplayed()) {
                driver.findElement(by).click();
                driver.findElement(by).clear();
                driver.findElement(by).sendKeys(text);
                //driver.hideKeyboard();
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * Function to get the text of an element. Ex : get title or header
     *
     * param by  The {@link WebDriver} locator used to identify the
     *                         element
     * throwing Exception if element is not visible
     */
    public String getElementText(By by) {
        if (driver.findElement(by).isDisplayed()) {
            return driver.findElement(by).getText();
        } else {
            throw new ElementNotVisibleException("Element Not Found");
        }
    }


    public static String getCurrentBundleId(IOSDriver<MobileElement> driver) {
        String bundleId = null;
        try {
            // Utilisez l'API de l'application d'Appium pour obtenir le bundle ID
            bundleId = (String) driver.executeScript("mobile: launchApp", ImmutableMap.of("bundleId", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bundleId;
    }
    public static void clickElementByIdWithPackage(AppiumDriver<MobileElement> driver, String packageName, String locatorId) {
        String currentPackage = null;
        String currentBundleId = null;
        if (driver instanceof AndroidDriver) {
            currentPackage = ((AndroidDriver<MobileElement>) driver).getCurrentPackage();
        } else if (driver instanceof IOSDriver) {
            // Implémentez une logique pour récupérer le package actuel sur iOS
            // Par exemple, vous pouvez utiliser l'API de l'application pour obtenir le bundle ID de l'application
            // Consultez la documentation Appium pour trouver la méthode appropriée pour votre cas d'utilisation
            // currentBundleId = getCurrentBundleId((IOSDriver<MobileElement>) driver);
            System.out.println("IOS************");

        }

        if (currentPackage == null || !currentPackage.startsWith(packageName)) {
            System.out.println("Le package actuel ne correspond pas au packageName attendu.");
            return;
        }

        try {
            driver.findElement(By.id(locatorId)).click();
        } catch (NoSuchElementException e) {
            System.out.println("L'élément avec l'ID " + locatorId + " n'a pas été trouvé.");
        }
    }

    //pour les deux
    public static String getFullId(String packageName, String elementId) {
        //  return packagePrefix + elementId;
        String fullId = packageName + elementId;
        System.out.println(fullId);
        return fullId;
    }


}
