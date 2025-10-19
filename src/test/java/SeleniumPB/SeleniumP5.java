package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumP5
{

    @Test(groups ="QA")
    @Description("Verify by the xpath")
    public void katalonlogin() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");


        //<a
        //id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">
        // Make Appointment
        // </a>


       WebElement fetch_ID= driver.findElement(By.id("btn-make-appointment"));
       // WebElement fetch_CN=driver.findElement(By.className("btn.btn-dark btn-lg"));
       // WebElement fetch_LT=driver.findElement(By.linkText("Make Appointment"));
        //WebElement fetch_PT=driver.findElement(By.partialLinkText("Make"));
       // WebElement fetch_AT=driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
       // WebElement fetch_TN=driver.findElement(By.tagName("a")); //Not recommended since there are multiple


        fetch_ID.click();
        //fetch_PT.click();
        Thread.sleep(200);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");


        //<input type="text"
        // class="form-control"
        // id="txt-username"
        // name="username"
        // placeholder="Username"
        // value="" autocomplete="off">

        WebElement fetch_username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        fetch_username.sendKeys("John Doe");


        //<input type="password"
        // class="form-control"
        // id="txt-password"
        // name="password"
        // placeholder="Password"
        // value="" autocomplete="off">


        WebElement fetch_password= driver.findElement(By.xpath("//input[@id=txt-password]"));
        fetch_password.sendKeys("ThisIsNotAPassword");

        //<button
        // id="btn-login"
        //type="submit"
        // class="btn btn-default">
        // Login
        // </button>

        driver.findElement(By.id("btn-login")).click();
    }


}
