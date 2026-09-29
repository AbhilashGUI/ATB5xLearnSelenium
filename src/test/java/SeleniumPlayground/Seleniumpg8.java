package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg8 {

    @Test(groups = "QA")
    @Description("Verify the buttons automation practice")
    public void GetButtonsXYCoordinates() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Button Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/buttons");

        //<button id="coordinatesBtn" data-testid="btn-get-coordinates" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnTeal">Find Location</button>

        Thread.sleep(2000);
        WebElement locationcheck= driver.findElement(By.id("coordinatesBtn"));
        locationcheck.click();

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">X: 69px, Y: 371px</span>
        WebElement loccordinates= driver.findElement(By.id("result-s02"));
        Assert.assertTrue(loccordinates.isDisplayed());

        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void getbuttonsxycoordinates() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Button Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/buttons");

        //<button id="coordinatesBtn" data-testid="btn-get-coordinates" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnTeal">Find Location</button>

        Thread.sleep(2000);
        WebElement locationcheck=driver.findElement(By.xpath("//button[text()='Find Location']"));
        locationcheck.click();
//<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">X: 69px, Y: 371px</span>
        WebElement loccordinates= locationcheck.findElement(By.xpath("//span[@id='result-s02']"));
        Assert.assertTrue(loccordinates.isDisplayed());
        driver.quit();
    }
}
