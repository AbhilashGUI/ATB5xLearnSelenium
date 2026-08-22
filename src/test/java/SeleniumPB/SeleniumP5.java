package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumP5 {


    @Test(groups = "QA")
    @Description("Verify the elements by Xpath")
    public void katalonlogin() throws InterruptedException {

        WebDriver driver= new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        /*<a
        id="btn-make-appointment"
        href="./profile.php#login"
        class="btn btn-dark btn-lg">
        Make Appointment
        </a>
         */

        //WebElement fetchbyid=driver.findElement(By.id("btn-make-appointment"));
        //WebElement fetchbyclass=driver.findElement(By.className("btn btn-dark btn-lg"));
        //WebElement fetchbytext1=driver.findElement(By.linkText("Make Appointment"));
        //WebElement fetchbytext2= driver.findElement(By.partialLinkText("Make"));
        //WebElement fetchbytagname=driver.findElement(By.tagName("a"));
        WebElement fetchbyxpath=driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
        fetchbyxpath.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");


        /*<input
        type="text"
        class="form-control"
        id="txt-username"
        name="username"
        placeholder="Username"
        value="" autocomplete="off">
         */

        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("John Doe");

        /*<input
        type="password"
        class="form-control"
        id="txt-password"
        name="password"
        placeholder="Password"
        value=""
        autocomplete="off">
         */
        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("ThisIsNotAPassword");

        /*<button
        id="btn-login"
        type="submit"
        class="btn btn-default">
        Login
        </button>
         */

        WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-default']"));

        Thread.sleep(3000);
        button.click();
        driver.quit();
    }
}

