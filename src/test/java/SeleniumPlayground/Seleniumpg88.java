package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg88 {


    @Test
    @Description("Verify the Tabs and Windows")
    public void MultipleTab1()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();

        String OriginalWindow=driver.getWindowHandle();

        //<button type="button" id="tw-tab-a" data-testid="tw-tab-a" data-tab-url="/" class="inline-flex h-8 items-center gap-1.5 rounded-md border px-3 text-xs font-medium transition-colors border-input bg-background hover:bg-accent">↗<!-- --> <!-- -->Open Tab A</button>
        WebElement opentabA=driver.findElement(By.id("tw-tab-a"));
        opentabA.click();

        for (String Secondarywindow: driver.getWindowHandles())
        {
            if (!Secondarywindow.equals(OriginalWindow))
            {
                driver.switchTo().window(Secondarywindow);
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("qaplayground"),"Working as expected");

        driver.quit();
    }


    @Test
    @Description("Verify the Similar scenario in other browser")
    public void MultipleTab2()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();

        String Originalwindow=driver.getWindowHandle();

        //<button type="button" id="tw-tab-b" data-testid="tw-tab-b" data-tab-url="/practice" class="inline-flex h-8 items-center gap-1.5 rounded-md border px-3 text-xs font-medium transition-colors border-input bg-background hover:bg-accent">↗<!-- --> <!-- -->Open Tab B</button>
        WebElement opentabB=driver.findElement(By.id("tw-tab-b"));
        opentabB.click();

        for (String Secondarywindow:driver.getWindowHandles())
        {
            if (!Secondarywindow.equals(Originalwindow))
            {
                driver.switchTo().window(Secondarywindow);
            }
        }
        driver.quit();
    }

    @Test
    @Description("Verify the similar scenario in different browser")
    public void MultipleTab3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();

        String Originalwindow=driver.getWindowHandle();

        //<button type="button" id="tw-tab-c" data-testid="tw-tab-c" data-tab-url="/practice/links" class="inline-flex h-8 items-center gap-1.5 rounded-md border px-3 text-xs font-medium transition-colors border-primary/40 bg-primary/5 text-primary">✓<!-- --> <!-- -->Open Tab C</button>
        WebElement tabc=driver.findElement(By.id("tw-tab-c"));
        tabc.click();

        for (String Secondarywindow:driver.getWindowHandles())
        {
            if (!Secondarywindow.equals(Originalwindow))
            {
                driver.switchTo().window(Secondarywindow);
            }
        }
        driver.quit();
    }

}