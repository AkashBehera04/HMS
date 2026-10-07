package Patients;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagePatients_Test {

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

        // 2. Navigate to Manage Patients
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Patients']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Manage Patients')]"))).click();

        // 3. Search "Rahul Kumar JNd" in table
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'form-control')]")));
        searchBox.clear();
        searchBox.sendKeys("Rahul Kumar JNd");
        Thread.sleep(1500);

        // 4. Click Delete Action Button for filtered row
        // Dynamic XPath targeting row containing the specific patient name and its Delete link/icon
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//tr[td[contains(text(),'Rahul Kumar JNd')]]//a[contains(@href,'delete') or contains(@class,'badge-danger') or contains(@class,'btn-danger')]")
        ));
        deleteBtn.click();

        // 5. Handle JS Confirmation Alert if present
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            // Alert handle exception ignored if modal/alert doesn't trigger
        }

        System.out.println("Patient 'Rahul Kumar JNd' Deleted Successfully!");

        Thread.sleep(2000);
        driver.quit();
    }
}