package com.jw.demo.common._enum;

import java.util.HashMap;
import java.util.Map;

public enum DeletedEnum {

	/**
	 * 否（未删除）
	 */
	F(0, "否"),
	/**
	 * 是（已删除）
	 */
	T(1, "是");

	private int id;
	private String name;

	DeletedEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Map<Integer, String> listAllTypes() {
		Map<Integer, String> typesMap = new HashMap<Integer, String>();
		DeletedEnum[] enums = values();
		for (DeletedEnum object : enums) {
			typesMap.put(object.getId(), object.getName());
		}
		return typesMap;
	}
}
