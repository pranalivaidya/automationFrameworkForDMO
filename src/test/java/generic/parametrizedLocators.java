package generic;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class parametrizedLocators extends BaseClassImp{
	
	public static WebElement pos(String team) {
		
		WebElement element = driver.findElement(By.xpath("//td[text()='"+team+"']//preceding-sibling::td[contains(@class,'pos')]"));
		return element;
		
	}
	
public static WebElement pts(String team) {
		
		WebElement element = driver.findElement(By.xpath("//td[text()='"+team+"']//following-sibling::td[contains(@class,'pts')]"));
		return element;
		
	}

}
