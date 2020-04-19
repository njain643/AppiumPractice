import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends base {
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		AndroidDriver<AndroidElement> driver = Capability("real");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Preference dependencies')]")).click();
		AndroidElement wifi_checkbox_ele = driver.findElement(By.id("android:id/checkbox"));
		if(!wifi_checkbox_ele.isSelected()){
			wifi_checkbox_ele.click();
		}
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("hello");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
