import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIautomatortest extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		AndroidDriver<AndroidElement> driver = Capability("real");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		int x = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
		System.out.print(x);

	}

}
