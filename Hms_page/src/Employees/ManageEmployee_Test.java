package Employees;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageEmployee_Test {

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

        // 2. Navigate to Employees -> Manage Employees
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Employees']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Manage Employees')]"))).click();

        // 3. Search "Akash" in Manage Table
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'form-control')]")));
        searchBox.clear();
        searchBox.sendKeys("Akash");
        Thread.sleep(1500);

        // 4. Action Button Test (Click View or Edit for the searched row)
        WebElement actionBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//tr[td[contains(text(),'Akash')]]//a)[1] | (//table//tbody//tr[1]//a)[1]")
        ));
        actionBtn.click();
        Thread.sleep(2000);

        System.out.println("Manage Employees Page Tested Successfully!");
        driver.quit();
    }
}