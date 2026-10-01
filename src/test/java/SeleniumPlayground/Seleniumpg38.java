package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg38 {


    @Test(groups = "QA")
    @Description("Verify the Modal window automation practice")
    public void DynamicIDModel()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/modals");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Automate Modal Windows in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/modals");

        //<button class="flex h-9 items-center justify-center rounded-md bg-purple-600 px-4 text-sm font-medium text-white hover:bg-purple-700" data-testid="btn-open-dynamic-modal">Open Dynamic Modal</button>

        WebElement opendynamicbutton=driver.findElement(By.xpath("//button[@data-testid='btn-open-dynamic-modal']"));
        opendynamicbutton.click();

        //<button id="confirm-modal-47" class="h-9 rounded bg-purple-600 px-4 text-sm font-medium text-white hover:bg-purple-700">Confirm Action</button>
        WebElement confirmbutton=driver.findElement(By.xpath("//button[text()='Confirm Action']"));
        confirmbutton.click();

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Confirmed</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s03']"));
        Assert.assertEquals(messagecheck.getText(),"Confirmed");

        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the other window in different browser")
    public void dynamicidmodel()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/modals");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Automate Modal Windows in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/modals");

        //<button class="flex h-9 items-center justify-center rounded-md bg-purple-600 px-4 text-sm font-medium text-white hover:bg-purple-700" data-testid="btn-open-dynamic-modal">Open Dynamic Modal</button>

        WebElement opendynamicbutton=driver.findElement(By.xpath("//button[@data-testid='btn-open-dynamic-modal']"));
        opendynamicbutton.click();

        //<button id="cancel-modal-6625" class="h-9 rounded bg-gray-200 px-4 text-sm font-medium text-gray-900 hover:bg-gray-300">Cancel</button>
        WebElement cancelbutton=driver.findElement(By.xpath("//button[text()='Cancel']"));
        cancelbutton.click();

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Opened</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s03']"));
        Assert.assertEquals(messagecheck.getText(),"Opened");

        driver.quit();



    }

}
