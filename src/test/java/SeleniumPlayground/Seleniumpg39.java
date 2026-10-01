package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg39 {

    @Test(groups = "QA")
    @Description("Verify the Modal window automation practice")
    public void ModalFromRepeatedCard() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/modals");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/modals");
        Assert.assertEquals(driver.getTitle(), "How to Automate Modal Windows in Selenium and Playwright | QA Playground");


        //<button class="modals-module__uJEcWG__cardBtn" data-testid="btn-open-course">Details</button>

       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement secondDetailsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-testid='btn-open-course'])[2]")));
        secondDetailsButton.click();




        //<button data-testid="btn-close-course" class="h-9 rounded bg-gray-200 px-4 text-sm font-medium text-gray-900 hover:bg-gray-300">Close</button>

        WebElement closebutton=driver.findElement(By.xpath("//button[@data-testid='btn-close-course']"));
        closebutton.click();

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Closed Advanced Course</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s02']"));
        Assert.assertEquals(messagecheck.getText(),"Closed Advanced Course");

        driver.quit();



    }
}