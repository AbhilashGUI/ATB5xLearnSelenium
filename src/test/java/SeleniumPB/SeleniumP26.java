package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumP26 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify the actions via clicks")
    public void positivecase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait for popup and click close button
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[@class='commonModal__close'] | //span[contains(@class,'loginModal__close')] | //div[@class='loginModal displayBlock modalLogin dynHeight personal ']//span[contains(text(),'×')]")
            ));
            closePopup.click();
            System.out.println("Popup closed successfully!");
        } catch (Exception e) {
            System.out.println("Popup not displayed or already closed.");
        }


        //<input
        // data-cy="fromCity"
        // id="fromCity"
        // type="text"
        // class="fsw_inputField lineHeight36 latoBlack font30"
        // readonly=""
        // value="Delhi">

        WebElement fromcity = driver.findElement(By.id("fromCity"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fromcity).click().sendKeys("Hyderabad").build().perform();

        //ul.react-autosuggest__suggestions-list
        List<WebElement> list_auto_fetching = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));


        for (WebElement e : list_auto_fetching) {
            if (e.getText().contains("Hyderabad")) {
                e.click();
                break;
            }
        }


    }
}