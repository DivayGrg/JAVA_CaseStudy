package Utility;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
public class CSVDataReader {
CSVReader reader;
public CSVDataReader(String CsvPath) throws FileNotFoundException{
	reader=new CSVReader(new FileReader (CsvPath));
}
public void readData()
{
	String Name=;
}
}