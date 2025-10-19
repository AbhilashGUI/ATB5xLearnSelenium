package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumP6 {

    @Test(groups="QA")
    @Description("Verify by xpath functions")
    public void Katalonlogin2()
    {
        WebDriver driver= new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");


        //<a id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">
        // Make Appointment</a>
        WebElement fetch_text= driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));
        fetch_text.click();


        //<input type="text"
        // class="form-control"
        // id="txt-username"
        // name="username"
        // placeholder="Username"
        // value="" autocomplete="off">

        WebElement fetch_inputtype= driver.findElement(By.xpath("//input[starts-with(@type,'text')]"));
        fetch_inputtype.sendKeys("John Doe");

        //<input type="password"
        // class="form-control"
        // id="txt-password"
        // name="password"
        // placeholder="Password"
        // value="" autocomplete="off">

        WebElement fetch_inputtype2= driver.findElement(By.xpath("//input[starts-with(@type,'password')]"));
        fetch_inputtype.sendKeys("ThisIsNotAPassword");

        //<button id="btn-login"
        // type="submit"
        // class="btn btn-default">
        // Login
        // </button>

        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.quit();


    }
}
