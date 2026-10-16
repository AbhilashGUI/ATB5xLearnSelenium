package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest21 {

    @Test
    @Description("Verify the login and logout flow")
    public void logincheck()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate to  url
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active" name="username" placeholder="Username" autofocus="">
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("Admin");

        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active" type="password" name="password" placeholder="Password">
         WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
         password.sendKeys("admin123");

        //<button data-v-10d463b7="" data-v-0af708be="" type="submit" class="oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"><!----> Login <!----></button>
        WebElement loginbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginbutton.click();
        System.out.println("Logged-In successfully");

        //<h6 data-v-7b563373="" data-v-c286b6e5="" class="oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module">Dashboard</h6>
        String dasboardtext=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']"))).getText();
        System.out.println("Welcome to:"+ dasboardtext);
        Assert.assertEquals(dasboardtext,"Dashboard");

        //<span data-v-bdd6d943="" class="oxd-userdropdown-tab"><img data-v-bdd6d943="" alt="profile picture" class="oxd-userdropdown-img" src="/web/index.php/pim/viewPhoto/empNumber/7"><p data-v-bdd6d943="" class="oxd-userdropdown-name">Ankit Doe</p><i data-v-bddebfba="" data-v-bdd6d943="" class="oxd-icon bi-caret-down-fill oxd-userdropdown-icon"></i></span>
        WebElement logoutdd=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab']")));
        logoutdd.click();

        //<a href="/web/index.php/auth/logout" role="menuitem" class="oxd-userdropdown-link">Logout</a>
        WebElement logoutbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
        logoutbutton.click();

        System.out.println("logged-out successfully");

        driver.quit();

    }

    @Test
    @Description("Verify the invalid credentials")
    public void invalidcheck()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("admin");

        WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.sendKeys("admin");

        WebElement loginbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginbutton.click();

        //<p data-v-7b563373="" data-v-87fcf455="" class="oxd-text oxd-text--p oxd-alert-content-text">Invalid credentials</p>
       String errortext=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Invalid credentials']"))).getText();
       System.out.println(errortext);
       Assert.assertEquals(errortext,"Invalid credentials");
       driver.quit();
    }
}
