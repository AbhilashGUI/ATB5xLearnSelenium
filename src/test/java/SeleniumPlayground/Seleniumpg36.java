package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg36 {

    @Test(groups = "QA")
    @Description("Verify the Modal windows Automation practice")
    public void SimpleModal()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/modals");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Automate Modal Windows in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/modals");


        //<button class="flex h-9 items-center justify-center rounded-md bg-blue-600 px-4 text-sm font-medium text-white hover:bg-blue-700" data-testid="btn-open-simple-modal">Open Simple Modal</button>

        WebElement openmodalbutton=driver.findElement(By.xpath("//button[text()='Open Simple Modal']"));
        openmodalbutton.click();


        Assert.assertTrue(openmodalbutton.isDisplayed(),"Modal should be displayed");

        //<button data-testid="btn-confirm-simple-modal" class="h-9 rounded bg-blue-600 px-4 text-sm font-medium text-white hover:bg-blue-700">Confirm</button>

        WebElement confirmbutton=driver.findElement(By.xpath("//button[@data-testid='btn-confirm-simple-modal']"));
        confirmbutton.click();
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void simplemodal()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/modals");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Automate Modal Windows in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/modals");


        //<button class="flex h-9 items-center justify-center rounded-md bg-blue-600 px-4 text-sm font-medium text-white hover:bg-blue-700" data-testid="btn-open-simple-modal">Open Simple Modal</button>

        WebElement openmodalbutton=driver.findElement(By.xpath("//button[text()='Open Simple Modal']"));
        openmodalbutton.click();
        Assert.assertTrue(openmodalbutton.isDisplayed(),"Modal should be opened");

        //<button data-testid="btn-confirm-simple-modal" class="h-9 rounded bg-blue-600 px-4 text-sm font-medium text-white hover:bg-blue-700">Confirm</button>

        WebElement confirmbutton=driver.findElement(By.xpath("//button[@data-testid='btn-confirm-simple-modal']"));
        confirmbutton.click();
        Assert.assertTrue(openmodalbutton.isDisplayed(),"Modal should be closed");

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Closed</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s01']"));
        Assert.assertEquals(messagecheck.getText(),"Closed");

        driver.quit();


    }

}
