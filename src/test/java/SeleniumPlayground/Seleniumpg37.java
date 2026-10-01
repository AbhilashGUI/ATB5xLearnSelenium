package SeleniumPlayground;

import io.qameta.allure.Description;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Seleniumpg37 {

    @Test(groups = "QA")
    @Description("Verify the Modal window automation practice")
    public void ModalFromRepeatedCard() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/modals");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/modals");
        Assert.assertEquals(driver.getTitle(), "How to Automate Modal Windows in Selenium and Playwright | QA Playground");


        //<button class="modals-module__uJEcWG__cardBtn" data-testid="btn-open-course">Details</button>

        WebElement wrongbutton = driver.findElement(By.xpath("//button[text()='Details']"));
        wrongbutton.click();

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Wrong card clicked</span>

        WebElement messagecheck = driver.findElement(By.xpath("//span[@id='result-s02']"));
        Assert.assertEquals(messagecheck.getText(), "Wrong card clicked");

        driver.quit();
    }


    }