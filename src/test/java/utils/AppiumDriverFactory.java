package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverFactory {
    private static AppiumDriverFactory instanceOfAppiumDriverFactory = null;
    private AppiumDriver driver;

    private AppiumDriverFactory() {

        CapabsReader cap = new CapabsReader();
        if (ConfigFileReader.getConfigPropertyVal("PLATFORM_NAME").equalsIgnoreCase("android")) {
            try {
                driver = new AndroidDriver<>(new URL(ConfigFileReader.getConfigPropertyVal("APPIUM_SERVE_URL")), cap.getCapabilities());
            } catch (MalformedURLException e) {
                throw new RuntimeException("URL de l'Appium Server invalide", e);
            }
        }else if (ConfigFileReader.getConfigPropertyVal("PLATFORM_NAME").equalsIgnoreCase("iOS")){
            try {
                driver = new IOSDriver<>(new URL(ConfigFileReader.getConfigPropertyVal("APPIUM_SERVE_URL")), cap.getCapabilities());
            } catch (MalformedURLException e) {
                throw new RuntimeException("URL de l'Appium Server invalide", e);
            }

        }
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    public synchronized static AppiumDriverFactory getInstanceOfAppiumDriverFactory() {
        if (instanceOfAppiumDriverFactory == null)
            instanceOfAppiumDriverFactory = new AppiumDriverFactory();
        return instanceOfAppiumDriverFactory;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public synchronized void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
