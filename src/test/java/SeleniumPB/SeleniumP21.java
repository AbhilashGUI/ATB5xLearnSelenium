package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumP21 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
    }

//<input class="nw1UBF v1zwn26" title="Search for Products, Brands and More" autocomplete="off" placeholder="Search for Products, Brands and More" readonly="" type="text" value="" name="q" style="color: rgb(61, 61, 61);">
    @Test(groups = "QA")
    @Description("Verify the SVG elements")
    public void svgcheck() {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();


        driver.findElement(By.name("q")).sendKeys("macmini");

//<svg width="24" height="24" class="" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg"><title>Search Icon</title><path d="M10.5 18C14.6421 18 18 14.6421 18 10.5C18 6.35786 14.6421 3 10.5 3C6.35786 3 3 6.35786 3 10.5C3 14.6421 6.35786 18 10.5 18Z" stroke="#717478" stroke-width="1.4" stroke-linecap="round" stroke-linejoin="round"></path><path d="M16 16L21 21" stroke="#717478" stroke-width="1.4" stroke-linecap="round" stroke-linejoin="round"></path></svg>
        List<WebElement> svgelements=driver.findElements(By.xpath("//*[local-name()='svg']"));
        System.out.println(svgelements.size());
    }
}