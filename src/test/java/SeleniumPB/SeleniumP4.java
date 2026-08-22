package SeleniumPB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumP4 {

    @Test
    public void vwologin4()
    {

        WebDriver driver=new EdgeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        /*<a href="https://wingify.com/terms/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=legal_terms_login"
        class="btn btn--link btn--primary Fw(medium)"
        target="_blank" rel="noreferrer"
        vwo-html-translate="login:terms"
        data-qa="hosifomexu">Terms</a>
         */

        List<WebElement> all_tags=driver.findElements(By.tagName("a"));
        System.out.println("Total tags="+all_tags.size());
        for (WebElement element:all_tags)
        {
            System.out.println(element.getText());
        }

driver.quit();
    }
}



