package Patients;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewPatients_Test {

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

        // 2. Navigate to View Patients
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Patients']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'View Patients')]"))).click();

        // 3. Search Data inside Table
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'form-control')]")));
        searchBox.clear();
        searchBox.sendKeys("Rahul");
        Thread.sleep(2000);

        System.out.println("View Patients Page Tested Successfully!");
        driver.quit();
    }
}