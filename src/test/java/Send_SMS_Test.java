import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Send_SMS_Test {

    public AndroidDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("deviceName", "Android Emulator");
//        caps.setCapability("automationName", "UiAutomator2");
//        caps.setCapability("app", System.getProperty("user.dir")+"\\apps\\ApiDemos.apk");
        caps.setCapability("appPackage","com.google.android.apps.messaging");
        caps.setCapability("appActivity",".ui.ConversationListActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
    }


    @Test
    public void send_SMS(){
        driver.sendSMS("555-123-4567","Hello from Appium!");
    }


//    @Test
//    public void delete_SMS() {
//        AndroidElement selectSMS1 = (AndroidElement) driver.findElementsByClassName("android.widget.LinearLayout").get(0);
//        AndroidElement moreOptions = (AndroidElement) driver.findElementByAccessibilityId("More options");
//        AndroidElement deleteSMS = (AndroidElement) driver.findElementsByClassName("android.widget.TextView").get(4);
//        AndroidElement confirmDeletion = (AndroidElement) driver.findElementById("button1");
//
//        actions = new AndroidTouchAction(driver);
//        actions.tap(ElementOption.element(selectSMS1))
//                .tap(ElementOption.element(moreOptions))
//                .tap(ElementOption.element(deleteSMS))
//                .tap(ElementOption.element(confirmDeletion))
//                .perform();
//    }


    @AfterTest
    public void tearDown() {
        if(null != driver){
            driver.quit();;
        }
    }

}
