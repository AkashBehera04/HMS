package Full_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Hms_Login {
 
public static void main(String[]args) {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.get("https://project1.qualibytes.com/backend/admin/index.php");
	driver.findElement(By.id("emailaddress")).sendKeys("admin@mail.com");
	driver.findElement(By.name("ad_pwd")).sendKeys("Password@123");
	
	driver.findElement(By.name("admin_login")).click();
	
	driver.quit();
	System.out.println("Passed Succesfully");
	
//	driver.wait(200000);
	
	
}
}
