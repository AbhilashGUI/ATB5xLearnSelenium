package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg92 {

    @Test
    @Description("Verify the Tabs and Windows")
    public void WindowPopup()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();

        String Originalwindow=driver.getWindowHandle();
        //<button type="button" id="tw-popup-btn" data-testid="tw-popup-btn" data-popup-url="/practice/tabs-windows" class="inline-flex h-8 w-fit items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">🪟 Open Popup Window</button>
        WebElement popupbutton=driver.findElement(By.xpath("//button[@data-testid='tw-popup-btn']"));
        popupbutton.click();

        for (String Secondarywindow:driver.getWindowHandles())
        {
            if (!Secondarywindow.equals(Originalwindow))
            {
                driver.switchTo().window(Secondarywindow);
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("qaplayground"),"Working as expected");
        driver.quit();
    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void windowpopup()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();


        String Originalwindow=driver.getWindowHandle();

        //<button type="button" id="tw-popup-btn" data-testid="tw-popup-btn" data-popup-url="/practice/tabs-windows" class="inline-flex h-8 w-fit items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">🪟 Open Popup Window</button>

        WebElement popupbutton=driver.findElement(By.id("tw-popup-btn"));
        popupbutton.click();

        for (String Secondarywindow: driver.getWindowHandles())
        {
            if (!Secondarywindow.equals(Originalwindow))
            {
                driver.switchTo().window(Secondarywindow);
                break;
            }
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("qaplayground.com"),"Working as expected");
        driver.quit();
    }

    }

