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

public class Seleniumpg74 {

    @Test
    @Description("Verify the data table automation practice")
    public void Addbook()
    {

        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<button type="button" data-testid="btn-add-book" aria-label="Add new book" class="data-table-module__WJUPia__btnAdd">+ Add Book</button>

        WebElement Addbook=driver.findElement(By.xpath("//button[@data-testid='btn-add-book']"));
        Addbook.click();

       //<input id="add-book-name" placeholder="Enter book title" data-testid="add-input-book-name" aria-required="true" aria-invalid="false" class="data-table-module__WJUPia__fieldInput" type="text" value="" name="bookName">

        WebElement bookname=driver.findElement(By.xpath("//input[@placeholder='Enter book title']"));
        bookname.sendKeys("TestOptimism");


        //<input id="add-book-author" placeholder="Author name" data-testid="add-input-book-author" aria-required="true" aria-invalid="false" class="data-table-module__WJUPia__fieldInput" type="text" value="" name="bookAuthor">

        WebElement bookauthor=driver.findElement(By.name("bookAuthor"));
        bookauthor.sendKeys("Abhilash");

        //<select id="add-book-genre" name="bookGenre" data-testid="add-select-genre" class="data-table-module__WJUPia__fieldInput"><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select select=new Select(driver.findElement(By.xpath("//select[@data-testid='add-select-genre']")));
        select.selectByValue("Technology");

        //<input placeholder="9780000000000" class="data-table-module__WJUPia__fieldInput" type="text" value="" name="isbn_field_new">

         WebElement ISBN=driver.findElement(By.xpath("//input[@name='isbn_field_new']"));
         ISBN.sendKeys("65664123254");

        //<input id="add-book-published" placeholder="YYYY-MM-DD" data-testid="add-input-book-published" class="data-table-module__WJUPia__fieldInput" type="text" value="" name="bookPublished">

         WebElement publishedon=driver.findElement(By.xpath("//input[@data-testid='add-input-book-published']"));
         publishedon.sendKeys("2025-10-04");

         //<button type="button" data-testid="add-dialog-save" aria-label="Save new book" class="data-table-module__WJUPia__btnPrimary">Add Book</button>
        WebElement savebutton=driver.findElement(By.xpath("//button[@data-testid='add-dialog-save']"));
        savebutton.click();

         //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select selecttoview=new Select(driver.findElement(By.xpath("//select[@data-testid='genre-filter']")));
        selecttoview.selectByIndex(1);

        //<button type="button" class="data-table-module__WJUPia__pgBtn data-table-module__WJUPia__pgBtnActive" data-testid="pagination-page-2" aria-label="Page 2" aria-current="page">2</button>

        WebElement page2=driver.findElement(By.xpath("//button[@data-testid='pagination-page-2']"));
        page2.click();

        driver.quit();
    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void Addbook2()
    {

        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<button type="button" data-testid="btn-add-book" aria-label="Add new book" class="data-table-module__WJUPia__btnAdd">+ Add Book</button>

        WebElement Addbook=driver.findElement(By.xpath("//button[@data-testid='btn-add-book']"));
        Addbook.click();

        //<input id="add-book-name" placeholder="Enter book title" data-testid="add-input-book-name" aria-required="true" aria-invalid="false" class="data-table-module__WJUPia__fieldInput" type="text" value="" name="bookName">

        WebElement bookname=driver.findElement(By.xpath("//input[@placeholder='Enter book title']"));
        bookname.sendKeys("TestPessimism");


        //<input id="add-book-author" placeholder="Author name" data-testid="add-input-book-author" aria-required="true" aria-invalid="false" class="data-table-module__WJUPia__fieldInput" type="text" value="" name="bookAuthor">

        WebElement bookauthor=driver.findElement(By.name("bookAuthor"));
        bookauthor.sendKeys("Vicky");

        //<select id="add-book-genre" name="bookGenre" data-testid="add-select-genre" class="data-table-module__WJUPia__fieldInput"><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select select=new Select(driver.findElement(By.xpath("//select[@data-testid='add-select-genre']")));
        select.selectByValue("Technology");


        //<button type="button" data-testid="add-dialog-save" aria-label="Save new book" class="data-table-module__WJUPia__btnPrimary">Add Book</button>
        WebElement savebutton=driver.findElement(By.xpath("//button[@data-testid='add-dialog-save']"));
        savebutton.click();

        //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select selecttoview=new Select(driver.findElement(By.xpath("//select[@data-testid='genre-filter']")));
        selecttoview.selectByIndex(1);

        //<button type="button" class="data-table-module__WJUPia__pgBtn data-table-module__WJUPia__pgBtnActive" data-testid="pagination-page-2" aria-label="Page 2" aria-current="page">2</button>
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visibility=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='pagination-page-2']")));
        visibility.click();

        driver.quit();


    }


}
