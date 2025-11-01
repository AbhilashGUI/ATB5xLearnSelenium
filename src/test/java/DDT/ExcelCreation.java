package DDT;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelCreation {

    public static void main(String[] args) throws IOException {

        //Workbook
        //Sheet
        //Row, Cell
        //XSSFWorkbook
        //HSSFWorkbook

        Map<String, Object> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginId", "Email", "Password"});
        data.put("2", new Object[]{"1", "abhilash1@gmail.com", "Test123"});
        data.put("3", new Object[]{"2", "abhilash2@gmail.com", "Test123"});

        createExcel("CTD001.xlsx",data);
    }

    public static String createExcel(String name, Map data) throws IOException {

        Set<String> keyset = data.keySet();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        int rownum = 0;

        for (String key : keyset) {
            Row r = sheet.createRow(rownum++);
            Object[] objectA = (Object[]) data.get(key);

            int cellnum = 0;
            for (Object o : objectA) {
                Cell cell=r.createCell(cellnum++);
                cell.setCellValue((String) o);

            }

        }

        FileOutputStream fileOutputStream=new FileOutputStream(new File(name));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        return name;
    }
}
