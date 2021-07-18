package com.higradius;

import java.sql.Date;

public class Response {
	private String invoice_iD;
	private Date due_date;
	private Date Clear_date;
	private String Customer_ID;
	private float  Amount;
	private String Customer_name;
	private String Notes;
	
	
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public Date getClear_date() {
		return Clear_date;
	}
	public void setClear_date(Date clear_date) {
		Clear_date = clear_date;
	}
	
	public String getInvoice_iD() {
		return invoice_iD;
	}
	public void setInvoice_iD(String invoice_iD) {
		this.invoice_iD = invoice_iD;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}

	public String getCustomer_ID() {
		return Customer_ID;
	}
	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}

	

}

