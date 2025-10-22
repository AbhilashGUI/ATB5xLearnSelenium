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

import java.util.List;

public class SeleniumP20 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify the webtables")
    public void positivecase() {
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable1.html");
        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        List<WebElement> row_table = table.findElements(By.tagName("tr"));
        System.out.println(row_table.size() + "\n");

        for (int j = 0; j < row_table.size(); j++) {
            List<WebElement> column = row_table.get(j).findElements(By.tagName("td"));
            for (WebElement element : column) {
                System.out.println(element.getText());
            }


        }

        System.out.println();
    }

    @AfterTest
    public void closebrowser() {
        driver.quit();
    }
}