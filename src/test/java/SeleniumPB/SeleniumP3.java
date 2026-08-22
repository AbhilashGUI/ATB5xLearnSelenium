package SeleniumPB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumP3 {

    @Test
    public void vwologin3() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
       /*<a href="https://wingify.com/privacy-policy/?utm_medium=app&amp;
       utm_source=login-page&amp;
       utm_campaign=legal_privacy_login&amp;
       _gl=1*1rnav4k*_gcl_au*MjI1NjAzOTE3LjE3ODczMzI0OTU."
       class="btn btn--link btn--primary Fw(medium)"
       target="_blank"
       rel="noreferrer"
       vwo-html-translate="login:privacyPolicy"
       data-qa="zecuyopefe">
       Privacy policy</a>
        */

            WebElement anchortag = driver.findElement(By.linkText("Privacy policy"));
            String tagvaluefetch = anchortag.getAttribute("href");
            String datavaluefetch = anchortag.getAttribute("data-qa");
            String classvaluefetch = anchortag.getAttribute("class");

            System.out.println(tagvaluefetch);
            System.out.println(datavaluefetch);
            System.out.println(classvaluefetch);

        }

        /*<a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        class="btn Brds(1px) Bdc(--color-gray-5) Bds(s) W(100%)"
        target="_blank" rel="noreferrer"
        style="display:flex; align-items:center;
        justify-content:center; text-decoration:none;">
         */
        @Test
        public void vwologin3b ()
        {
            WebDriver driver1 = new ChromeDriver();
            driver1.get("https://app.vwo.com");
            driver1.manage().window().maximize();
            WebElement anchortag2 = driver1.findElement(By.partialLinkText("Start a"));
            String classvalue = anchortag2.getAttribute("class");
            System.out.println(classvalue);
            driver1.quit();


        }


}




