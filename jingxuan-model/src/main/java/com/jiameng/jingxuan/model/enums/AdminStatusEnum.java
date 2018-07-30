package com.jiameng.jingxuan.model.enums;

public enum AdminStatusEnum {
	DISABLED(0),
	ENABLE(1),
	DEFAULT(-1);
	
	private int value;
	
	private AdminStatusEnum(int value) {
		this.value = value;
	}
	
	public int value() {
		return this.value;
	}
}
