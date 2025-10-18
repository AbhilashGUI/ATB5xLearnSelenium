package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumP3 {


    //Locators > Id, Name, ClassName etc
    //Gettext and Getattribute are methods used to view/fetch the elements
    //LinkText and PartialText
    //CssSelectors
    //Xpath

    @Test(groups = "QA")
    @Description("Verify by text elements")
    public void Testvwologin3() {

        WebDriver driver= new EdgeDriver();
        driver.get("https://app.vwo.com");



        //<a
        //href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        //class="text-link Td(n)"
        //data-qa="bericafeqo"
        // >Start a free trial
        // </a>

        WebElement anchor_tag=driver.findElement(By.linkText("Start a free trial"));
        //WebElement anchor_tag= driver.findElement(By.partialLinkText("Start a free"));
        System.out.println(anchor_tag.getAttribute("href"));
        anchor_tag.click();
        driver.close();
    }


}
