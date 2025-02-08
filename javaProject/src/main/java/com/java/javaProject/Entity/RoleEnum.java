package com.java.javaProject.Entity;

public enum RoleEnum {
	Admin(0, "Admin"), Müşteri(1, "Müşteri");

	private final int code;
	private final String description;

	RoleEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static RoleEnum fromCode(int code) {
		for (RoleEnum status : values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid RoleEnum code: " + code);
	}
}
