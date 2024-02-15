package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

import java.lang.reflect.Field;

public class AndroidUtils {
    private AppiumDriver driver;



    public AndroidUtils(AppiumDriver driver) {
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

    public WebElement findElementById(String id) {

        return driver.findElement(By.id(id));
    }

    public void clickElementById(String elementId) {
        WebElement element = driver.findElement(By.id(elementId));
        element.click();
    }
    public Boolean objectExists(By by) {
        try {
            if (driver.findElements(by).size() == 0) {
                return false;
            } else {
                return true;
            }
        }catch (Exception ex){
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
    public static void clickElementById(AppiumDriver driver,String packagePrefix, String elementId) {
//        try {
//            driver.findElement(By.id(elementId)).click();
//        } catch (NoSuchElementException e) {
//            System.out.println("L'élément avec l'ID " + elementId + " n'a pas été trouvé.");
//        }
        // Vérifier le package actuel
        String currentPackage = ((AndroidDriver) driver).getCurrentPackage();
        if (!currentPackage.startsWith(packagePrefix)) {
            System.out.println("Le package actuel ne correspond pas au préfixe attendu.");
            return;
        }

        // Si le package est correct, cliquez sur l'élément
        try {
            driver.findElement(By.id(elementId)).click();
        } catch (NoSuchElementException e) {
            System.out.println("L'élément avec l'ID " + elementId + " n'a pas été trouvé.");
        }
    }

    public static void clickElementByIdWithPackage(AppiumDriver driver, String packageName, String locatorId) {
        // Vérifier le package actuel
        String currentPackage = ((AndroidDriver) driver).getCurrentPackage();
        if (!currentPackage.startsWith(packageName)) {
            System.out.println("Le package actuel ne correspond pas au packageName attendu.");
            return;
        }

        // Si le package est correct, cliquez sur l'élément
        try {
            driver.findElement(By.id(locatorId)).click();
        } catch (NoSuchElementException e) {
            System.out.println("L'élément avec l'ID " + locatorId + " n'a pas été trouvé.");
        }
    }

    public static String getFullId(String packageName, String elementId) {
        //  return packagePrefix + elementId;
        String fullId = packageName + elementId;
        System.out.println(fullId);
        return fullId;
    }

}

