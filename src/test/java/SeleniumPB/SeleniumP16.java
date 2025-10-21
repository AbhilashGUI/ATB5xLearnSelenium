package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP16 {

    EdgeDriver driver;
    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver=new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Verify the dropdowns")
    public void dropdowncheck() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

        //<select
        // id="oldSelectMenu">
        // <option value="red">Red</option><option value="1">
        // Blue</option><option value="2">
        // Green</option><option value="3">
        // Yellow</option><option value="4">
        // Purple</option><option value="5">
        // Black</option><option value="6">
        // White</option><option value="7">
        // Voilet</option><option value="8">
        // Indigo</option><option value="9">
        // Magenta</option><option value="10">
        // Aqua
        // </option></select>

        WebElement select_dd= driver.findElement(By.id("oldSelectMenu"));
        Select select= new Select(select_dd);
        //select.selectByValue("2");
        select.selectByIndex(2);
        //Both functions picks on the basis of index only
        Thread.sleep(5000);
        driver.quit();


    }
}
