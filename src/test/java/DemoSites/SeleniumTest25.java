
package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest25 {

    @Test
    @Description("Verify the add employee")
    public void Addemployee() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1. Login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username"))).sendKeys("Admin");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("password"))).sendKeys("admin123");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']"))).click();

        // 2. Open PIM
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")))
                .click();

        // 3. Click Add Employee
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']"))).click();

        // 4. Enter employee details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))).sendKeys("Test");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName"))).sendKeys("Test");

        // 5. Extract generated Employee ID
        By employeeIdLocator = By.xpath("//label[normalize-space()='Employee Id']" +
                "/ancestor::div[contains(@class,'oxd-input-group')]//input");

        WebElement employeeIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdLocator));


        String employeeId = employeeIdField.getAttribute("value");
        System.out.println("Employee added successfully");
        System.out.println("Generated Employee ID: " + employeeId);

        // 6. Save employee
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
        driver.quit();

    }


    @Test
    @Description("Verify the edit employee")
    public void editemployee()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        // 1. Login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username"))).sendKeys("Admin");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("password"))).sendKeys("admin123");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']"))).click();

        // 2. Open PIM
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")))
                .click();

        //Employeeid search
        WebElement employeeId =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//input[contains(@class,'oxd-input')][1]")));
        employeeId.sendKeys("0448");


        //<button data-v-10d463b7="" data-v-7044e35a="" type="submit" class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space"><!----> Search <!----></button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']"))).click();

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();



        //<i data-v-bddebfba="" data-v-f5c763eb="" class="oxd-icon bi-pencil-fill"></i>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-pencil-fill']"))).click();

        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active orangehrm-middlename" name="middleName" placeholder="Middle Name">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("middleName"))).clear();

        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active orangehrm-lastname" name="lastName" placeholder="Last Name">
        WebElement lastname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
        lastname.clear();
        lastname.sendKeys("sharma");

        //<button data-v-10d463b7="" data-v-6653c066="" type="submit" class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space"><!----> Save <!----></button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']"))).click();
        System.out.println("Edited successfully");
        driver.quit();


    }

    @Test
    @Description("Verify the add employee")
    public void Deleteemployee() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1. Login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username"))).sendKeys("Admin");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("password"))).sendKeys("admin123");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']"))).click();

        // 2. Open PIM
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")))
                .click();

        //Employeeid search
        WebElement employeeId =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//input[contains(@class,'oxd-input')][1]")));
        employeeId.sendKeys("0360");

       //<button data-v-10d463b7="" data-v-7044e35a="" type="submit" class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space"><!----> Search <!----></button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']"))).click();

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //<i data-v-bddebfba="" data-v-f5c763eb="" class="oxd-icon bi-trash"></i>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-trash']"))).click();

        //<button data-v-10d463b7="" data-v-8f9701a2="" type="button" class="oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin"><i data-v-bddebfba="" data-v-10d463b7="" class="oxd-icon bi-trash oxd-button-icon"></i> Yes, Delete <!----></button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes, Delete']"))).click();
        System.out.println("Deleted successfully");
        driver.quit();










    }
}