import java.net.MalformedURLException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class swipedemo extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		AndroidDriver<AndroidElement> driver = Capability("real");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'Inline')]").click();
		int x = 9;
		driver.findElementByXPath("//*[@content-desc='"+x+"']").click();
//		int y = 45;
//		driver.findElementByXPath("//*[@content-desc='"+y+"']").click();
		TouchAction touch = new TouchAction(driver);
		touch.longPress(element(driver.findElementByXPath("//*[@content-desc='15']"))).
		moveTo(element(driver.findElementByXPath("//*[@content-desc='45']"))).release().perform();
		
		
	}

}
