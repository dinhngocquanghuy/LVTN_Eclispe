package step;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test_Input_Step {
	public AppiumDriver<MobileElement> test_func() {
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Huy Phone");
		caps.setCapability("udid", "4200e3cbb4afb36b"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0");
		caps.setCapability("appPackage", "com.example.dinhngcquanghuy.simple_application");
		caps.setCapability("appActivity", "com.example.dinhngcquanghuy.simple_application.LoginActivity");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver
		try {
			return new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	protected AppiumDriver<MobileElement> driver = this.test_func();
	
	@Given("^Has loginned$")
	public void has_loginned() {
//		input email and console log
		MobileElement el1 = (MobileElement) driver.findElementById("com.example.dinhngcquanghuy.simple_application:id/input_email");
		el1.sendKeys("admin");
		el1 = (MobileElement) driver.findElementById("com.example.dinhngcquanghuy.simple_application:id/input_email");
		String text = el1.getText();
		System.out.println(text);
//		input password and console log
		el1 = (MobileElement) driver.findElementById("com.example.dinhngcquanghuy.simple_application:id/input_password");
		el1.sendKeys("123456789");
		el1 = (MobileElement) driver.findElementById("com.example.dinhngcquanghuy.simple_application:id/input_password");
		text = el1.getText();
		System.out.println(text);
//		click login button
		el1 = (MobileElement) driver.findElementById("com.example.dinhngcquanghuy.simple_application:id/btn_login");
		el1.click();
	}
	
	@When("^Tap into input$")
	public void tap_into_input() {
		MobileElement el1 = (MobileElement) driver.findElementById("com.example.dinhngcquanghuy.simple_application:id/editText");
		el1.click();
		el1.sendKeys("123");
		el1 = (MobileElement) driver.findElementById("com.example.dinhngcquanghuy.simple_application:id/button");
		el1.click();
	}
	
	@Then("^Show content$")
	public void result_tap_into_input() {
		MobileElement el1 = (MobileElement) driver.findElementById("com.example.dinhngcquanghuy.simple_application:id/textView");
		String text = el1.getText();
		System.out.println(text);
	}
}