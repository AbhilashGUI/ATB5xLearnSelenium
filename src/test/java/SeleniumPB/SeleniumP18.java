package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class SeleniumP18 {

    EdgeDriver driver;
    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        driver=new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify checkboxes")
    public void checkbox()
    {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
        //<svg
        //stroke="currentColor"
        //fill="currentColor"
        //stroke-width="0"
        //viewBox="0 0 24 24"
        //class="rct-icon rct-icon-uncheck"
        // height="1em"
        // width="1em"
        // xmlns="http://www.w3.org/2000/svg">
        // <path d="M19 5v14H5V5h14m0-2H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2z"></path></svg>

        WebElement checkbox= driver.findElement(By.tagName("svg"));
        checkbox.click();
        driver.quit();
    }
}
