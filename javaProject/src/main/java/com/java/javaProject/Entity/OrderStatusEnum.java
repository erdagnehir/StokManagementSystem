package com.java.javaProject.Entity;

public enum OrderStatusEnum {

	Bekliyor(0, "Bekliyor"), Onaylandi(1, "Sipariş Onaylandi"), Reddedildi(2, "Sipariş Reddedildi"), Iptal(3, "Sipariş İptal Edildi");

	private final int code;
	private final String description;

	OrderStatusEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static OrderStatusEnum fromCode(int code) {
		for (OrderStatusEnum status : values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code: " + code);
	}
}