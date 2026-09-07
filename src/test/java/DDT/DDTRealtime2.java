package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DDTRealtime2 {


        WebDriver driver;
        @BeforeClass
        public void setup()
        {
            driver= new EdgeDriver();
            driver.manage().window().maximize();
        }


        @Test(dataProvider = "Logincredentials")
        public void testdatadriven(String Email, String Password, String ExpectedResult)
        {
            driver.get("https://app.vwo.com/");
            WebElement emailelement= driver.findElement(By.id("login-username"));
            emailelement.clear();
            emailelement.sendKeys(Email);
            WebElement pwdelement= driver.findElement(By.id("login-password"));
            pwdelement.clear();
            pwdelement.sendKeys(Password);
            driver.findElement(By.id("js-login-btn")).click();


            if(ExpectedResult.equalsIgnoreCase("Valid"))
            {
                String text=driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]")).getText();
                System.out.println(text);
                Assert.assertEquals(text,"Vemula Abhilash");
            }
        }
        /*** @DataProvider(name="Logincredentials")
         public Object[][] testdata() {
         return new Object[][]
         {
         {"vemulaabhilash03@gmail.com", "Test@123", "Invalid"},
         {"vemulaabhilash8433@gmail.com", "VAS1933@hyd", "Valid"},
         };
         }***/

        @DataProvider(name = "Logincredentials")
        public Object[][] testDataExcel() {

            return DDTRealtimereadfromexcel
                    .getTestDataFromSheet("LoginData");
        }
        @AfterClass
        public void teardown()
        {
            driver.quit();
        }

    }



