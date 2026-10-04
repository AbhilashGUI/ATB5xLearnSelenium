package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Seleniumpg73 {

    @Test
    @Description("Verify the data table automation practice")
    public void Fetchviatext() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //bookauthor-Orson Scott Card
        //<input id="table-search-input" type="search" placeholder="Search books…" data-testid="table-search" aria-label="Search books" class="data-table-module__WJUPia__searchInput" value="">

        WebElement bookauthor = driver.findElement(By.id("table-search-input"));
        bookauthor.sendKeys("Orson Scott Card");

        //<tr data-testid="book-row" data-book-id="book-017" data-genre="science-fiction" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">17</td><td data-col="book-name" class="data-table-module__WJUPia__td">Ender's Game</td><td data-col="book-genre" data-genre-value="Science Fiction" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-science-fiction" data-testid="genre-badge">Science Fiction</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">Orson Scott Card</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780812550702</td><td data-col="book-published" class="data-table-module__WJUPia__td">1985-01-15</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit Ender's Game" data-book-id="book-017" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete Ender's Game" data-book-id="book-017" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@data-testid='book-row']"));

        //<td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">17</td>


        for (WebElement Row : rows) {
            List<WebElement> columns = Row.findElements(By.xpath("./td"));


            for (WebElement Column : columns) {
                String Cellvalue = Column.getText();
                System.out.print(Cellvalue + " | ");

            }
            System.out.println();

        }
        driver.quit();

    }

    @Test
    @Description("Verify the similar scenario in different browser")
    public void Fetchviatext2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //bookname=The Clean Coder
        //<input id="table-search-input" type="search" placeholder="Search books…" data-testid="table-search" aria-label="Search books" class="data-table-module__WJUPia__searchInput" value="">

        WebElement bookname = driver.findElement(By.xpath("//input[@type='search']"));
        bookname.sendKeys("The Clean Coder");

        //<tr data-testid="book-row" data-book-id="book-001" data-genre="technology" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">1</td><td data-col="book-name" class="data-table-module__WJUPia__td">The Pragmatic Programmer</td><td data-col="book-genre" data-genre-value="Technology" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-technology" data-testid="genre-badge">Technology</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">Andrew Hunt</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780135957059</td><td data-col="book-published" class="data-table-module__WJUPia__td">1999-10-20</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit The Pragmatic Programmer" data-book-id="book-001" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete The Pragmatic Programmer" data-book-id="book-001" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@data-testid='book-row']"));

        //<td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">1</td>
        for (WebElement Row : rows) {
            List<WebElement> columns = Row.findElements(By.xpath("./td"));

            for (WebElement Column : columns) {
                String Cellvalue = Column.getText();
                System.out.print(Cellvalue + " | ");
            }
            System.out.println();
        }

        driver.quit();

    }

    @Test
    @Description("Verify the similar scenario in different browser")
    public void Fetchviatext3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();


        //<input id="table-search-input" type="search" placeholder="Search books…" data-testid="table-search" aria-label="Search books" class="data-table-module__WJUPia__searchInput" value="The Clean Coder">
        //bookgener=Fiction
        WebElement bookgener=driver.findElement(By.xpath("//input[@placeholder='Search books…']"));
        bookgener.sendKeys("Fiction");


        //<button type="button" class="data-table-module__WJUPia__pgBtn data-table-module__WJUPia__pgBtnActive" data-testid="pagination-page-2" aria-label="Page 2" aria-current="page">2</button>
        WebElement page2=driver.findElement(By.xpath("//button[@data-testid='pagination-page-2']"));
        page2.click();

        //<button type="button" class="data-table-module__WJUPia__pgBtn data-table-module__WJUPia__pgBtnActive" data-testid="pagination-page-3" aria-label="Page 3" aria-current="page">3</button>
        WebElement page3=driver.findElement(By.xpath("//button[@data-testid='pagination-page-3']"));
        page3.click();


        driver.quit();


    }

}
