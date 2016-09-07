package com.stockgrabber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

public class Configuration {

	private static Properties properties;
	
	public static void saveConfig(String stocks, float period, String targetDir, boolean startRecording) {
		loadProperties();
		properties.setProperty("stocks", stocks);
		properties.setProperty("period", period+"");
		properties.setProperty("targetDir", targetDir);
		properties.setProperty("startRecording", Boolean.toString(startRecording));
		saveProperties();
	}
	public static void saveProxy(String proxy) {
		loadProperties();
		if(proxy!=null) {
			properties.setProperty("proxy", proxy);
		} else {
			properties.remove("proxy");
		}
		saveProperties();
	}
	public static String getProxy() {
		loadProperties();
		return properties.getProperty("proxy", null);
	}
	public static String getStocks() {
		loadProperties();
		String s = properties.getProperty("stocks", "");
		return s;
	}
	public static List<String> getStocksList() {
		List<String> l = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(getStocks(), ",");
		while(st.hasMoreTokens()) {
			l.add(st.nextToken().trim());
		}
		return l;
	}
	public static float getPeriod() {
		loadProperties();
		return Float.parseFloat(properties.getProperty("period", "1"));
	}
	public static boolean getStartRecording() {
		loadProperties();
		return Boolean.parseBoolean(properties.getProperty("startRecording", "false"));
	}
	public static String getTargetDir() {
		loadProperties();
		return properties.getProperty("targetDir");
	}
	private static void loadProperties() {
		try {
			InputStream is = new FileInputStream("/stockgrabber.properties");
			properties = new Properties();
			properties.load(is);
			is.close();
		} catch (Exception e) {
			properties = new Properties();
		}
	}
	private static void saveProperties() {
		try {
			File f = new File("/stockgrabber.properties");
			if(!f.exists()) {
				f.createNewFile();
			}
			OutputStream o = new FileOutputStream(f);
			if(properties==null) properties = new Properties();
			properties.store(o, "Preferences for stockgrabber");
			o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
