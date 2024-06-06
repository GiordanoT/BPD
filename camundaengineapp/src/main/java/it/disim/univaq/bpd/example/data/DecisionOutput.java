package it.disim.univaq.bpd.example.data;

import java.io.Serializable;

public class DecisionOutput implements Serializable {
	private static final long serialVersionUID = 1L;
	public String accountHolder;
	public String invoiceNumber;
	public float amountDue;
	public String status;
	
	public DecisionOutput(String accountHolder, String invoiceNumber, String amountDue, String status) {
		this.accountHolder = accountHolder.replaceAll("\"", "");
		this.invoiceNumber = invoiceNumber.replaceAll("\"", "");
		this.amountDue = Float.parseFloat(amountDue.replaceAll("\"", ""));
		this.status = status;
	}
	
	public DecisionOutput() {}
	
	public String toString() {
   		String data = "Account Holder: " + this.accountHolder + "\n"
			+ "Invoice Number: " + this.invoiceNumber + "\n"
			+ "Amount Due: " + this.amountDue + "\n";
   		return data;
	}
}
