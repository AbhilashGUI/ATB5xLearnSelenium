package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumP7 {


    @Test(groups = "QA")
    @Description("Verify the flipkart login page")
    public void flipkartloginpage()
    {

        WebDriver driver= new EdgeDriver();
        driver.get("https://www.flipkart.com/");

        //<a
        // class="wsejfv"
        // href="/account/login?ret=/account/login%3Fret%3D%2F">
        // Login
        // </a>
        WebElement login=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
        login.click();




    }
}
