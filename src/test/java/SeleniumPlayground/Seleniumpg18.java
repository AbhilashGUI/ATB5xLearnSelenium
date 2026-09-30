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

public class Seleniumpg18 {

    @Test(groups = "QA")
    @Description("Verify the dropdown automation practice")
    public void MultiSelectSuperheros()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");

    //<select id="heroSelect" name="heroes" data-testid="hero-select" class="dropdowns-module__P6SCTq__practiceSelect dropdowns-module__P6SCTq__multiSelect" multiple=""><option value="ant-man">Ant-Man</option><option value="aquaman">Aquaman</option><option value="the-avengers">The Avengers</option><option value="batman">Batman</option></select>

        Select selectmultiple=new Select(driver.findElement(By.id("heroSelect")));
        selectmultiple.selectByIndex(0);
        selectmultiple.selectByIndex(1);
        selectmultiple.selectByIndex(2);
        selectmultiple.selectByIndex(3);


        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected heroes: Ant-Man, Aquaman, The Avengers, Batman</span>

        WebElement messagecheck=driver.findElement(By.id("result-s04"));
        Assert.assertEquals(messagecheck.getText(),"Selected heroes: Ant-Man, Aquaman, The Avengers, Batman");

        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void multiselectfromdd()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");

        //<select id="heroSelect" name="heroes" data-testid="hero-select" class="dropdowns-module__P6SCTq__practiceSelect dropdowns-module__P6SCTq__multiSelect" multiple=""><option value="ant-man">Ant-Man</option><option value="aquaman">Aquaman</option><option value="the-avengers">The Avengers</option><option value="batman">Batman</option></select>

        Select selectmultipledd=new Select(driver.findElement(By.xpath("//select[@id='heroSelect']")));
        selectmultipledd.selectByIndex(0);
        selectmultipledd.selectByIndex(1);
        selectmultipledd.selectByIndex(2);
        selectmultipledd.selectByIndex(3);


        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected heroes: Ant-Man, Aquaman, The Avengers, Batman</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s04']"));
        Assert.assertEquals(messagecheck.getText(),"Selected heroes: Ant-Man, Aquaman, The Avengers, Batman");

        driver.quit();
    }
}
