package com.example.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigReaderWriter {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static void setProperty(String value) {
    	String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
    	String key = "Order_"+timeStamp;
    	try (FileOutputStream fos = new FileOutputStream("src/test/resources/config.properties")) {
    		properties.setProperty(key, value);
    		properties.store(fos,"added via ConfigReaderWriter");
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
}