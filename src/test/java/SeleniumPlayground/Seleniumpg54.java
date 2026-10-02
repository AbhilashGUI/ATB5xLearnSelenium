package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Seleniumpg54 {

    @Test
    @Description("Verify the Multi-select")
    public void RemoveATag()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<button type="button" aria-label="Remove Java" class="multi-select-module__ep-fQa__tagRemove">×</button>
        WebElement removejava=driver.findElement(By.xpath("//button[@aria-label='Remove Java']"));
        removejava.click();

        //<button type="button" aria-label="Remove Python" class="multi-select-module__ep-fQa__tagRemove">×</button>

        WebElement removepython=driver.findElement(By.xpath("//button[@aria-label='Remove Python']"));
        removepython.click();

        //<button type="button" aria-label="Remove TypeScript" class="multi-select-module__ep-fQa__tagRemove">×</button>

        WebElement removetypescript=driver.findElement(By.xpath("//button[@aria-label='Remove TypeScript']"));
        removetypescript.click();

        //<button type="button" aria-label="Remove JavaScript" class="multi-select-module__ep-fQa__tagRemove">×</button>

        WebElement removejavascript=driver.findElement(By.xpath("//button[@aria-label='Remove JavaScript']"));
        removejavascript.click();

        //<p class="text-[11px] text-muted-foreground italic">All tags removed.</p>

        WebElement confirmtext=driver.findElement(By.xpath("//p[contains(.,'All tags removed')]"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<button type="button" class="inline-flex h-7 w-fit items-center rounded border border-input bg-background px-3 text-xs font-medium transition-colors hover:bg-accent">↺ Reset Tags</button>

        WebElement Resettag=driver.findElement(By.xpath("//button[text()='↺ Reset Tags']"));
        Resettag.click();

        driver.quit();



    }
}
