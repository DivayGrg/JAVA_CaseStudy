package Utility;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.File;
public class ExcelDataReader {
XSSFWorkbook wb;
public ExcelDataReader(){
	File src=new File("./TestData/TestData.xlsx");
	try {
		FileInputStream file =new FileInputStream(src);
		wb=new XSSFWorkbook(file);
	}catch(Exception e)
	{
		System.out.println("Unable to xlsx file "+e.getMessage());
	}
}
public String getStringData(int sheetIndex,int row,int column)
{
	return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
}
public String getStringData(String SheetName,int row,int column)
{
	return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
}
public double getNumericData(String SheetName,int row,int column)
{
	return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
}
}
