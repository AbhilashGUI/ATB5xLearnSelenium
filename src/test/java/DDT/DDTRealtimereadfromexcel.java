package DDT;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DDTRealtimereadfromexcel {


    public FileInputStream fis;
    public FileOutputStream fos;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path;
        public DDTRealtimereadfromexcel(String path)
        {
            this.path=path;
        }

    public int getRowCount(String sheetName) throws IOException {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        int index = workbook.getSheetIndex(sheetName);
        if(index==-1)
            return 0;
        else{
            sheet = workbook.getSheetAt(index);
            int number=sheet.getLastRowNum()+1;
            return number;
        }
    }


    public int getCellCount(String sheetName,int rownum) throws IOException
    {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        int cellcount=row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellcount;
    }


    public String getCellData(String sheetName,int rownum,int colnum) throws IOException
    {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();
        String data;
        try{
            data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
        }
        catch(Exception e)
        {
            data="";
        }
        workbook.close();
        fis.close();
        return data;
    }

    public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
    {
        File file=new File(path);
        if(!file.exists())    // If file not exists then create new file
        {
            workbook=new XSSFWorkbook();
            fos=new FileOutputStream(path);
            workbook.write(fos);
        }

        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);

        if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
            workbook.createSheet(sheetName);

        sheet=workbook.getSheet(sheetName);

        if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
            sheet.createRow(rownum);
        row=sheet.getRow(rownum);

        cell=row.createCell(colnum);
        cell.setCellValue(data);
        fos=new FileOutputStream(path);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }


    public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
    {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);

        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);

        style=workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }


    public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
    {
        fis=new FileInputStream(path);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);

        style=workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }



    public String[][] getDataFromSheet(String workbookLocation, String workSheetName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") + "/" + workbookLocation);
        XSSFSheet workSheet = workbook.getSheet(workSheetName);

        int noOfRows = workSheet.getLastRowNum() + 1;
        int noOfColumns = workSheet.getRow(0).getLastCellNum();
        String[][] dataTable = new String[noOfRows][noOfColumns];

        for (int i = workSheet.getFirstRowNum(); i < workSheet.getLastRowNum()+1; i++) {
            Row row = workSheet.getRow(i);
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                dataTable[i][j] = cell.getStringCellValue();
            }
        }

        workbook.close();
        return dataTable;
    }

}
