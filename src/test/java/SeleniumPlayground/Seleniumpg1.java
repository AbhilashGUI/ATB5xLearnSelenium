package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg1 {


    @Test(groups = "QA")
    @Description("Verify the input field automation practice ")
    public void TypeaMovieName()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");


        //<input id="movieNameInput" data-testid="input-movie-name" type="text" class="input-fields-module__pJ4Qbq__practiceInput" placeholder="Enter a movie name…" aria-label="Movie name" value="">

        WebElement inputfield=driver.findElement(By.id("movieNameInput"));
        inputfield.sendKeys("Tegimpu");
        Assert.assertEquals("Tegimpu",inputfield.getAttribute("value"));
        System.out.println(inputfield.getAttribute("value"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<button type="button" id="submitMovieBtn" data-testid="btn-submit-movie" class="input-fields-module__pJ4Qbq__actionBtn">Submit</button>
        WebElement submitbutton=driver.findElement(By.className("input-fields-module__pJ4Qbq__actionBtn"));
        submitbutton.click();

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">You entered: Tegimpu</span>
        WebElement messagecheck=driver.findElement(By.id("result-s01"));
        Assert.assertTrue(messagecheck.isDisplayed());
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void typeamoviename()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");

        //input id="movieNameInput"
        WebElement inputfield=driver.findElement(By.xpath("//input[@id='movieNameInput']"));
        inputfield.sendKeys("Tegimpu");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //id="submitMovieBtn"
        WebElement submitbutton=driver.findElement(By.xpath("//button[@id='submitMovieBtn']"));
        submitbutton.click();

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">You entered: Tegimpu</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s01']"));
        Assert.assertTrue(messagecheck.isDisplayed());
        driver.quit();



    }
}
