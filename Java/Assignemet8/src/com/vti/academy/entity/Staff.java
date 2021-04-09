package com.vti.academy.entity;

public class Staff<N> extends MyMap<N, String> {
	public Staff(N id, String name) {
		super(id, name);
	}

	public N getID() {

		return super.getKey();
	}

	public String getName() {

		return super.getValue();
	}
	
	
}
