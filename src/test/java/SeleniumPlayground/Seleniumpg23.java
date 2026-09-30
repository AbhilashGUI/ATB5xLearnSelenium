package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class Seleniumpg23 {

    @Test(groups = "QA")
    @Description("Verify the checkboxes")
    public void CheckboxGroup()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");

        //<input id="skill-playwright" data-testid="chk-skill" data-skill="skill-playwright" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" value="skill-playwright" name="skills">
        //<input id="skill-selenium" data-testid="chk-skill" data-skill="skill-selenium" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" value="skill-selenium" name="skills">
        //<input id="skill-cypress" data-testid="chk-skill" data-skill="skill-cypress" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" value="skill-cypress" name="skills">
        //<input id="skill-webdriverio" data-testid="chk-skill" data-skill="skill-webdriverio" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" value="skill-webdriverio" name="skills">

        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox: checkboxes)
        {
            if (!checkbox.isSelected())
            {
                checkbox.click();
            }
        }

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Playwright, Selenium, Cypress, WebdriverIO</span>

        WebElement messagecheck=driver.findElement(By.id("result-s03"));
        Assert.assertEquals(messagecheck.getText(),"Playwright, Selenium, Cypress, WebdriverIO");

        driver.quit();
    }


    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void checkboxgroup()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");

        //<input id="skill-playwright" data-testid="chk-skill" data-skill="skill-playwright" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" value="skill-playwright" name="skills">
        //<input id="skill-selenium" data-testid="chk-skill" data-skill="skill-selenium" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" value="skill-selenium" name="skills">
        //<input id="skill-cypress" data-testid="chk-skill" data-skill="skill-cypress" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" value="skill-cypress" name="skills">
        //<input id="skill-webdriverio" data-testid="chk-skill" data-skill="skill-webdriverio" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" type="checkbox" value="skill-webdriverio" name="skills">


        List<WebElement> SelectAll=driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement Selecteach:SelectAll)
        {
            if (!Selecteach.isSelected())
            {
                Selecteach.click();
            }
        }

        driver.quit();
    }


}
