package Full_Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Patient_Hms {
 
public static void main(String[]args) {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.get("https://project1.qualibytes.com/backend/admin/index.php");
	WebElement email_id = driver.findElement(By.id("emailaddress"));
	email_id.sendKeys("admin@mail.com");
	WebElement passw= driver.findElement(By.name("ad_pwd"));
	passw.sendKeys("Password@123");
	
	driver.findElement(By.name("admin_login")).click();
	
	
	driver.findElement(By.xpath("//span[text()= ' Patients ' ]")).click();
	
	System.out.println("Passed Succesfully");
	 
}
}
