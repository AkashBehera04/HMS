package Full_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Employees_Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://project1.qualibytes.com/backend/admin/index.php");

        // Login
        driver.findElement(By.id("emailaddress")).sendKeys("admin@mail.com");
        driver.findElement(By.name("ad_pwd")).sendKeys("Password@123");
        driver.findElement(By.name("admin_login")).click();
        Thread.sleep(2000);

        // Click Main Employees Menu
        driver.findElement(By.xpath("//span[normalize-space()='Employees']")).click();
        Thread.sleep(1000);

        // Sub-menu: Add Employee / View Employees
        driver.findElement(By.xpath("//a[contains(text(),'Add Employee')]")).click();
        Thread.sleep(1500);

        System.out.println("Employees Module Tested Successfully");
        driver.quit();
    }
}