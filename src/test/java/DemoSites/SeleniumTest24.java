package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest24 {

    @Test
    @Description("Verify the Dashboard checks")
    public void dashboardcheck1()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        //login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active" name="username" placeholder="Username" autofocus="">
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("Admin");

        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active" type="password" name="password" placeholder="Password">
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.sendKeys("admin123");

        //<button data-v-10d463b7="" data-v-0af708be="" type="submit" class="oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"><!----> Login <!----></button>
        WebElement loginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginbutton.click();
        System.out.println("Logged-In successfully");

        //<p data-v-7b563373="" data-v-93929af6="" class="oxd-text oxd-text--p">(1) Leave Request to Approve</p>
        WebElement leaverequestcheck=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='(1) Leave Request to Approve']")));
        leaverequestcheck.click();

        //<button data-v-10d463b7="" data-v-c423d1fa="" type="button" class="oxd-button oxd-button--medium oxd-button--label-success oxd-table-cell-action-space"><!----> Approve <!----></button>
        WebElement approvebutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Approve']")));
        approvebutton.click();

        System.out.println("Rejected successfully");

        driver.quit();


    }

    @Test
    @Description("Verify the Dashboard checks")
    public void dashboardcheck2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active" name="username" placeholder="Username" autofocus="">
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("Admin");

        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active" type="password" name="password" placeholder="Password">
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.sendKeys("admin123");

        //<button data-v-10d463b7="" data-v-0af708be="" type="submit" class="oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"><!----> Login <!----></button>
        WebElement loginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginbutton.click();
        System.out.println("Logged-In successfully");


//<p data-v-7b563373="" data-v-93929af6="" class="oxd-text oxd-text--p">(1) Pending Self Review</p>
        WebElement selfreview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='(1) Pending Self Review']")));
        selfreview.click();

//<i data-v-bddebfba="" data-v-f5c763eb="" class="oxd-icon bi-file-text-fill"></i>
        WebElement Actions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-file-text-fill']")));
        Actions.click();


        //<button data-v-10d463b7="" data-v-227da4da="" type="button" class="oxd-button oxd-button--medium oxd-button--secondary"><!----> Complete <!----></button>
        WebElement completebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Complete']")));
        completebutton.click();


        //<button data-v-10d463b7="" data-v-a84a2054="" type="button" class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin"><!----> Ok <!----></button>
         WebElement okbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Ok']")));
         okbutton.click();

         driver.quit();

    }


}