package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg19 {


    @Test(groups = "QA")
    @Description("Verify the dropdown automation practice")
    public void CustomDropDownListbox()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");



        //<button type="button" id="priorityDropdownTrigger" data-testid="priority-dropdown-trigger" class="dropdowns-module__P6SCTq__dropdownTrigger" aria-haspopup="listbox" aria-expanded="true" aria-controls="priorityDropdownList">Choose priority</button>
        WebElement button=driver.findElement(By.id("priorityDropdownTrigger"));
        button.click();


        //<span class="dropdowns-module__P6SCTq__optionCode">priority-low</span>

        WebElement select=driver.findElement(By.className("dropdowns-module__P6SCTq__optionCode"));
        select.click();

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Priority selected: Low Priority</span>

        WebElement messagecheck= driver.findElement(By.id("result-s05"));
        Assert.assertEquals(messagecheck.getText(),"Priority selected: Low Priority");
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void customddlist()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");

        //<button type="button" id="priorityDropdownTrigger" data-testid="priority-dropdown-trigger" class="dropdowns-module__P6SCTq__dropdownTrigger" aria-haspopup="listbox" aria-expanded="true" aria-controls="priorityDropdownList">Choose priority</button>
         WebElement button=driver.findElement(By.xpath("//button[@id='priorityDropdownTrigger']"));
         button.click();

        //<span class="dropdowns-module__P6SCTq__optionCode">priority-low</span>
        WebElement choose=driver.findElement(By.xpath("//span[text()='priority-low']"));
        choose.click();


        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Priority selected: Low Priority</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s05']"));
        Assert.assertEquals(messagecheck.getText(),"Priority selected: Low Priority");
        driver.quit();

    }
}
