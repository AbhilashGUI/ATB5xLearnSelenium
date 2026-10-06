package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Seleniumpg83 {

    @Test
    @Description("Verify the File Upload")
    public void FileTypeRestriction()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input id="fu-type-input" data-testid="fu-type-input" type="file" accept="image/*" class="file-upload-module__y8OjNq__fileInput">
        WebElement selectedfile=driver.findElement(By.xpath("//input[@id='fu-type-input']"));
        selectedfile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.webp");

        driver.quit();

    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void Restrictionfile()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();


        //<input id="fu-type-input" data-testid="fu-type-input" type="file" accept="image/*" class="file-upload-module__y8OjNq__fileInput">
        WebElement selectedfile=driver.findElement(By.xpath("//input[@id='fu-type-input']"));
        selectedfile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Form8.pdf");

        driver.quit();

    }


}
