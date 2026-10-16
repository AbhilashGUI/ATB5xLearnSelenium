package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest24 {

    @Test
    @Description("Verify the modules")
    public void module1()
    {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

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


        //<a data-v-6475d26d="" class="oxd-main-menu-item" href="/web/index.php/admin/viewAdminModule"><svg data-v-bddebfba="" data-v-6475d26d="" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 500 500" role="presentation" class="oxd-icon oxd-main-menu-item--icon"><g fill="currentColor"><path data-v-bddebfba="" d="M 480.469 500 C 469.682 500 460.938 491.256 460.938 480.469 C 460.938 441.698 429.604 410.156 391.089 410.156 L 374.537 410.156 C 336.022 410.156 304.688 441.698 304.688 480.469 C 304.688 491.256 295.943 500 285.156 500 C 274.369 500 265.625 491.256 265.625 480.469 C 265.625 420.159 314.482 371.094 374.536 371.094 L 391.088 371.094 C 451.143 371.094 500 420.159 500 480.469 C 500 491.256 491.256 500 480.469 500 Z M 464.844 258.789 C 464.844 213.019 427.606 175.781 381.836 175.781 C 336.065 175.781 298.828 213.019 298.828 258.789 C 298.828 304.56 336.065 341.797 381.836 341.797 C 427.606 341.797 464.844 304.56 464.844 258.789 Z M 425.781 258.789 C 425.781 283.021 406.067 302.734 381.836 302.734 C 357.605 302.734 337.891 283.021 337.891 258.789 C 337.891 234.558 357.605 214.844 381.836 214.844 C 406.067 214.844 425.781 234.558 425.781 258.789 Z M 226.563 480.469 C 226.563 469.682 217.818 460.938 207.031 460.938 L 117.167 460.938 C 74.101 460.938 39.063 425.899 39.063 382.833 L 39.063 117.167 C 39.063 74.101 74.101 39.063 117.167 39.063 L 296.915 39.063 C 339.982 39.063 375.02 74.101 375.02 117.167 C 375.02 127.954 383.764 136.698 394.551 136.698 C 405.338 136.698 414.082 127.954 414.082 117.167 C 414.083 52.562 361.522 0 296.896 0 L 117.167 0 C 52.562 0 0 52.562 0 117.167 L 0 382.832 C 0 447.439 52.562 500 117.167 500 L 207.031 500 C 217.818 500 226.563 491.256 226.563 480.469 Z M 122.07 98.633 C 108.587 98.633 97.656 109.563 97.656 123.047 C 97.656 136.53 108.587 147.461 122.07 147.461 C 135.554 147.461 146.484 136.53 146.484 123.047 C 146.484 109.563 135.554 98.633 122.07 98.633 Z M 206.055 98.633 C 192.571 98.633 181.641 109.563 181.641 123.047 C 181.641 136.53 192.571 147.461 206.055 147.461 C 219.538 147.461 230.469 136.53 230.469 123.047 C 230.469 109.563 219.538 98.633 206.055 98.633 Z M 290.039 98.633 C 276.556 98.633 265.625 109.563 265.625 123.047 C 265.625 136.53 276.556 147.461 290.039 147.461 C 303.522 147.461 314.453 136.53 314.453 123.047 C 314.453 109.563 303.522 98.633 290.039 98.633 Z M 122.07 182.617 C 108.587 182.617 97.656 193.548 97.656 207.031 C 97.656 220.515 108.587 231.445 122.07 231.445 C 135.554 231.445 146.484 220.515 146.484 207.031 C 146.484 193.548 135.554 182.617 122.07 182.617 Z M 122.07 266.602 C 108.587 266.602 97.656 277.532 97.656 291.016 C 97.656 304.499 108.587 315.43 122.07 315.43 C 135.554 315.43 146.484 304.499 146.484 291.016 C 146.484 277.532 135.554 266.602 122.07 266.602 Z M 122.07 350.586 C 108.587 350.586 97.656 361.517 97.656 375 C 97.656 388.483 108.587 399.414 122.07 399.414 C 135.554 399.414 146.484 388.483 146.484 375 C 146.484 361.517 135.554 350.586 122.07 350.586 Z M 206.055 182.617 C 192.571 182.617 181.641 193.548 181.641 207.031 C 181.641 220.515 192.571 231.445 206.055 231.445 C 219.538 231.445 230.469 220.515 230.469 207.031 C 230.469 193.548 219.538 182.617 206.055 182.617 Z M 206.055 266.602 C 192.571 266.602 181.641 277.532 181.641 291.016 C 181.641 304.499 192.571 315.43 206.055 315.43 C 219.538 315.43 230.469 304.499 230.469 291.016 C 230.469 277.532 219.538 266.602 206.055 266.602 Z M 206.055 350.586 C 192.571 350.586 181.641 361.517 181.641 375 C 181.641 388.483 192.571 399.414 206.055 399.414 C 219.538 399.414 230.469 388.483 230.469 375 C 230.469 361.517 219.538 350.586 206.055 350.586 Z"></path></g></svg><span data-v-7b563373="" data-v-6475d26d="" class="oxd-text oxd-text--span oxd-main-menu-item--name">Admin</span></a>

        WebElement adminbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")));
        adminbutton.click();

        //<input data-v-1f99f73c="" class="oxd-input oxd-input--active">
        WebElement username2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-v-1f99f73c='']")));
        username2.sendKeys("Admin");


        //<button data-v-10d463b7="" type="submit" class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space"><!----> Search <!----></button>
        WebElement searchbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space='Search']")));
        searchbutton.click();






    }
}
