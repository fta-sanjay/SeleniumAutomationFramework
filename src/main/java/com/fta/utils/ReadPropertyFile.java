package com.fta.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
	
	private ReadPropertyFile() {};
	
	public static String getValue(String key)
	{
		FileInputStream fis;
		Properties properties = null;
		String value="";
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
		    properties=new Properties();
			properties.load(fis);
			value=properties.getProperty(key);
			if(Objects.isNull(value))
			{
				throw new Exception("property name "+key+" is not found. please check the config.properties");
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace(); 
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
