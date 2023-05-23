import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Clipboard_Android_Test {
    private AndroidDriver<WebElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir")+"\\apps\\selendroid.apk");
//        caps.setCapability("appPackage","com.google.android.apps.photos");
//        caps.setCapability("appActivity",".home.HomeActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
    }


    @Test
    public void clipboard_test() {
        // Tap to OK while the update notification received!
        driver.findElementById("android:id/button1").click();

        String text = "Hello TAU";
        driver.setClipboardText(text);
        MobileElement nameTxt = (MobileElement) driver.findElementByAccessibilityId("my_text_fieldCD");

        nameTxt.clear();;
        nameTxt.sendKeys(driver.getClipboardText());
        Assert.assertEquals(text, nameTxt.getText());
    }



    @AfterTest
    public void tearDown() {
        if(null != driver){
            driver.quit();;
        }
    }
}
