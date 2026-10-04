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

public class Seleniumpg69 {

    @Test
    @Description("Verify the data table automation practice")
    public void datatablepage1() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<tr data-testid="book-row" data-book-id="book-001" data-genre="technology" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">1</td><td data-col="book-name" class="data-table-module__WJUPia__td">The Pragmatic Programmer</td><td data-col="book-genre" data-genre-value="Technology" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-technology" data-testid="genre-badge">Technology</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">Andrew Hunt</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780135957059</td><td data-col="book-published" class="data-table-module__WJUPia__td">1999-10-20</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit The Pragmatic Programmer" data-book-id="book-001" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete The Pragmatic Programmer" data-book-id="book-001" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>
        //Get all book rows
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@data-testid='book-row']"));

        int rowCount = rows.size();

        //<td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">1</td>
        // Get columns from first book row

        List<WebElement> columns = rows.get(0).findElements(By.xpath("./td"));
        int columnCount = columns.size();

        //Note: .indicates selects the current node
        // / indicates selects the root node


        System.out.println("Number of rows    : " + rowCount);
        System.out.println("Number of columns : " + columnCount);

        driver.quit();

    }

    @Test
    @Description("Verify the same scenario of next page")
    public void datatablepage2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();


        //<button type="button" class="data-table-module__WJUPia__pgBtn" data-testid="pagination-page-2" aria-label="Page 2">2</button>

        WebElement page2=driver.findElement(By.xpath("//button[@data-testid='pagination-page-2']"));
        page2.click();

        //<tr data-testid="book-row" data-book-id="book-006" data-genre="dystopian" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">6</td><td data-col="book-name" class="data-table-module__WJUPia__td">1984</td><td data-col="book-genre" data-genre-value="Dystopian" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-dystopian" data-testid="genre-badge">Dystopian</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">George Orwell</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780451524935</td><td data-col="book-published" class="data-table-module__WJUPia__td">1949-06-08</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit 1984" data-book-id="book-006" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete 1984" data-book-id="book-006" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>

        List<WebElement>rows=driver.findElements(By.xpath("//tr[@data-testid='book-row']"));
        int rowcount= rows.size();

        //<td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">6</td>
        List<WebElement>columns=rows.get(1).findElements(By.xpath("./td"));
        int columncount=columns.size();

        System.out.println("No.of rows: "+rowcount);
        System.out.println("No.of columns: "+columncount);

        driver.quit();
    }

    @Test
    @Description("Verify the same scenario of next page")
    public void datatablepage5()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();


        //<button type="button" class="data-table-module__WJUPia__pgBtn" data-testid="pagination-page-5" aria-label="Page 5">5</button>
        WebElement lastpage=driver.findElement(By.xpath("//button[@data-testid='pagination-page-5']"));
        lastpage.click();


        //<tr data-testid="book-row" data-book-id="book-021" data-genre="non-fiction" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">21</td><td data-col="book-name" class="data-table-module__WJUPia__td">The Psychology of Money</td><td data-col="book-genre" data-genre-value="Non-Fiction" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-non-fiction" data-testid="genre-badge">Non-Fiction</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">Morgan Housel</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780857197689</td><td data-col="book-published" class="data-table-module__WJUPia__td">2020-09-08</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit The Psychology of Money" data-book-id="book-021" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete The Psychology of Money" data-book-id="book-021" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>

        List<WebElement> rows=driver.findElements(By.xpath("//tr[@data-testid='book-row']"));
        int rowcount= rows.size();


        //<td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">21</td>

        List<WebElement> columns=rows.get(2).findElements(By.tagName("td"));
        int columncount=columns.size();

        System.out.println("No.of rows: "+rowcount);
        System.out.println("No.of columns: "+columncount);

        driver.quit();




    }
}
