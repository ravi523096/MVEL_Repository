package com.tiaa.mvelExpressionEval.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.mvel2.MVEL;

import com.tiaa.mvelExpressionEval.dto.MVELSparkRow;
import com.tiaa.mvelExpressionEval.dto.SparkRow;

/**
 * Hello world!
 *
 */
public class MVEL_CalculateEligibility {
	private static final String strPropertiesFileName = "C:/Users/ravi2/Google Drive/PrivateProjects/MVELExpressionEval/src/main/resources/eligibility.properties";
	public static String strClient = "0112233";
    private static SparkRow[] stubSparkRows() {
    	SparkRow[] arrSparkRow = new SparkRow[10];

    	arrSparkRow[0] = new SparkRow("20", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[1] = new SparkRow("21", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[2] = new SparkRow("22", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[3] = new SparkRow("23", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[4] = new SparkRow("24", "20000", "HrSubArea5", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[5] = new SparkRow("25", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[6] = new SparkRow("26", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[7] = new SparkRow("27", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[8] = new SparkRow("28", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	arrSparkRow[9] = new SparkRow("29", "20000", "HrSubArea1", "Location1", "20", "20060101", "20060201", "20000.1", "USA", "A");
    	return arrSparkRow;
	}

    public static void main( String[] args ) {
    	System.out.println("Start : MVEL_CalculateEligibility.main(...)");
    	SparkRow[] arrSparkRow;
    	MVELSparkRow objMVELSparkRow;
    	Map<String, MVELSparkRow> mapMVELVars = new HashMap<String, MVELSparkRow>();

    	arrSparkRow = stubSparkRows();
    	Map<String, Serializable> mapProperties = getPropertiesMap(strPropertiesFileName);

    	for (SparkRow objSparkRow : arrSparkRow) {
    		objMVELSparkRow = new MVELSparkRow(objSparkRow);
    		mapMVELVars.put("row", objMVELSparkRow);
	    	for (Map.Entry<String, Serializable> entryProperties : mapProperties.entrySet()) {
	    		if (isComparableExpression(strClient, objMVELSparkRow.getPlan(), entryProperties.getKey())) {
		    		Boolean result = (Boolean) MVEL.executeExpression(entryProperties.getValue(), mapMVELVars);
		    		System.out.println(entryProperties.getKey() + " : " + result + " : " + objMVELSparkRow);
	    		}
	    	}
    	}
    	System.out.println("End : MVEL_CalculateEligibility.main(...)");
    }
	public static Map<String, Serializable> getPropertiesMap(String strPropertyFileName) {
    	Properties prop = new Properties();
    	InputStream input = null;

    	String strKey = null;
    	Map<String, Serializable> mapProperties = new HashMap<String, Serializable>();

    	try {
    		input = new FileInputStream(strPropertyFileName);

    		// load a properties file
    		prop.load(input);

    		Set<Object> keySet = prop.keySet();
    		Iterator<Object> iterator = keySet.iterator();
    		while(iterator.hasNext()) {
    			strKey = (String) iterator.next();
    			mapProperties.put(strKey, MVEL.compileExpression(prop.getProperty(strKey)));
    		}
    	} catch (IOException ex) {
    		System.out.println("50 : App.getPropertiesMap(...) : " + ex);
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				System.out.println("56 : App.getPropertiesMap(...) : " + e);
    			}
    		}
    	}
		return mapProperties;
    }
	private static boolean isComparableExpression(String strClient, String strPlan, String strPropertyKey) {
		String[] arrPropKey = strPropertyKey.split("\\.");
		if (arrPropKey[0].equals(strClient) && arrPropKey[1].equals(strPlan))
			return true;
		return false;
	}
}
