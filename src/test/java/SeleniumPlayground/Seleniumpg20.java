package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Seleniumpg20 {

    @Test(groups = "QA")
    @Description("Verify the dropdown automation practice")
    public  void SearchableCityCombobox()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");

        //<input id="citySearch" role="combobox" aria-expanded="true" aria-controls="cityResults" aria-autocomplete="list" aria-label="City" class="dropdowns-module__P6SCTq__comboInput" placeholder="Search city" value="Hyderabad" name="city_search_dynamic_2026">

        WebElement entercity= driver.findElement(By.id("citySearch"));
        entercity.clear();
        entercity.sendKeys("Hyderabad");

        //<button type="button" role="option" data-city-id="city-hyderabad" data-city-value="hyderabad" aria-selected="true" class="dropdowns-module__P6SCTq__option dropdowns-module__P6SCTq__cityOption"><span>Hyderabad</span><span class="dropdowns-module__P6SCTq__optionCode">TS</span></button>
        WebElement selectcity=driver.findElement(By.xpath("//*[@id='cityResults']/li/button"));
        selectcity.click();

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">City selected: Hyderabad (city-hyderabad)</span>
        WebElement messagecheck=driver.findElement(By.id("result-s06"));
        Assert.assertEquals(messagecheck.getText(),"City selected: Hyderabad (city-hyderabad)");
        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void searchablecitycombobox()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");

        //<input id="citySearch" role="combobox" aria-expanded="true" aria-controls="cityResults" aria-autocomplete="list" aria-label="City" class="dropdowns-module__P6SCTq__comboInput" placeholder="Search city" value="Hyderabad" name="city_search_dynamic_2026">

          WebElement entercity=driver.findElement(By.xpath("//input[@id='citySearch']"));
          entercity.sendKeys("Delhi");

        //<button type="button" role="option" data-city-id="city-hyderabad" data-city-value="hyderabad" aria-selected="true" class="dropdowns-module__P6SCTq__option dropdowns-module__P6SCTq__cityOption"><span>Hyderabad</span><span class="dropdowns-module__P6SCTq__optionCode">TS</span></button>
         WebElement selectcity=driver.findElement(By.xpath("//*[@id='cityResults']/li/button"));
         selectcity.click();

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">City selected: Hyderabad (city-hyderabad)</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s06']"));
        Assert.assertEquals(messagecheck.getText(),"City selected: Delhi (city-delhi)");
        driver.quit();
    }

    }

