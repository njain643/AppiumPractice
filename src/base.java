import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> Capability(String device) throws MalformedURLException {
		File file = new File("C:\\Users\\nikjain\\eclipse-workspace\\Tutorial\\src\\api_demo.apk");
		
		DesiredCapabilities capability = new DesiredCapabilities();
		if(device.equals("emulator")) {
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, "NikhilEmulator");
		}
		else if(device.equals("real")){
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}
		capability.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		capability.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

		AndroidDriver<AndroidElement> driver = 
				new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		return driver;
				
	}

}
