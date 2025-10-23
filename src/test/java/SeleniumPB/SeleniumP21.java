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

import java.time.Duration;
import java.util.List;


public class SeleniumP21 {

    EdgeDriver driver;

    @BeforeTest
    public void openbrowser()
    {
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(groups = "QA")
    @Description("Verify the SVG elements")
    public void positivecase()
    {
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        //Searchinputbox
        //<input
        // class="Pke_EE"
        // type="text"
        // title="Search for Products,
        // Brands and More"
        // name="q"
        // autocomplete="off"
        // placeholder="Search for Products, Brands and More"
        // value="">

        driver.findElement(By.name("q")).sendKeys("macmini");

      //list of all svg's ://*[local-name()='svg']
        //<button class="_2iLD__"
        // type="submit"
        // aria-label="Search for Products,
        // Brands and More"
        // title="Search for Products,Brands and More">
        // <svg width="24"
        // height="24"
        // class="" viewBox="0 0 24 24"
        // fill="none" xmlns="http://www.w3.org/2000/svg">
        // <title>Search Icon</title>
        // <path d="M10.5 18C14.6421 18 18 14.6421 18 10.5C18 6.35786 14.6421 3 10.5 3C6.35786 3 3 6.35786 3 10.5C3 14.6421 6.35786 18 10.5 18Z" stroke="#717478"
        // stroke-width="1.4"
        // stroke-linecap="round"
        // stroke-linejoin="round">
        // </path><path d="M16 16L21 21"
        // stroke="#717478"
        // stroke-width="1.4"
        // stroke-linecap="round"
        // stroke-linejoin="round">
        // </path>
        // </svg></button>
      List<WebElement> svgElements= driver.findElements(By.xpath("//button[@type='submit']//*[local-name()='svg']"));
      svgElements.get(0).click();

    }

    @AfterTest
    public void closebrowser()
    {
        driver.quit();
    }
}
