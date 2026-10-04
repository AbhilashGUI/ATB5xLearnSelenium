package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;


public class Seleniumpg70 {

    @Test
    @Description("Verify the data table automation practice")
    public void Fetchgeneres() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select selectgenere = new Select(driver.findElement(By.xpath("//select[@id='genre-filter-select']")));
        selectgenere.selectByValue("Technology");

        //<tr data-testid="book-row" data-book-id="book-001" data-genre="technology" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">1</td><td data-col="book-name" class="data-table-module__WJUPia__td">The Pragmatic Programmer</td><td data-col="book-genre" data-genre-value="Technology" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-technology" data-testid="genre-badge">Technology</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">Andrew Hunt</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780135957059</td><td data-col="book-published" class="data-table-module__WJUPia__td">1999-10-20</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit The Pragmatic Programmer" data-book-id="book-001" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete The Pragmatic Programmer" data-book-id="book-001" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>

        List<WebElement> rows = driver.findElements(By.xpath("//tr[@data-testid='book-row']"));
        System.out.println("Number of Technology books: " + rows.size());


        //<td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">1</td>
        for (WebElement Row : rows) {
            List<WebElement> columns = Row.findElements(By.xpath("./td"));


            for (WebElement Column : columns) {
                String CellValue = Column.getText();
                System.out.print(CellValue + " | ");
            }
            System.out.println();

        }
        driver.quit();
    }


    @Test
    @Description("Verify the same scenario for other genere")
    public void Fetchgeneres2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select selectgenere2 = new Select(driver.findElement(By.xpath("//select[@id='genre-filter-select']")));
        selectgenere2.selectByIndex(2);


        //<tr data-testid="book-row" data-book-id="book-004" data-genre="fantasy" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">4</td><td data-col="book-name" class="data-table-module__WJUPia__td">The Hobbit</td><td data-col="book-genre" data-genre-value="Fantasy" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-fantasy" data-testid="genre-badge">Fantasy</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">J.R.R. Tolkien</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780547928227</td><td data-col="book-published" class="data-table-module__WJUPia__td">1937-09-21</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit The Hobbit" data-book-id="book-004" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete The Hobbit" data-book-id="book-004" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@data-testid='book-row']"));

        System.out.println("Number of Fantasy books: " + rows.size());


        //<td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">4</td>

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
    @Description("Verify the similar scenario for other genere")
    public void Fetchgeneres3() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();


        //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select selectgenere3 = new Select(driver.findElement(By.id("genre-filter-select")));
        selectgenere3.selectByValue("Fiction");

        //<tr data-testid="book-row" data-book-id="book-008" data-genre="fiction" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">8</td><td data-col="book-name" class="data-table-module__WJUPia__td">The Great Gatsby</td><td data-col="book-genre" data-genre-value="Fiction" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-fiction" data-testid="genre-badge">Fiction</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">F. Scott Fitzgerald</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780743273565</td><td data-col="book-published" class="data-table-module__WJUPia__td">1925-04-10</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit The Great Gatsby" data-book-id="book-008" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete The Great Gatsby" data-book-id="book-008" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>
        List<WebElement> rows=driver.findElements(By.xpath("//tr[@data-testid='book-row']"));
        System.out.println("Number of Fiction books: "+rows.size());

        //<td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">8</td>

        for (WebElement Row:rows)
        {
            List<WebElement> columns=Row.findElements(By.xpath("./td"));

            for (WebElement Column:columns)
            {
               String Cellvalue= Column.getText();
               System.out.print(Cellvalue + " | ");
            }
            System.out.println();
        }
        driver.quit();

    }
}
