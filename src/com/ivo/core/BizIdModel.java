package com.ivo.core;

import java.io.Serializable;

public class BizIdModel<T extends Serializable> extends ModelAtom {

	private T id;

	
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
}
