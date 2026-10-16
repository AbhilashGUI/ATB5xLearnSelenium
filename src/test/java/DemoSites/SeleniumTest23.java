package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest23 {

    @Test
    @Description("Verify the Menu bar drop downs")
    public void About()
    {
        WebDriver driver=new FirefoxDriver();
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

        WebElement logoutdd=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab']")));
        logoutdd.click();


        //<a href="#" role="menuitem" class="oxd-userdropdown-link">About</a>
        WebElement Aboutclick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@role='menuitem']")));
        Aboutclick.click();

        //<div data-v-8a31f039="" data-v-126e9e0f="" class="oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters" role="document" style="width: 90%; max-width: 450px;"><button data-v-a11b6690="" data-v-126e9e0f="" class="oxd-dialog-close-button oxd-dialog-close-button-position">×</button><div data-v-d52720b8="" class="orangehrm-modal-header"><h6 data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--h6 orangehrm-main-title">About</h6></div><hr data-v-9f847659="" data-v-d52720b8="" class="oxd-divider" role="separator" aria-orientation="horizontal"><div data-v-d7b71de4="" data-v-d52720b8="" class="oxd-grid-2 orangehrm-about"><div data-v-c93bdbf3="" data-v-d52720b8="" class="oxd-grid-item oxd-grid-item--gutters"><p data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--p orangehrm-about-title">Company Name: </p></div><div data-v-c93bdbf3="" data-v-d52720b8="" class="oxd-grid-item oxd-grid-item--gutters"><p data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--p orangehrm-about-text">OrangeHRM</p></div><div data-v-c93bdbf3="" data-v-d52720b8="" class="oxd-grid-item oxd-grid-item--gutters"><p data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--p orangehrm-about-title">Version: </p></div><div data-v-c93bdbf3="" data-v-d52720b8="" class="oxd-grid-item oxd-grid-item--gutters"><p data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--p orangehrm-about-text">OrangeHRM OS 5.9</p></div><div data-v-c93bdbf3="" data-v-d52720b8="" class="oxd-grid-item oxd-grid-item--gutters"><p data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--p orangehrm-about-title">Active Employees: </p></div><div data-v-c93bdbf3="" data-v-d52720b8="" class="oxd-grid-item oxd-grid-item--gutters"><p data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--p orangehrm-about-text">275</p></div><div data-v-c93bdbf3="" data-v-d52720b8="" class="oxd-grid-item oxd-grid-item--gutters"><p data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--p orangehrm-about-title">Employees Terminated: </p></div><div data-v-c93bdbf3="" data-v-d52720b8="" class="oxd-grid-item oxd-grid-item--gutters"><p data-v-7b563373="" data-v-d52720b8="" class="oxd-text oxd-text--p orangehrm-about-text">1</p></div></div></div>
         String Aboutinfo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='document' and contains(@class,'oxd-dialog-sheet')]"))).getText();
         System.out.println(Aboutinfo);


         //<button data-v-a11b6690="" data-v-126e9e0f="" class="oxd-dialog-close-button oxd-dialog-close-button-position">×</button>
        WebElement closetag=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']")));
        closetag.click();

        System.out.println("About menu is closed successfully");

        driver.quit();

    }

    @Test
    @Description("Verify the Menu bar dropdown")
    public void Support() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate to  url
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

        WebElement logoutdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab']")));
        logoutdd.click();

        //<a href="/web/index.php/help/support" role="menuitem" class="oxd-userdropdown-link">Support</a>

        WebElement support=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/help/support'] ")));
        support.click();
        System.out.println("Navigated to support page ");

        //<a data-v-21cf064a="" class="orangehrm-support-link" href="mailto:ossupport@orangehrm.com"> ossupport@orangehrm.com </a>

        WebElement supportpage=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='mailto:ossupport@orangehrm.com']")));
        supportpage.click();
        System.out.println("Able to click on provided link");


        driver.quit();
    }


@Test
@Description("Verify the password update")
public void updatepassword() {
    WebDriver driver = new EdgeDriver();
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //Navigate to  url
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

    WebElement logoutdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-userdropdown-tab']")));
    logoutdd.click();

    //<a href="/web/index.php/pim/updatePassword" role="menuitem" class="oxd-userdropdown-link">Change Password</a>
    WebElement changepwd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/pim/updatePassword']")));
    changepwd.click();


    //<input data-v-1f99f73c="" class="oxd-input oxd-input--active oxd-input--error" type="password">
    WebElement currentpwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='password' and contains(@class,'oxd-input')])[1]")));
    currentpwd.sendKeys("admin123");

    //<input data-v-1f99f73c="" class="oxd-input oxd-input--active oxd-input--error" type="password" autocomplete="off">
    WebElement password1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='password' and contains(@class,'oxd-input')])[2]")));
    password1.sendKeys("check123");

    //<input data-v-1f99f73c="" class="oxd-input oxd-input--active oxd-input--error" type="password" autocomplete="off">
    WebElement confirmpwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='password' and contains(@class,'oxd-input')])[3]")));
    confirmpwd.sendKeys("check123");

    //<button data-v-10d463b7="" data-v-257f4baa="" type="submit" class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space"><!----> Save <!----></button>
    WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']")));
    savebutton.click();

    System.out.println("Password saved successfully");

    driver.quit();
     }

    }
