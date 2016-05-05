package com.tiaa.mvelExpressionEval.dto;

public class SparkRow {
	private String[] col = new String[300];

	public static final int INDEX_AGE = 0;
	public static final int INDEX_WAGE = 1;
	public static final int INDEX_HR_SUBAREA = 2;
	public static final int INDEX_LOCATION = 3;
	public static final int INDEX_YOS = 4;
	public static final int INDEX_DOH = 5;
	public static final int INDEX_ADJUSTED_DOH = 6;
	public static final int INDEX_COMPENSATION = 7;
	public static final int INDEX_COUNTRY = 8;
	public static final int INDEX_PLAN = 9;

	public SparkRow(String age, String wage, String hrSubarea, String location, String yos, String doh, String adjustedDoh, String compensation, String country, String plan) {
		col[0]= age;
		col[1]= wage;
		col[2]= hrSubarea;
		col[3]= location;
		col[4]= yos;
		col[5]= doh;
		col[6]= adjustedDoh;
		col[7]= compensation;
		col[8]= country;
		col[9]= plan;
	}

	public String[] getCol() {
		return col;
	}
	public void setCol(String[] col) {
		this.col = col;
	}
}
