package com.pix.api.pixfacil.dto.paygo;

import java.util.Date;

public class PayGoTransaction {
	
    public String transactionId;
    public String referenceId;
    public String description;
    public int integrationType;
    public String amount;
    public int status;
    public Date dtTransaction;
    public String postBackUrl;
    public Payment payment;
    
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIntegrationType() {
		return integrationType;
	}
	public void setIntegrationType(int integrationType) {
		this.integrationType = integrationType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDtTransaction() {
		return dtTransaction;
	}
	public void setDtTransaction(Date dtTransaction) {
		this.dtTransaction = dtTransaction;
	}
	public String getPostBackUrl() {
		return postBackUrl;
	}
	public void setPostBackUrl(String postBackUrl) {
		this.postBackUrl = postBackUrl;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
    
}

