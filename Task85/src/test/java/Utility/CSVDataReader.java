package Utility;

import java.io.FileReader;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class CSVDataReader {
    
    // Added 'String fileName' so the test can tell it which file to open
    public static List<String[]> readCsvData(String fileName) throws Exception {
        // Now it dynamically points to whichever file you pass in
        String csvPath = "./TestData/" + fileName; 
        
        CSVReader reader = new CSVReader(new FileReader(csvPath)); 
        
        List<String[]> allData = reader.readAll();
        reader.close();
        
        if (allData.size() > 0) {
            allData.remove(0);
        }
        
        return allData;
    }
}