package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg91 {

    @Test
    @Description("Verify the Tabs and Windows")
    public void CloseATab()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();


        String Mainwindow=driver.getWindowHandle();

        //<a id="tw-close-tab-btn" data-testid="tw-close-tab-btn" href="/practice/tabs-windows" target="_blank" rel="noopener noreferrer" class="inline-flex h-8 items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">↗ Open Tab</a>
        WebElement Opentab=driver.findElement(By.id("tw-close-tab-btn"));
        Opentab.click();

        for (String Secondarywindow:driver.getWindowHandles())
        {
            if (!Secondarywindow.equals(Mainwindow))
            {
                driver.switchTo().window(Secondarywindow);
                break;
            }
        }

        //<button type="button" class="inline-flex items-center justify-center gap-1.5 h-8 rounded-md px-3 text-xs font-medium transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring cursor-pointer border border-input bg-background shadow-sm hover:bg-accent hover:text-accent-foreground">✕ Mark as Closed</button>
        WebElement closebutton=driver.findElement(By.xpath("//button[text()='✕ Mark as Closed']"));
        closebutton.click();
        driver.close();

        driver.switchTo().window(Mainwindow);

        Assert.assertEquals(driver.getWindowHandles().size(),1, "Secondary tab was closed");
        driver.quit();
    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void closeatab()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();

        String Originalwindow=driver.getWindowHandle();

        //<a id="tw-close-tab-btn" data-testid="tw-close-tab-btn" href="/practice/tabs-windows" target="_blank" rel="noopener noreferrer" class="inline-flex h-8 items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">↗ Open Tab</a>
        WebElement opentab=driver.findElement(By.id("tw-close-tab-btn"));
        opentab.click();

        for (String Replicatewindow:driver.getWindowHandles())
        {
            if ((!Replicatewindow.equals(Originalwindow)))
            {
                driver.switchTo().window(Replicatewindow);
                break;
            }

        }

        //<button type="button" class="inline-flex items-center justify-center gap-1.5 h-8 rounded-md px-3 text-xs font-medium transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring cursor-pointer border border-input bg-background shadow-sm hover:bg-accent hover:text-accent-foreground">✕ Mark as Closed</button>
        WebElement closebutton=driver.findElement(By.xpath("//button[text()='✕ Mark as Closed']"));
        closebutton.click();
        driver.close();


        driver.switchTo().window(Originalwindow);
        Assert.assertEquals(driver.getWindowHandles().size(),1,"Replicate window should be closed");
        driver.quit();
    }
}
