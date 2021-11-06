package com.eBanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
/*//create constructor to load the configuration file 
	create file object and pass the confi.properties file in the parameter
	then create fileinputstream object and pass the file object name in the parameter
	then create the properties object and using the properties object referance load the FIS referance.*/
	
	public ReadConfig() {
		File source = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(source);
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getApplicationURL() {
		String URL = prop.getProperty("baseURL");
		return URL;
	}

	public String getUserName() {
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String ChromePath = prop.getProperty("chromepath");
		return ChromePath;
	}

	public String getFirefoxPath() {
		String FirefoxPath = prop.getProperty("firefoxpath");
		return FirefoxPath;
	}
}
