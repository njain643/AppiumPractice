package mobile_browser;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class browser extends base {
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		AndroidDriver<AndroidElement> driver = Capability("real");
		driver.get("https://www.cricbuzz.com/");
//		driver.findElementByXPath("//a[@href='#menu']").click();
//		driver.findElementByCssSelector("a[title='Live Cricket Scores'").click();
//		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1000)");
		String result = driver.findElementByXPath("//h4[text()='Top Stories']").getAttribute("class");
		System.out.println(result);
		
	}

}
