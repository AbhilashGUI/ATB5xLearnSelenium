package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg15 {


    @Test(groups = "QA")
    @Description("Verify dropdown automation practice")
    public void SelectFruitByIndex() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/dropdowns");

        //<select id="fruitSelect" name="fruit" data-testid="fruit-select" class="dropdowns-module__P6SCTq__practiceSelect"><option value="">Select Fruit</option><option value="apple">Apple</option><option value="banana">Banana</option><option value="orange">Orange</option></select>

        Select selectfruit = new Select(driver.findElement(By.id("fruitSelect")));
        selectfruit.selectByIndex(1);
        String selectedfruit = selectfruit.getFirstSelectedOption().getText();
        System.out.println("Selectedfruit " + selectedfruit);


        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected fruit: Apple</span>
        WebElement messagecheck = driver.findElement(By.id("result-s01"));
        Assert.assertTrue(messagecheck.isDisplayed());

        driver.quit();
    }


    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void SelectFruitByVisibleText() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/dropdowns");


        //<select id="fruitSelect" name="fruit" data-testid="fruit-select" class="dropdowns-module__P6SCTq__practiceSelect"><option value="">Select Fruit</option><option value="apple">Apple</option><option value="banana">Banana</option><option value="orange">Orange</option></select>

        Select selectfruit = new Select(driver.findElement(By.xpath("//select[@id='fruitSelect']")));
        selectfruit.selectByContainsVisibleText("Banana");
        Assert.assertEquals(selectfruit.getFirstSelectedOption().getText(),"Banana");

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected fruit: Apple</span>

        WebElement messagecheck = driver.findElement(By.xpath("//span[@id='result-s01']"));
        Assert.assertTrue(messagecheck.isDisplayed());
        driver.quit();

    }
}
