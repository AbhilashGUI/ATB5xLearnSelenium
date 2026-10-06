package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg82 {

    @Test
    @Description("Verify the Form Upload")
    public void DragandDropUploadZone()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input data-testid="fu-drop-input" type="file" class="file-upload-module__y8OjNq__dropZoneHidden" tabindex="-1">
        WebElement Dragafile= driver.findElement(By.xpath("//input[@data-testid='fu-drop-input']"));
        Dragafile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.txt");

        driver.quit();
    }


@Test
@Description("Verify the same scenario in different browser")
public void draganddropfile()
{
    WebDriver driver=new ChromeDriver();
    driver.get("https://qaplayground.com/practice/file-upload");
    driver.manage().window().maximize();

    //<input data-testid="fu-drop-input" type="file" class="file-upload-module__y8OjNq__dropZoneHidden" tabindex="-1">
    WebElement draganddrop=driver.findElement(By.xpath("//input[@data-testid='fu-drop-input']"));
    draganddrop.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.webp");

    //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected via input: "Testfile.webp"</span>
    WebElement messagecheck= driver.findElement(By.xpath("//span[@id='result-s04']"));
    Assert.assertEquals(messagecheck.getText(),"Selected via input: \"Testfile.webp\"");

    driver.quit();
}
}
