package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg87 {

    @Test
    @Description("Verify the Tabs and Windows")
    public void OpenLinkinNewTab() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();

        String Originalwindow = driver.getWindowHandle();
        //<a id="tw-open-new-tab" data-testid="tw-open-new-tab" href="/practice/tabs-windows" target="_blank" rel="noopener noreferrer" class="inline-flex h-8 items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">🔗 Open in New Tab</a>

        WebElement opentab = driver.findElement(By.id("tw-open-new-tab"));
        opentab.click();


        for (String handle : driver.getWindowHandles())
            if (!handle.equals(Originalwindow)) {
                driver.switchTo().window(handle);
                break;
            }


        Assert.assertTrue(driver.getCurrentUrl().contains("qaplayground"),"Working as intended");
        driver.quit();
    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void openlinkinnewtab()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();


        String Originalwindow= driver.getWindowHandle();

        //<a id="tw-open-new-tab" data-testid="tw-open-new-tab" href="/practice/tabs-windows" target="_blank" rel="noopener noreferrer" class="inline-flex h-8 items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">🔗 Open in New Tab</a>
        WebElement newtab=driver.findElement(By.id("tw-open-new-tab"));
        newtab.click();

        for (String Secondarywindow:driver.getWindowHandles()) {
            if (!Secondarywindow.equals(Originalwindow)) {
                driver.switchTo().window(Secondarywindow);
            }
        }

         Assert.assertTrue(driver.getCurrentUrl().contains("practice"),"Working as expected");
         driver.quit();


    }


}