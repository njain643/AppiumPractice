package GeneralStore;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_2 extends base{
	
	public static ArrayList<String> addToCartProduct(AndroidDriver<AndroidElement> driver, String product_name) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
        + "new UiSelector().text(\""+product_name+"\"));");
		
//		driver.findElementByXPath("//android.widget.TextView[text()='"+product_name+"']");
//		System.out.println(driver.findElementByXPath("//android.widget.TextView[text()='"+product_name+"']"));
		ArrayList<String> temp = new ArrayList<String>();

//		for(AndroidElement layout : layouts) {
//			System.out.println(layout.getText());
//		}
		
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		

		for(int i=0; i<count; i++) {
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			if(text.equals(product_name)) {
				temp.add(product_name);
				temp.add(driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText());
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		}
		return temp;
	}
	
	public static void verifyCartProducts(AndroidDriver<AndroidElement> driver, ArrayList<ArrayList<String>> products) {
		
		for(ArrayList<String> product : products) {
			
			String actual = driver.findElementByAndroidUIAutomator("text(\""+product.get(0)+"\")").getText();
			Assert.assertEquals(actual, product.get(0));
			
			actual = driver.findElementByAndroidUIAutomator("text(\""+product.get(1)+"\")").getText();
			Assert.assertEquals(actual, product.get(1));
		}
	}

	public static void verifyTotalProductCost(AndroidDriver<AndroidElement> driver, ArrayList<ArrayList<String>> products) {
		
		float sum = 0.0f;
		for(ArrayList<String> product : products) {
			sum += Float.parseFloat(product.get(1).substring(1));
		}
		
		String total_amount = "$ " + sum;
		String actual_amount = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		Assert.assertEquals(actual_amount, total_amount);
	}
	
	public static void tapOnCheckBox(AndroidDriver<AndroidElement> driver) {
		TouchAction act = new TouchAction(driver);
		act.tap(element(driver.findElementByClassName("android.widget.CheckBox"))).perform();
	}
	
	public static void longPressOnTerm(AndroidDriver<AndroidElement> driver) {
		TouchAction act = new TouchAction(driver);
		act.longPress(element(driver.findElementById("com.androidsample.generalstore:id/termsButton"))).perform();
		
		WebElement close_ele = driver.findElementByAndroidUIAutomator("text(\"CLOSE\")");
		
		Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/alertTitle").isDisplayed());
		Assert.assertTrue(close_ele.isDisplayed());
		
		close_ele.click();
	}
	
	
	public static void switchFromNativeToWebView(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		
		Thread.sleep(7000);
		Set<String> context_names = driver.getContextHandles();
		for(String context : context_names) {
			System.out.println(context);
		}
		// Switch to web view
		driver.context("WEBVIEW_com.androidsample.generalstore");
				
	}
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = capability();
		
		driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("Nikhil");

		driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
		ArrayList<ArrayList<String>> products = new ArrayList<ArrayList<String>>();
		
		products.add(addToCartProduct(driver, "Nike Blazer Mid '77"));
		products.add(addToCartProduct(driver, "PG 3"));
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();	
				
		verifyCartProducts(driver, products);
		
		verifyTotalProductCost(driver, products);
		
		tapOnCheckBox(driver);
		
		longPressOnTerm(driver);
		
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
		switchFromNativeToWebView(driver);
		
		System.out.println(driver.getTitle());
		driver.findElementByXPath("//input[@name='q']").sendKeys("Hello Nikhil");

	}

}
