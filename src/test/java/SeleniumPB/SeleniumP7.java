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
    public void flipkartlogin() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        /*<span
        class="v1zwn27"
        style="color:#333333ff">
        Login
        </span>
         */

        WebElement logincheck = driver.findElement(By.xpath("//span[text()='Login']"));
        System.out.println(logincheck.getText());
        driver.quit();


    }
}