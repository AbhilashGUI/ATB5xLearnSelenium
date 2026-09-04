package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumP34 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(edgeOptions);
    }

    @Test(groups = "QA")
    @Description("Verify the test")
    public void testcheck() throws InterruptedException {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //<input class="input-field xs:max-sm:text-[clamp(16px,1rem,1.6rem)] text-title dark:text-dark_title outline-none focus:outline-none disabled:opacity-50 disabled:pointer-events-none w-full focus-within:!border-primary [&amp;.invalid]:!border-error rounded-[0.5em] border border-[#E8ECF4] dark:border-[#A3A3C8]/40 placeholder:text-[#9CA5AD] dark:placeholder:text-white/50 p-0 bg-transparent dark:bg-transparent placeholder-shown:truncate !py-0 !border-0 focus-within:shadow-none focus-within:border-0 h-[unset] text-[1.6em]" placeholder="Search" type="search">
        WebElement searchbox=driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        searchbox.sendKeys("India "+ Keys.ENTER);

        }
        @AfterTest
       public void closebrowser()
        {
            driver.quit();
        }
    }


