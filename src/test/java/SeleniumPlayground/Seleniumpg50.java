package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Seleniumpg50 {


    @Test
    @Description("Verify the Multi-select")
    public void SelectMultipleOptions() {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<select multiple="" id="ms-native-select" data-testid="ms-native-select" size="4" class="multi-select-module__ep-fQa__nativeSelect"><option value="playwright">Playwright</option><option value="cypress">Cypress</option><option value="selenium">Selenium</option><option value="webdriverio">WebdriverIO</option></select>

        Select selectmulti= new Select(driver.findElement(By.xpath("//select[@multiple='']")));
        selectmulti.selectByValue("playwright");
        selectmulti.selectByValue("selenium");


        List<WebElement>selectedoptions=selectmulti.getAllSelectedOptions();
        Assert.assertEquals(selectedoptions.get(0).getText(),"Playwright");
        Assert.assertEquals(selectedoptions.get(1).getText(),"Selenium");

    }

    @Test
    @Description("Verify the other elements in different browser")
    public void selectmultipleoptions() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<select multiple="" id="ms-native-select" data-testid="ms-native-select" size="4" class="multi-select-module__ep-fQa__nativeSelect"><option value="playwright">Playwright</option><option value="cypress">Cypress</option><option value="selenium">Selenium</option><option value="webdriverio">WebdriverIO</option></select>

        Select selectrest=new Select(driver.findElement(By.xpath("//select[@multiple='']")));
        selectrest.selectByValue("cypress");
        selectrest.selectByValue("webdriverio");

        List<WebElement> selectedvalues=selectrest.getAllSelectedOptions();
        Assert.assertEquals(selectedvalues.get(0).getText(),"Cypress");
        Assert.assertEquals(selectedvalues.get(1).getText(),"WebdriverIO");

        driver.quit();



    }



}
