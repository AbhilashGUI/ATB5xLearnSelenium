package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumP6 {


    @Test(groups = "QA")
    @Description("Verify the elements by Xpath functions")
    public void testvwologin() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        /*<a
        id="btn-make-appointment"
        href="./profile.php#login"
        class="btn btn-dark btn-lg">
        Make Appointment
        </a>
         */

        WebElement fetchbycontainfunction=driver.findElement(By.xpath("//a[contains(@id,'btn-make-appointment')]"));
        fetchbycontainfunction.click();

        /*<input
        type="text"
        class="form-control"
        id="txt-username"
        name="username"
        placeholder="Username"
        value=""
        autocomplete="off">
         */

        WebElement fetchbystartswithfunction= driver.findElement(By.xpath("//input[starts-with(@name,'username')]"));
        fetchbystartswithfunction.sendKeys("John Doe");

        /*<input type="password"
        class="form-control"
        id="txt-password"
        name="password"
        placeholder="Password"
        value=""
        autocomplete="off">
         */

        WebElement fetchybytextfunction=driver.findElement(By.xpath("//input[starts-with(@name,'password')]"));
        fetchybytextfunction.sendKeys("ThisIsNotAPassword");

/*<button
id="btn-login"
type="submit"
class="btn btn-default"
>Login
</button>
 */
        WebElement submitbutton= driver.findElement(By.xpath("//button[text()='Login']"));
        Thread.sleep(2000);
        submitbutton.click();
        driver.quit();

    }
}