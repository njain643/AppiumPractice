import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class gesture extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		AndroidDriver<AndroidElement> driver = Capability("real");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		TouchAction action = new TouchAction(driver);
		WebElement ele = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
		action.tap(element(ele)).perform();
		ele = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
		action.tap(element(ele)).perform();
		ele = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		action.longPress(element(ele)).perform();
		if(driver.findElementById("android:id/title").isDisplayed()){
			driver.findElementByAndroidUIAutomator("text(\"Sample action\")").click();
		}
	}

}
