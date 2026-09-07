package DDT;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DDTRealtimereadfromexcel {


    //Workbook, Sheet, Row and Column, CellS
    //Open Stream
    //Understand Workbook
    //Sheet
    //Row, Column
    //Cells
    //Close Stream - give data to the Object[][]

    static Workbook workbook;
    static Sheet sheet;
    public static String file_path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";


    public static Object[][] getTestDataFromSheet(String Sheetname) {
        FileInputStream file = null;

        try {
            file = new FileInputStream(file_path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheet(Sheetname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;

    }

}


