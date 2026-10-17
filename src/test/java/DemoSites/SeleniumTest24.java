package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest24 {

    @Test
    @Description("Verify the PIM Module")
    public void employeesearch() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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


        //<a data-v-6475d26d="" class="oxd-main-menu-item" href="/web/index.php/pim/viewPimModule"><svg data-v-bddebfba="" data-v-6475d26d="" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 500 500" role="presentation" class="oxd-icon oxd-main-menu-item--icon"><g fill="currentColor"><g transform="matrix(0.976563, 0, 0, 0.976563, -0.000137, -2.647596)"><g><path d="M437,268.152h-50.118c-6.821,0-13.425,0.932-19.71,2.646c-12.398-24.372-37.71-41.118-66.877-41.118h-88.59 c-29.167,0-54.479,16.746-66.877,41.118c-6.285-1.714-12.889-2.646-19.71-2.646H75c-41.355,0-75,33.645-75,75v80.118 c0,24.813,20.187,45,45,45h422c24.813,0,45-20.187,45-45v-80.118C512,301.797,478.355,268.152,437,268.152z M136.705,304.682 v133.589H45c-8.271,0-15-6.729-15-15v-80.118c0-24.813,20.187-45,45-45h50.118c4.072,0,8.015,0.553,11.769,1.572 C136.779,301.366,136.705,303.016,136.705,304.682z M345.295,438.271h-178.59V304.681c0-24.813,20.187-45,45-45h88.59 c24.813,0,45,20.187,45,45V438.271z M482,423.271c0,8.271-6.729,15-15,15h-91.705v-133.59c0-1.667-0.074-3.317-0.182-4.957 c3.754-1.018,7.697-1.572,11.769-1.572H437c24.813,0,45,20.187,45,45V423.271z"></path></g></g><g transform="matrix(0.976563, 0, 0, 0.976563, -0.000137, -2.647596)"><g><path d="M100.06,126.504c-36.749,0-66.646,29.897-66.646,66.646c-0.001,36.749,29.897,66.646,66.646,66.646 c36.748,0,66.646-29.897,66.646-66.646C166.706,156.401,136.809,126.504,100.06,126.504z M100.059,229.796 c-20.207,0-36.646-16.439-36.646-36.646c0-20.207,16.439-36.646,36.646-36.646c20.207,0,36.646,16.439,36.646,36.646 C136.705,213.357,120.266,229.796,100.059,229.796z"></path></g></g><g transform="matrix(0.976563, 0, 0, 0.976563, -0.000137, -2.647596)"><g><path d="M256,43.729c-49.096,0-89.038,39.942-89.038,89.038c0,49.096,39.942,89.038,89.038,89.038s89.038-39.942,89.038-89.038 C345.038,83.672,305.096,43.729,256,43.729z M256,191.805c-32.554,0-59.038-26.484-59.038-59.038 c0-32.553,26.484-59.038,59.038-59.038s59.038,26.484,59.038,59.038C315.038,165.321,288.554,191.805,256,191.805z"></path></g></g><g transform="matrix(0.976563, 0, 0, 0.976563, -0.000137, -2.647596)"><g><path d="M411.94,126.504c-36.748,0-66.646,29.897-66.646,66.646c0.001,36.749,29.898,66.646,66.646,66.646 c36.749,0,66.646-29.897,66.646-66.646C478.586,156.401,448.689,126.504,411.94,126.504z M411.94,229.796 c-20.206,0-36.646-16.439-36.646-36.646c0.001-20.207,16.44-36.646,36.646-36.646c20.207,0,36.646,16.439,36.646,36.646 C448.586,213.357,432.147,229.796,411.94,229.796z"></path></g></g></g></svg><span data-v-7b563373="" data-v-6475d26d="" class="oxd-text oxd-text--span oxd-main-menu-item--name">PIM</span></a>

        WebElement PIMMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")));
        PIMMenu.click();


        //<input data-v-75e744cd="" placeholder="Type for hints...">

        WebElement employeename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")));
        employeename.sendKeys("Admin");

        //<button data-v-10d463b7="" data-v-7044e35a="" type="submit" class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space"><!----> Search <!----></button>

        WebElement searchbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
        searchbutton.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.quit();
    }

    @Test
    @Description("Verify the PIM Module")
    public void employeerecordsfetch() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        //<a data-v-6475d26d="" class="oxd-main-menu-item" href="/web/index.php/pim/viewPimModule"><svg data-v-bddebfba="" data-v-6475d26d="" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 500 500" role="presentation" class="oxd-icon oxd-main-menu-item--icon"><g fill="currentColor"><g transform="matrix(0.976563, 0, 0, 0.976563, -0.000137, -2.647596)"><g><path d="M437,268.152h-50.118c-6.821,0-13.425,0.932-19.71,2.646c-12.398-24.372-37.71-41.118-66.877-41.118h-88.59 c-29.167,0-54.479,16.746-66.877,41.118c-6.285-1.714-12.889-2.646-19.71-2.646H75c-41.355,0-75,33.645-75,75v80.118 c0,24.813,20.187,45,45,45h422c24.813,0,45-20.187,45-45v-80.118C512,301.797,478.355,268.152,437,268.152z M136.705,304.682 v133.589H45c-8.271,0-15-6.729-15-15v-80.118c0-24.813,20.187-45,45-45h50.118c4.072,0,8.015,0.553,11.769,1.572 C136.779,301.366,136.705,303.016,136.705,304.682z M345.295,438.271h-178.59V304.681c0-24.813,20.187-45,45-45h88.59 c24.813,0,45,20.187,45,45V438.271z M482,423.271c0,8.271-6.729,15-15,15h-91.705v-133.59c0-1.667-0.074-3.317-0.182-4.957 c3.754-1.018,7.697-1.572,11.769-1.572H437c24.813,0,45,20.187,45,45V423.271z"></path></g></g><g transform="matrix(0.976563, 0, 0, 0.976563, -0.000137, -2.647596)"><g><path d="M100.06,126.504c-36.749,0-66.646,29.897-66.646,66.646c-0.001,36.749,29.897,66.646,66.646,66.646 c36.748,0,66.646-29.897,66.646-66.646C166.706,156.401,136.809,126.504,100.06,126.504z M100.059,229.796 c-20.207,0-36.646-16.439-36.646-36.646c0-20.207,16.439-36.646,36.646-36.646c20.207,0,36.646,16.439,36.646,36.646 C136.705,213.357,120.266,229.796,100.059,229.796z"></path></g></g><g transform="matrix(0.976563, 0, 0, 0.976563, -0.000137, -2.647596)"><g><path d="M256,43.729c-49.096,0-89.038,39.942-89.038,89.038c0,49.096,39.942,89.038,89.038,89.038s89.038-39.942,89.038-89.038 C345.038,83.672,305.096,43.729,256,43.729z M256,191.805c-32.554,0-59.038-26.484-59.038-59.038 c0-32.553,26.484-59.038,59.038-59.038s59.038,26.484,59.038,59.038C315.038,165.321,288.554,191.805,256,191.805z"></path></g></g><g transform="matrix(0.976563, 0, 0, 0.976563, -0.000137, -2.647596)"><g><path d="M411.94,126.504c-36.748,0-66.646,29.897-66.646,66.646c0.001,36.749,29.898,66.646,66.646,66.646 c36.749,0,66.646-29.897,66.646-66.646C478.586,156.401,448.689,126.504,411.94,126.504z M411.94,229.796 c-20.206,0-36.646-16.439-36.646-36.646c0.001-20.207,16.44-36.646,36.646-36.646c20.207,0,36.646,16.439,36.646,36.646 C448.586,213.357,432.147,229.796,411.94,229.796z"></path></g></g></g></svg><span data-v-7b563373="" data-v-6475d26d="" class="oxd-text oxd-text--span oxd-main-menu-item--name">PIM</span></a>

        WebElement PIMMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")));
        PIMMenu.click();


        //<span data-v-7b563373="" data-v-5a621acd="" class="oxd-text oxd-text--span"> (173) Records Found</span>

        WebElement  recordscount=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span']")));


        driver.quit();



    }
}


