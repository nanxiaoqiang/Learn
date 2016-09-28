package com.nanxiaoqiang.test.springboot.springboot_simple.jpa;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.nanxiaoqiang.test.springboot.springboot_simple.App;
import com.nanxiaoqiang.test.springboot.springboot_simple.dao.jpa.JpaTestTableWithoutCacheDao;
import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jpa.TestTable;

//@RunWith(SpringRunner.class)
//@SpringBootTest

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class JpaTransactioalTest {
	private static Logger logger = LogManager.getLogger(JpaTransactioalTest.class.getName());

	public JpaTransactioalTest() {
	}
	
	@Resource
	private JpaTestTableWithoutCacheDao dao;
	
	@Test
	public void test2() {// 测试会false
		dao.save(new TestTable("name0", "sname0"));
		dao.save(new TestTable("name1", "sname1"));
		dao.save(new TestTable("name2", "sname2"));
		dao.save(new TestTable("name3", "sname3xxxxx"));// 这行会报错，然后录入三行数据
		dao.save(new TestTable("name4", "sname4"));
		dao.save(new TestTable("name5", "sname5"));
	}
	
	@Test
	@Transactional
	public void test3() {// 会false
		dao.save(new TestTable("name0", "sname0"));
		dao.save(new TestTable("name1", "sname1"));
		dao.save(new TestTable("name2", "sname2"));
		dao.save(new TestTable("name3", "sname3xxxxx"));// 这行会报错，但是加入了事务，所以数据库里没有数据
		dao.save(new TestTable("name4", "sname4"));
		dao.save(new TestTable("name5", "sname5"));
	}
	
	@Test
	@Transactional
	@Rollback// 测试完之后，数据全部会回滚哦。
	public void test1() {

		List<TestTable> list1 = dao.findAll();
		int size = list1 == null ? 0 : list1.size();
		dao.save(new TestTable("name0", "s1"));
		dao.save(new TestTable("name1", "s2"));
		dao.save(new TestTable("name2", "s2"));
		dao.save(new TestTable("name3", "s4"));
		dao.save(new TestTable("name4", "s5"));
		dao.save(new TestTable("name5", "s6"));
		
		List<TestTable> list = dao.findAll();
		logger.info("getList size: " + list.size());
		Assert.isTrue(list.size() == (size + 6));
	}

}
