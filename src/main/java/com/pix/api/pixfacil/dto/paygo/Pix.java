package com.pix.api.pixfacil.dto.paygo;

import java.util.Date;

public class Pix {
	
    public String provider;
    public String[] key;
    public Date expirationDateTime;
    public Payer payer;
    public String qrCode;
    
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public Date getExpirationDateTime() {
		return expirationDateTime;
	}
	public void setExpirationDateTime(Date expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}
	public Payer getPayer() {
		return payer;
	}
	public void setPayer(Payer payer) {
		this.payer = payer;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public String[] getKey() {
		return key;
	}
	public void setKey(String[] key) {
		this.key = key;
	}
	
}

