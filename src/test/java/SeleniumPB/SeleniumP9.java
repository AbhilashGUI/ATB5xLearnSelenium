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


    //Atomic test cases do not any dependencies and they serve single purpose

    WebDriver driver;
    @BeforeTest
    public void openbrowser()
    {
        driver= new EdgeDriver();

    }

    @Test(groups = "QA")
    @Description("Verify the positive case")
    public void testpositivecase() {
        //driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //<a
        //id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">
        // Make Appointment
        // </a>

        WebElement clickbutton = driver.findElement(By.id("btn-make-appointment"));
        clickbutton.click();

    }

        @Test(dependsOnMethods = "testpositivecase")
        @Description("Verify the negative case")
        public void testnegativecase() {
            //<input type="text"
            // class="form-control"
            // id="txt-username"
            // name="username"
            // placeholder="Username"
            // value="" autocomplete="off">


            WebElement username = driver.findElement(By.id("txt-username"));
            username.sendKeys("John");

            //<input type="password"
            // class="form-control"
            // id="txt-password"
            // name="password"
            // placeholder="Password"
            // value="" autocomplete="off">
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("ThisIsNotAPassword");

            //<button
            // id="btn-login"
            // type="submit"
            // class="btn btn-default">
            // Login
            // </button>
            driver.findElement(By.id("btn-login")).click();
        }
        @AfterTest
        public void closebrowser()
        {
            if(driver!=null)
            driver.quit();
        }


    }




