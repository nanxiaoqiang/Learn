package com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jdbc;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1209499812605422396L;

	private Long id;
	private String name;
	private String remark;

	public User() {
		super();
	}

	public User(String name, String remark) {
		super();
		this.name = name;
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
