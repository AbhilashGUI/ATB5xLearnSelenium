package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg53 {

    @Test
    @Description("Verify the Multi-select")
    public void SelectandClearAll()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<button type="button" data-testid="ms-custom-trigger" aria-haspopup="listbox" aria-expanded="true" class="multi-select-module__ep-fQa__customTrigger multi-select-module__ep-fQa__customTriggerOpen">Select frameworks<span class="multi-select-module__ep-fQa__caret multi-select-module__ep-fQa__caretOpen">▾</span></button>
        WebElement selectbutton=driver.findElement(By.xpath("(//button[@aria-haspopup='listbox'])[2]"));
        selectbutton.click();

        //<button type="button" data-testid="ms-select-all-btn" class="multi-select-module__ep-fQa__bulkBtn">Select All</button>
        WebElement selectall=driver.findElement(By.xpath("//button[text()='Select All']"));
        selectall.click();


        //<button type="button" data-testid="ms-clear-all-btn" class="multi-select-module__ep-fQa__bulkBtn">Clear All</button>
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement clearall=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='ms-clear-all-btn']")));
        clearall.click();

        driver.quit();

    }

    @Test
    @Description("Verify the same in different browser")
    public void selectandclearall()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<button type="button" data-testid="ms-custom-trigger" aria-haspopup="listbox" aria-expanded="true" class="multi-select-module__ep-fQa__customTrigger multi-select-module__ep-fQa__customTriggerOpen">Select frameworks<span class="multi-select-module__ep-fQa__caret multi-select-module__ep-fQa__caretOpen">▾</span></button>

        WebElement initialbutton=driver.findElement(By.xpath("(//button[@aria-haspopup='listbox']) [2]"));
        initialbutton.click();

        //<button type="button" data-testid="ms-select-all-btn" class="multi-select-module__ep-fQa__bulkBtn">Select All</button>
        WebElement selectall=driver.findElement(By.xpath("//button[text()='Select All']"));
        selectall.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">All selected</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s05']"));
        Assert.assertEquals(messagecheck.getText(),"All selected");

        //<button type="button" data-testid="ms-clear-all-btn" class="multi-select-module__ep-fQa__bulkBtn">Clear All</button>
        WebElement clearall=driver.findElement(By.xpath("//button[@data-testid='ms-clear-all-btn']"));
        clearall.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Cleared — nothing selected</span>
        WebElement messagecheck2=driver.findElement(By.xpath("//span[@id='result-s05']"));
        Assert.assertEquals(messagecheck2.getText(),"Cleared — nothing selected");

        driver.quit();


    }


}
