package model;

import java.time.LocalDate;
import java.util.Date;

public class DetailsBean {
	private int contact_id;
	private String CFIRST_NAME;
	private String CLAST_NAME;
	private String CPHONE;
	private String CEMAIL;
	private LocalDate DOB;
	private String SOCIALPROFILE;
	private String USEREMAIL;
	
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getCFIRST_NAME() {
		return CFIRST_NAME;
	}
	public void setCFIRST_NAME(String cFIRST_NAME) {
		CFIRST_NAME = cFIRST_NAME;
	}
	public String getCLAST_NAME() {
		return CLAST_NAME;
	}
	public void setCLAST_NAME(String cLAST_NAME) {
		CLAST_NAME = cLAST_NAME;
	}
	public String getCPHONE() {
		return CPHONE;
	}
	public void setCPHONE(String cPHONE) {
		CPHONE = cPHONE;
	}
	public String getCEMAIL() {
		return CEMAIL;
	}
	public void setCEMAIL(String cEMAIL) {
		CEMAIL = cEMAIL;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public String getSOCIALPROFILE() {
		return SOCIALPROFILE;
	}
	public void setSOCIALPROFILE(String sOCIALPROFILE) {
		SOCIALPROFILE = sOCIALPROFILE;
	}
	public String getUSEREMAIL() {
		return USEREMAIL;
	}
	public void setUSEREMAIL(String uSEREMAIL) {
		USEREMAIL = uSEREMAIL;
	}	
}
