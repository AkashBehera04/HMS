package Full_Test;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Basic {
 
public static void main(String[]args) {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.get("https://www.myntra.com/login/password");
//	driver.wait(200000);
	
	
}
}
