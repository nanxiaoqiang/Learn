package com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author nanxiaoqiang
 * 
 * @version 2016年9月28日
 */
@Entity
@Table(name = "test_sb_table")
public class TestTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5373027695522679153L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column(name = "short_name")
	private String shortName;

	public TestTable() {
	}

	public TestTable(String name, String shortName) {
		super();
		this.name = name;
		this.shortName = shortName;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
