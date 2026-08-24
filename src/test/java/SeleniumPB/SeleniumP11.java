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

public class SeleniumP11 {

    EdgeDriver driver;
    @BeforeTest
    public void openbrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver();

    }

    @Test(groups ="QA")
    @Description("Verify using the css selectors")
    public void ebay() {
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        driver.manage().window().maximize();

      /*<input
      data-marko="{&quot;oninput&quot;:&quot;handleTextUpdate s0-1-4-10-4 false&quot;,&quot;onfocusin&quot;:&quot;handleMarkTimer s0-1-4-10-4 false&quot;,&quot;onkeydown&quot;:&quot;handleMarkTimer s0-1-4-10-4 false&quot;}"
      data-marko-key="@input s0-1-4-10-4"
      id="gh-ac"
      class="gh-search-input gh-tb ui-autocomplete-input"
      title="Search"
      type="text"
      placeholder="Search for anything"
      aria-autocomplete="list"
      aria-expanded="false"
      size="50"
      maxlength="300"
      aria-label="Search for anything"
      name="_nkw" autocapitalize="off"
      autocorrect="off"
      spellcheck="false"
      autocomplete="off"
      aria-haspopup="true"
      role="combobox"
      tabindex="4" aria-controls="ebay-autocomplete">
       */

        WebElement searchbox = driver.findElement(By.cssSelector("#gh-ac"));
        searchbox.sendKeys("macmini");

        /*<button
        data-marko="{&quot;onclick&quot;:&quot;handleClick s0-1-4-10-8-@btn false&quot;,&quot;onkeydown&quot;:&quot;handleKeydown s0-1-4-10-8-@btn false&quot;,&quot;onfocus&quot;:&quot;handleFocus s0-1-4-10-8-@btn false&quot;,&quot;onblur&quot;:&quot;handleBlur s0-1-4-10-8-@btn false&quot;}"
        class="gh-search-button btn btn--primary" d
        ata-ebayui=""
        type="submit"
        id="gh-search-btn"
        role="button"
        value="Search"
        tabindex="6">
        <span
        class="gh-search-button__label"
        >Search
        </span>
        <svg data-marko-key="@svg s0-1-4-10-8-@btn-7-2-0" class="gh-search-button__icon icon icon--16" focusable="false" aria-hidden="true"><use href="#icon-search-16"></use></svg></button>
         */

        WebElement searchbuttonclick = driver.findElement(By.cssSelector("#gh-search-btn"));
        searchbuttonclick.click();

       /*<div
       role="heading"
       aria-level="3"
       class="s-card__title">
       <span class="su-styled-text primary default">
       Apple Mac Mini A1993 i3-8100B 3.60GHz 8GB RAM 128GB SSD Mojave
       </span><span class="clipped">Opens in a new window or tab</span></div>
        */

        List<WebElement> fetchtitles = driver.findElements(By.className("s-card__title"));
        System.out.println("Total number of titles count:" + fetchtitles.size());

        for (WebElement titles : fetchtitles) {
            System.out.println(titles.getText());
        }
    }

    @AfterTest
    public void closebrowser()
    {
        if(driver !=null)
            driver.quit();




    }
}