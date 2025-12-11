package Login;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToView {

	public void view(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", element);
		js.executeScript("window.scrollBy(0, -100);"); // adjust for sticky headers
	}

}
