package com.pix.api.pixfacil.dto.paygo;

import java.io.Serializable;

public enum KeyEnum implements Serializable{
	RANDOM_KEY,
	EMAIL,
	DOCUMENT,
    PHONE;

    public String getStatus() {
        return this.name();
    }
	

}
