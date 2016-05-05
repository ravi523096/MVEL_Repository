package com.tiaa.mvelExpressionEval.dto;

public class MVELSparkRow {

	private SparkRow objSparkRow;

	public MVELSparkRow(SparkRow objSparkRowLocal) {
		objSparkRow = objSparkRowLocal;
	}

	public Integer getAge() {
		Integer intAge = null;
		String strAge = objSparkRow.getCol()[SparkRow.INDEX_AGE];
		if (null != strAge) {
			intAge = Integer.parseInt(strAge);
		}
		return intAge;
	}
	public Integer getWage() {
		Integer intWage = null;
		String strWage = objSparkRow.getCol()[SparkRow.INDEX_WAGE];
		if (null != strWage) {
			intWage = Integer.parseInt(strWage);
		}
		return intWage;
	}
	public String getHrSubarea() {
		String strHRSubarea = objSparkRow.getCol()[SparkRow.INDEX_HR_SUBAREA];
		return strHRSubarea;
	}
	public String getLocation() {
		String strLocation = objSparkRow.getCol()[SparkRow.INDEX_LOCATION];
		return strLocation;
	}
	public Integer getYos() {
		Integer intYos = null;
		String strYos = objSparkRow.getCol()[SparkRow.INDEX_YOS];
		if (null != strYos) {
			intYos = Integer.parseInt(strYos);
		}
		return intYos;
	}
	public Integer getDoh() {
		Integer intDoh = null;
		String strDoh = objSparkRow.getCol()[SparkRow.INDEX_DOH];
		if (null != strDoh) {
			intDoh = Integer.parseInt(strDoh);
		}
		return intDoh;
	}
	public Integer getAdjustedDoh() {
		Integer intAdjDoh = null;
		String strAdjDoh = objSparkRow.getCol()[SparkRow.INDEX_ADJUSTED_DOH];
		if (null != strAdjDoh) {
			intAdjDoh = Integer.parseInt(strAdjDoh);
		}
		return intAdjDoh;
	}
	public Float getCompensation() {
		Float fltCompensation = null;
		String strCompensation = objSparkRow.getCol()[SparkRow.INDEX_COMPENSATION];
		if (null != strCompensation) {
			fltCompensation = Float.parseFloat(strCompensation);
		}
		return fltCompensation;
	}
	public String getCountry() {
		String strCountry = objSparkRow.getCol()[SparkRow.INDEX_COUNTRY];
		return strCountry;
	}

	public String getPlan() {
		String strPlan = objSparkRow.getCol()[SparkRow.INDEX_PLAN];
		return strPlan;
	}

	@Override
	public String toString() {
		return "Age = " + getAge() + "; Wage = " + getWage() + "; HrSubarea = " + getHrSubarea() + "; Location = " + getLocation() + "; Yos = " + getYos() + "; Doh = " + getDoh() + "; AdjustedDoh = " + getAdjustedDoh() + "; Compensation = " + getCompensation() + "; Country = " + getCountry();
	}
}
