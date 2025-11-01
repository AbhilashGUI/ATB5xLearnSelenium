package DDT;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Datacreationatspecificcell {

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("Main");

        Row row= sheet.createRow(0);
        Cell cell= row.createCell(0);
        cell.setCellValue("Abhilash");

        FileOutputStream fileOutputStream= new FileOutputStream(new File("CellSPECIFIC.xlsx"));
        workbook.write(fileOutputStream);
        fileOutputStream.close();


    }
}
