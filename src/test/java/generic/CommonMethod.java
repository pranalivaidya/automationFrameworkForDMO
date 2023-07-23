package generic;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CommonMethod extends BaseClassImp{
	
	
	public void scrollToViewElement(WebElement element){
		
		JavascriptExecutor jsnew=(JavascriptExecutor) driver;  
		jsnew.executeScript("arguments[0].scrollIntoView({block:\"center\"});", element);
		
	}

}
