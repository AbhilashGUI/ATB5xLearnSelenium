package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP29 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
    }



    @Test(groups = "QA")
    @Description("Verify the file upload")
    public void fileupload()
    {
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();

        //<input type="file" name="fileToUpload" id="fileToUpload">
        WebElement fileupload=driver.findElement(By.id("fileToUpload"));
        String dir=System.getProperty("user.dir");
        System.out.println(dir);
        String filepath=dir+"src/test/java/SeleniumPB/Testfile.txt";
        fileupload.sendKeys(filepath);
        //<input type="submit" value="Upload File" name="submit">
        driver.findElement(By.name("submit")).click();
    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}
