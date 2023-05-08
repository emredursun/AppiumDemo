import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Drag_Drop_Test {

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

    private void scrollDown(){

    }

    @Test
    public void drag_drop(){
        AndroidElement views =
                (AndroidElement) driver.findElementByAccessibilityId("Views");
        // Tap Views
        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();


        AndroidElement dragAndDrop =
                (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");
        // Tap Lists
        actions.tap(ElementOption.element(dragAndDrop)).perform();

        AndroidElement drag = (AndroidElement) driver.findElement(By.id("drag_dot_1"));
        AndroidElement drop = (AndroidElement) driver.findElement(By.id("drag_dot_2"));

        actions.longPress(ElementOption.element(drag))
                .waitAction().moveTo(ElementOption.element(drop))
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
