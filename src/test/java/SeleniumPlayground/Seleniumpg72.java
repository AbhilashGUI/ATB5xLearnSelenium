package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg72 {

    @Test
    @Description("Verify the data table automation practice")
    public void Deletegenere() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select selectone= new Select(driver.findElement(By.id("genre-filter-select")));
        selectone.selectByIndex(4);

        //<button type="button" aria-label="Delete 1984" data-book-id="book-006" class="data-table-module__WJUPia__btnDelete">Delete</button>

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deletebutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Delete 1984']")));
        deletebutton.click();


   //<div class="data-table-module__WJUPia__dialogBox" data-book-id="book-006"><h2 id="delete-dialog-title" class="data-table-module__WJUPia__dialogTitle">Delete Book</h2><p class="data-table-module__WJUPia__dialogBody"><span data-testid="delete-dialog-book-name">1984</span> will be permanently removed.</p><div class="data-table-module__WJUPia__dialogActions"><button type="button" data-testid="delete-dialog-cancel" class="data-table-module__WJUPia__btnOutline">Cancel</button><button type="button" aria-label="Confirm delete 1984" class="data-table-module__WJUPia__btnDanger">Delete</button></div></div>

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement confirmdeletepopup=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='data-table-module__WJUPia__dialogBox']")));

   //<button type="button" aria-label="Confirm delete 1984" class="data-table-module__WJUPia__btnDanger">Delete</button>

        WebElement confirmdeletebutton=confirmdeletepopup.findElement(By.xpath("//button[@aria-label='Confirm delete 1984']"));
        confirmdeletebutton.click();


//<button type="button" data-testid="btn-reset-table" class="data-table-module__WJUPia__btnReset" title="Restore original 25 books">Reset</button>

        WebElement Resetbutton=driver.findElement(By.xpath("//button[@data-testid='btn-reset-table']"));
        Resetbutton.click();

        Thread.sleep(2000);

        driver.quit();

    }

    @Test
    @Description("Verify the other scenario in different browser")
    public void  Cancelgenere() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>

        Select chooseone=new Select(driver.findElement(By.id("genre-filter-select")));
        chooseone.selectByValue("Science Fiction");

        //<button type="button" aria-label="Delete Ender's Game" data-book-id="book-017" class="data-table-module__WJUPia__btnDelete">Delete</button>
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement deletebutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Delete']")));
        deletebutton.click();

        //<div class="data-table-module__WJUPia__dialogBox" data-book-id="book-017"><h2 id="delete-dialog-title" class="data-table-module__WJUPia__dialogTitle">Delete Book</h2><p class="data-table-module__WJUPia__dialogBody"><span data-testid="delete-dialog-book-name">Ender's Game</span> will be permanently removed.</p><div class="data-table-module__WJUPia__dialogActions"><button type="button" data-testid="delete-dialog-cancel" class="data-table-module__WJUPia__btnOutline">Cancel</button><button type="button" aria-label="Confirm delete Ender's Game" class="data-table-module__WJUPia__btnDanger">Delete</button></div></div>
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement cancelpopup=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='data-table-module__WJUPia__dialogBox']")));

        //<button type="button" data-testid="delete-dialog-cancel" class="data-table-module__WJUPia__btnOutline">Cancel</button>
        WebElement cancelbutton=cancelpopup.findElement(By.xpath("//button[@data-testid='delete-dialog-cancel']"));
        cancelbutton.click();

        Thread.sleep(2000);

        driver.quit();





    }
}
