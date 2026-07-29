package Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
    XSSFWorkbook wb;

    public ExcelDataProvider() {
        File src = new File("./TestData/Data.xlsx"); 
        try {
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("Unable to read Excel File: " + 
        e.getMessage());
        }
    }

    // Using DataFormatter to safely read numeric and string values
    public String getCellData(String sheetName, int row, int column) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(wb.getSheet(sheetName).
        		getRow(row).getCell(column));
    }
}