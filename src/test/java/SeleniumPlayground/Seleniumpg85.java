package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg85 {

    @Test
    @Description("Verify the File Upload")
    public void CustomTriggerbutton()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<button type="button" data-testid="fu-custom-btn" class="file-upload-module__y8OjNq__customUploadBtn">📎 Choose File</button>
            WebElement choosefile=driver.findElement(By.xpath("//button[@data-testid='fu-custom-btn']"));



        //<input type="file" style="display:none" aria-hidden="true" tabindex="-1">
        WebElement hiddenfileinput=driver.findElement(By.xpath("//input[@type='file'and @aria-hidden='true']"));
        hiddenfileinput.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Form8.pdf");


        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Hidden input received: "Form8.pdf"</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s07']"));
        Assert.assertEquals(messagecheck.getText(),"Hidden input received: \"Form8.pdf\"");

        driver.quit();

    }


    @Test
    @Description("Verify the same in different browser")
    public void customtriggerbutton()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<button type="button" data-testid="fu-custom-btn" class="file-upload-module__y8OjNq__customUploadBtn">📎 Choose File</button>
        WebElement choosefilebutton=driver.findElement(By.xpath("//button[@data-testid='fu-custom-btn']"));

        //<input type="file" style="display:none" aria-hidden="true" tabindex="-1">
        WebElement hidetheinput=driver.findElement(By.xpath("//input[@style='display:none']"));
        hidetheinput.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Form8.pdf");



        //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Hidden input received: "Form8.pdf"</span>
        WebElement messagecheck=driver.findElement(By.id("result-s07"));
        Assert.assertEquals(messagecheck.getText(),"Hidden input received: \"Form8.pdf\"");

        driver.quit();
    }
    }
