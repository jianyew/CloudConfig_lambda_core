package com.jw.demo.common._enum;

import java.util.HashMap;
import java.util.Map;

public enum AppStatusEnum {

	/**
	 * 正常
	 */
	NORMAL(1, "正常"),
	/**
	 * 停用
	 */
	STOP(2, "停用"),
	/**
	 * 已注销/已删除
	 */
	DELETE(3, "已删除");

	private int id;
	private String name;

	AppStatusEnum(int id, String name) {
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
		AppStatusEnum[] enums = values();
		for (AppStatusEnum object : enums) {
			typesMap.put(object.getId(), object.getName());
		}
		return typesMap;
	}
}
