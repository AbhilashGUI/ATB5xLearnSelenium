package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg4 {


    @Test(groups = "QA")
    @Description("Verify the input field automation practice")
    public void ClearTheField() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");

        Thread.sleep(3000);

        //<input id="clearInput" data-testid="input-clear" class="input-fields-module__pJ4Qbq__practiceInput" aria-label="Field to clear" type="text" value="Inception">
        WebElement clearfield= driver.findElement(By.id("clearInput"));
        clearfield.clear();



        //<button type="button" id="clearFieldBtn" data-testid="btn-clear-field" class="input-fields-module__pJ4Qbq__actionBtn">Clear</button>
        WebElement clearbutton=driver.findElement(By.id("clearFieldBtn"));
        clearbutton.click();
        driver.quit();
    }


        @Test(groups = "QA")
        @Description("Verify the same in other browser")
        public void clearthefield() throws InterruptedException {
            WebDriver driver=new ChromeDriver();
            driver.get("https://qaplayground.com/practice/input-fields");
            driver.manage().window().maximize();
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");
            Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");


            Thread.sleep(3000);

            //<input id="clearInput" data-testid="input-clear" class="input-fields-module__pJ4Qbq__practiceInput" aria-label="Field to clear" type="text" value="Inception">
            WebElement clearfield= driver.findElement(By.xpath("//input[@id='clearInput']"));
            clearfield.clear();



            //<button type="button" id="clearFieldBtn" data-testid="btn-clear-field" class="input-fields-module__pJ4Qbq__actionBtn">Clear</button>

            WebElement clearbutton=driver.findElement(By.xpath("//button[text()='Clear']"));
            clearbutton.click();

            driver.quit();
        }
}
