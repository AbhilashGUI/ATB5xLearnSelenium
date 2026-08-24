package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP9 {


    WebDriver driver;

    @BeforeTest
    public void openbrowser() {
        driver = new EdgeDriver();
    }


    @Test(groups = "QA")
    @Description("Verify the Katalon testcases")
    public void positivecase() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

      /*<a
      id="btn-make-appointment"
      href="./profile.php#login"
      class="btn btn-dark btn-lg">
      Make Appointment
      </a>
       */

        WebElement clickbutton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        clickbutton.click();

        /*<input
        type="text"
        class="form-control"
        id="txt-username"
        name="username"
        placeholder="Username"
        value="" autocomplete="off">
         */

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");


        /*<input
        type="password"
        class="form-control"
        id="txt-password"
        name="password"
        placeholder="Password"
        value="" autocomplete="off">
         */

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*<button
        id="btn-login"
        type="submit"
        class="btn btn-default">
        Login
        </button>
         */

        WebElement loginbutton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginbutton.click();

    }
    @AfterTest
    public void closebrowser()
    {
        if(driver!=null)
            driver.quit();
    }

}