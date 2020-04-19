package GeneralStore;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_1 extends base{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capability();
		
		driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
//		
		String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println(toastMessage);
		
		driver.findElementByClassName("android.widget.Spinner").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))");
		driver.findElementByAndroidUIAutomator("text(\"India\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("Nikhil");
		driver.findElementByAndroidUIAutomator("text(\"Female\")").click();
		driver.findElementById("com.androidsample.generalstore:id/radioMale").click();

		driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
	}

}
