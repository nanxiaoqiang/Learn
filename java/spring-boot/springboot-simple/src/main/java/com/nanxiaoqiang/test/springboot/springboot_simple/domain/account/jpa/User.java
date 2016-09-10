package com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_sb_user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7767817388275253452L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = true)
	private String name;

	@Column
	private String remark;

	public User() {
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
