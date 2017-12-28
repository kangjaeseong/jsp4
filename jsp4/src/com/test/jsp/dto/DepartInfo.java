package com.test.jsp.dto;

public class DepartInfo {
	private int diNo;
	private String diName;
	private String diEtc;

	public int getDiNo() {
		return diNo;
	}

	public void setDiNo(int diNo) {
		this.diNo = diNo;
	}

	public String getDiName() {
		return diName;
	}

	public void setDiName(String diName) {
		this.diName = diName;
	}

	public String getDiEtc() {
		return diEtc;
	}

	public void setDiEtc(String diEtc) {
		this.diEtc = diEtc;
	}

	@Override
	public String toString() {
		return "DepartInfo [diNo=" + diNo + ", diName=" + diName + ", diEtc=" + diEtc + "]";
	}

}