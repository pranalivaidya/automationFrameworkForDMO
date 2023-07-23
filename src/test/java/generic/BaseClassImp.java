package generic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassImp{

	public static Properties prop;
	public static WebDriver driver;

	public void loadConfig() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

		// Create object of HashMap Class as shown below.
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Set the notification setting it will override the default setting.
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// Create object of ChromeOption class.
		ChromeOptions Roptions = new ChromeOptions();

		// Set the experimental option.
		Roptions.setExperimentalOption("prefs", prefs);

		loadConfig();

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver(Roptions);
		} else if (browserName.equalsIgnoreCase("FireFox")) {
		} else if (browserName.equalsIgnoreCase("IE")) {
		}
	}

	public void launchApplication(String urlName) {
		// Maximize the screen
		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		// Implicit TimeOuts
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		// PageLoad TimeOuts
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeOut"))));
		if(urlName.equals("Mail Online Videos")) {
		driver.get(prop.getProperty("urlMailOnlineVideos"));
		}else if(urlName.equals("Daily Mail Online")) {
			driver.get(prop.getProperty("urlDailyMailOnline"));
			
		}
	}

	public static void waitFor(int wait) {

		driver.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(wait));

	}

	public static void waitForEC(WebElement element, int time) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public static void waitForElementPresent(By elementPresent,int time) {

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	     WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementPresent));
	}

	public static void waitForDynamicElement(int time, int frequency,WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(time))
				.pollingEvery(Duration.ofSeconds(frequency)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
