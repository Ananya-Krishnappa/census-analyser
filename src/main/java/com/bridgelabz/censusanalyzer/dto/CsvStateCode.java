package com.bridgelabz.censusanalyzer.dto;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCode {

	@CsvBindByName(column = "SrNo", required = true)
	private String srNo;

	@CsvBindByName(column = "StateName")
	private String stateName;

	@CsvBindByName(column = "TIN")
	private String tin;

	@CsvBindByName(column = "StateCode")
	private String stateCode;

	public CsvStateCode(String srNo, String stateName, String tin, String stateCode) {
		super();
		this.srNo = srNo;
		this.stateName = stateName;
		this.tin = tin;
		this.stateCode = stateCode;
	}

	public CsvStateCode() {
		super();
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "CsvStateCode [srNo=" + srNo + ", stateName=" + stateName + ", tin=" + tin + ", stateCode=" + stateCode
				+ "]";
	}
}
