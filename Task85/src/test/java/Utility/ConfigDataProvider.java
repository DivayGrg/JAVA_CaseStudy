package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
    Properties pro;
    
    public ConfigDataProvider() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch(Exception e) {
            System.out.println("Unable to load Properties file: " + e.getMessage());
        }
    }
    
    public String getBrowser() { 
        return pro.getProperty("Browser"); 
    }
    
    // Now it takes the specific name of the URL you want!
    public String getUrl(String keyName) { 
        return pro.getProperty(keyName); 
    }
}
