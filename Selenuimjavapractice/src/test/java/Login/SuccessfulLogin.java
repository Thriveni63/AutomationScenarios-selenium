package Login;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulLogin {

	public static void main(String[] args) {
		
		/*Launch the browser.
		Navigate to the login page URL.
		Verify that the login page is displayed successfully.
		Enter Username: practice.
		Enter Password: SuperSecretPassword!.
		Click the Login button.
		Verify that the user is redirected to the /secure page.
		Confirm the success message "You logged into a secure area!" is visible.
		Verify that a Logout button is displayed.*/
		
		//Launch the browser
		
		WebDriver driver=new ChromeDriver();
		
		//Navigate to the login page URL.
		
		String BASE_URL = "https://practice.expandtesting.com";      // Root URL
		String LOGIN_URL = BASE_URL + "/login";       // Sub URL
		String PROFILE_URL = BASE_URL + "/secure"; 
		driver.navigate().to("https://practice.expandtesting.com/login");
		driver.manage().window().maximize();
		
		//Verify that the login page is displayed successfully.
		
		List<WebElement> username = driver.findElements(By.id("username"));

		if(username.size() > 0){
		    System.out.println("username is present");
		} else {
		    System.out.println("username is NOT present");
		}
		
		List<WebElement> password = driver.findElements(By.id("password"));

		if(password.size() > 0){
		    System.out.println("password is present");
		} else {
		    System.out.println("password is NOT present");
		}
		
		List<WebElement> loginbutton = driver.findElements(By.id("submit-login"));

		if(loginbutton.size() > 0){
		    System.out.println("loginbutton is present");
		} else {
		    System.out.println("loginbutton is NOT present");
		}	
	
		
		//Enter Username: practice.
		
		WebElement userName=driver.findElement(By.id("username"));
		userName.sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.id("username")).sendKeys("practice");
		
		//Enter Password: SuperSecretPassword!.
		
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		//Click the Login button.
		
		WebElement loginButton=driver.findElement(By.xpath("//form[@id=\"login\"]/button"));		
		loginButton.click();
		
		//	Verify that the user is redirected to the /secure page.	
		
		String actualUrl=driver.getCurrentUrl();
		if(actualUrl.equals(PROFILE_URL))
		{
			System.out.println("URL is correct: " + actualUrl);
		} else {
		    System.out.println("URL mismatch! Expected: " + PROFILE_URL + ", but found: " + actualUrl);
		}
		
		
		//Confirm the success message "You logged into a secure area!" is visible.
		
		String expectedText="Secure Area page for Automation Testing Practice";
		String actualText=driver.findElement(By.xpath("//h1[text()='Secure Area page for Automation Testing Practice']")).getText();
		if(actualText.equals(expectedText))
		{
			System.out.println("Text is correct: " + actualText);
		} else {
		    System.out.println("Text mismatch! Expected: " + expectedText + ", but found: " + actualText);
		}
		
		//Verify that a Logout button is displayed.
		
		List<WebElement> logoutbutton = driver.findElements(By.xpath("//div[@id=\"core\"]/div/div/a"));

		if(logoutbutton.size() > 0){
		    System.out.println("logoutbutton is present");
		} else {
		    System.out.println("logoutbutton is NOT present");
		}	
		
		WebElement logoutButton=driver.findElement(By.xpath("//div[@id=\"core\"]/div/div/a"));
		logoutButton.sendKeys(Keys.PAGE_DOWN);
		logoutButton.click();
		
		driver.close();
		
		
	
	
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
	

	}

}
