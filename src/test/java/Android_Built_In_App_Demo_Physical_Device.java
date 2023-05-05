import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Android_Built_In_App_Demo_Physical_Device {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Galaxy S21 Ultra 5G");
        // Samsung Calculator Package Activity Settings
        caps.setCapability("appPackage","com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity",".Calculator");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void click_test_samsung_calculator(){
        driver.findElement(By.id("calc_keypad_btn_01")).click();
        driver.findElement(By.id("calc_keypad_btn_add")).click();
        driver.findElement(By.id("calc_keypad_btn_03")).click();
        driver.findElement(By.id("calc_keypad_btn_equal")).click();
        String result = driver.findElement(By.id("calc_edt_formula")).getText();
        Assert.assertEquals(result, "4 Calculation result");
    }

    @AfterTest
    public void tearDown() {
        if(null != driver){
            driver.quit();;
        }
    }

}
