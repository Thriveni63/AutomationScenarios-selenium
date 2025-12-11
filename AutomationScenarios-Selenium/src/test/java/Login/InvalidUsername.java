package Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidUsername {

	public static void main(String[] args) {

		/* Launch the browser. 
		 * Navigate to the login page URL. 
		 * Verify that the login
		 * page is displayed successfully. 
		 * Enter an incorrect Username (e.g.,wrongUser). 
		 * Enter Password: SuperSecretPassword!. 
		 * Click the Login button.
		 * Verify that an error message "Invalid username." is displayed. 
		 * Ensure the user remains on the login page.
		 */

		// Launch the browser

		WebDriver driver = new ChromeDriver();

		// Navigate to the login page URL.

		String BASE_URL = "https://practice.expandtesting.com"; // Root URL
		String LOGIN_URL = BASE_URL + "/login"; // Sub URL
		String PROFILE_URL = BASE_URL + "/secure"; // Another sub URL
		driver.navigate().to(LOGIN_URL);
		driver.manage().window().maximize();

		// Verify that the login page is displayed successfully.

		List<WebElement> username = driver.findElements(By.id("username"));

		if (username.size() > 0) {
			System.out.println("username is present");
		} else {
			System.out.println("username is NOT present");
		}

		List<WebElement> password = driver.findElements(By.id("password"));

		if (password.size() > 0) {
			System.out.println("password is present");
		} else {
			System.out.println("password is NOT present");
		}

		List<WebElement> loginbutton = driver.findElements(By.id("submit-login"));

		if (loginbutton.size() > 0) {
			System.out.println("loginbutton is present");
		} else {
			System.out.println("loginbutton is NOT present");
		}

		// Enter an incorrect Username (e.g., wrongUser).

		WebElement userName = driver.findElement(By.id("username"));
		((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", 
		        userName
		);
		driver.findElement(By.id("username")).sendKeys("wrongCheck");

		// Enter Password: SuperSecretPassword!.

		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

		// Click the Login button.

		WebElement loginButton = driver.findElement(By.xpath("//form[@id=\"login\"]/button"));
		((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", 
		        loginButton
		);
		loginButton.click();

		// Verify that an error message "Invalid username." is displayed.

		String actualError = driver.findElement(By.xpath("//div[@id=\"flash\"]/b")).getText();
		String expectedError = "Your username is invalid!";

		if (actualError.endsWith(expectedError)) {
			System.out.println("Correct Error message " +expectedError+" is present");
		} else {
			System.out.println("Incorrect Error message "+actualError+" is present");
		}

		// Ensure the user remains on the login page.

		List<WebElement> usernamecheck2 = driver.findElements(By.id("username"));

		if (usernamecheck2.size() > 0) {
			System.out.println("user is on login page");
		} else {
			System.out.println("user is not on login page");
		}
		
		driver.close();
		System.out.println("Invalid user name validation");

	}

}
