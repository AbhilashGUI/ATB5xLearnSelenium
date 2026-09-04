package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumP33 {

    EdgeDriver driver;
    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new EdgeDriver(edgeOptions);
    }


    @Test(groups = "QA")
    @Description("Verify the Iframe with relative locators")
    public void framerelation() throws InterruptedException {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(5000);
//<iframe id="result" src="https://codepen.io/AbdullahSajjad/fullpage/LYGVRgK?anon=true&amp;view=fullpage" sandbox="allow-downloads allow-forms allow-modals allow-pointer-lock allow-popups allow-popups-to-escape-sandbox allow-presentation allow-same-origin allow-scripts allow-top-navigation-by-user-activation" allow="accelerometer *; ambient-light-sensor *; camera *; display-capture *; encrypted-media *; geolocation *; gyroscope *; microphone *; midi *; payment *; serial *; vr *; web-share *; xr-spatial-tracking *" allowtransparency="true" allowpaymentrequest="true" allowfullscreen="true" class="result-iframe" loading="lazy"></iframe>
        driver.switchTo().frame("result");

        WebElement submitbutton=driver.findElement(By.xpath("//*[@id=\"form\"]/button"));
        submitbutton.click();

        WebElement username=driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement errorcheck=driver.findElement(with(By.tagName("small")).below(username));
        String errortext=errorcheck.getText();
        System.out.println(errortext);
        Assert.assertEquals(errortext,"Username must be at least 3 characters");

    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}