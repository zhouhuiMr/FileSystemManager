package com.resources.init;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.Application;

@Component
public class CommonResources {
	private final static String CONFIGFILE = "config.properties"; 
	public static String HADOOP_HDFS_ADDRESS = "";
	
	public CommonResources() {
		initResource();
	}
	
	private void initResource(){
		InputStream in = Application.class.getResourceAsStream("../"+CONFIGFILE);
		Properties properties = new Properties();
		try {
			properties.load(in);
			HADOOP_HDFS_ADDRESS = properties.getProperty("HADOOP_HDFS_ADDRESS");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
