package com.nanxiaoqiang.test.springboot.springboot_simple.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jpa.TestTable;

public interface JpaTestTableWithoutCacheDao extends JpaRepository<TestTable, Long> {

	@Override
	@SuppressWarnings("unchecked")
	public TestTable save(TestTable testTable);
}
