import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Swipe_Android_Test {


    public AndroidDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir")+"\\apps\\ApiDemos.apk");
//        caps.setCapability("appPackage","com.android.calculator2");
//        caps.setCapability("appActivity",".Calculator");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
    }


    @Test
    public void swipe_test(){
        AndroidElement views =
                (AndroidElement) driver.findElementByAccessibilityId("Views");
        // Tap Views
        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();

        AndroidElement gallery =
                (AndroidElement) driver.findElementByAccessibilityId("Gallery");
        // Tap Gallery
        actions.tap(ElementOption.element(gallery)).perform();

        AndroidElement photo =
                (AndroidElement) driver.findElementByAccessibilityId("1. Photos");
        // Tap Photos
        actions.tap(ElementOption.element(photo)).perform();

        AndroidElement picture1 =
                (AndroidElement) driver.findElementsByClassName("android.widget.ImageView").get(0);
        // Swipe picture1
        actions.press(ElementOption.element(picture1))
                .waitAction()
                .moveTo(PointOption.point(-200, 0))
                .release()
                .perform();
    }

    @AfterTest
    public void tearDown() {
        if(null != driver){
            driver.quit();;
        }
    }

}
