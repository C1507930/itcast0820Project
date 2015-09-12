package com.ivo.core;

import java.io.Serializable;

public abstract class ModelAtom implements Serializable {
	
	private Integer valid;

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}
	
	
}
