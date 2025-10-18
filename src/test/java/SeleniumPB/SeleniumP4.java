package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumP4 {

    @Test(groups = "P0")
    @Description("Verify all tags")
    public void Testvwologin4()
    {

        WebDriver driver= new EdgeDriver();
        driver.get("https://app.vwo.com");
        List<WebElement> all_tags=driver.findElements(By.tagName("a"));
        //<a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link Td(n)"
        // data-qa="bericafeqo">
        // Start a free trial
        // </a>


        System.out.println("Total links "+all_tags.size());
        //all_tags.get(0).click();
        //all_tags.get(1).click();
        for (WebElement element:all_tags)
        {
            System.out.println(element.getText());
        }
        driver.close();

    }
}

