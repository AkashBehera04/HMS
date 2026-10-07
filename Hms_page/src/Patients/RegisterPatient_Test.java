package Patients;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPatient_Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Open URL & Login
        driver.get("https://project1.qualibytes.com/backend/admin/index.php");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailaddress"))).sendKeys("admin@mail.com");
        driver.findElement(By.name("ad_pwd")).sendKeys("Password@123");
        driver.findElement(By.name("admin_login")).click();

        // 2. Navigate to Register Patient
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Patients']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Register Patient')]"))).click();

        // 3. Fill All Form Fields
        
        // First Name & Last Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pat_fname"))).sendKeys("John");
        driver.findElement(By.name("pat_lname")).sendKeys("Doe");

        // Date of Birth & Age
        driver.findElement(By.name("pat_dob")).sendKeys("01/01/1995");
        driver.findElement(By.name("pat_age")).sendKeys("29");

        // Address
        driver.findElement(By.name("pat_addr")).sendKeys("123 Main Street, City");

        // Mobile Number & Ailment
        driver.findElement(By.name("pat_phone")).sendKeys("9876543210");
        driver.findElement(By.name("pat_ailment")).sendKeys("Fever and Cold");

        // Select Patient's Type Dropdown
        WebElement dropdown = driver.findElement(By.name("pat_type"));
        Select selectType = new Select(dropdown);
        selectType.selectByVisibleText("InPatient");

        Thread.sleep(1000);

        // 4. Click Add Patient Button
        driver.findElement(By.name("add_patient")).click();

        System.out.println("Patient Registered Successfully!");

        Thread.sleep(2000);
        driver.quit();
    }
}