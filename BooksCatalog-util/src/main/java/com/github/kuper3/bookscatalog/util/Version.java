package com.github.kuper3.bookscatalog.util;

import java.util.ResourceBundle;

/**
 * Class used to read the project version from a maven filtered resource bundle. 
 */
public class Version {
	
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle("BooksCatalog-util");
	
	public static String VALUE = BUNDLE.getString("version"); 
}
