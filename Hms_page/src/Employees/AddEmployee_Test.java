package Employees;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee_Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Login
        driver.get("https://project1.qualibytes.com/backend/admin/index.php");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailaddress"))).sendKeys("admin@mail.com");
        driver.findElement(By.name("ad_pwd")).sendKeys("Password@123");
        driver.findElement(By.name("admin_login")).click();

        // 2. Navigate to Employees -> Add Employee
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Employees']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add Employee')]"))).click();

        // 3. Fill Employee Form Details (Aapka Name: Akash Behera)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='doc_fname' or contains(@placeholder,'First Name')]"))).sendKeys("Akash");
        driver.findElement(By.xpath("//input[@name='doc_lname' or contains(@placeholder,'Last Name')]")).sendKeys("Behera");
        
        // Email & Password
        driver.findElement(By.xpath("//input[@type='email' or @name='doc_email']")).sendKeys("akash.behera@test.com");
        driver.findElement(By.xpath("//input[@type='password' or @name='doc_pwd']")).sendKeys("Test@12345");

        // Additional Fields (If present on form)
        try {
            driver.findElement(By.xpath("//input[@name='doc_number' or contains(@placeholder,'Number')]")).sendKeys("EMP" + System.currentTimeMillis() / 1000);
        } catch (Exception e) {}

        // 4. Click Submit / Add Employee Button
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit' or contains(text(),'Add Employee') or @name='add_doc']"));
        submitBtn.click();

        System.out.println("Employee 'Akash Behera' Added Successfully!");
        
        Thread.sleep(2000);
        driver.quit();
    }
}