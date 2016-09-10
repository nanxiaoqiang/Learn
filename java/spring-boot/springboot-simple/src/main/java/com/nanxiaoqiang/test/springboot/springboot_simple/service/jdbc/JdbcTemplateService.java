package com.nanxiaoqiang.test.springboot.springboot_simple.service.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jdbc.User;

@Service
public class JdbcTemplateService {
//	@Resource
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("primaryjdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("secondryjdbcTemplate")
	private JdbcTemplate secondaryjdbcTemplate;

	public int saveUser(User user) {
		int count = jdbcTemplate.update("INSERT INTO test_sb_user(name, remark) VALUES (?, ?)", user.getName(),
				user.getRemark());
		return count;
	}

	public List<User> getAllUser() {
		List<User> list = jdbcTemplate.query("SELECT id, name, remark FROM test_sb_user", new UserMapper());
		return list;
	}

	public User findById(Long id) {
		User user = jdbcTemplate.queryForObject("SELECT id, name, remark FROM test_sb_user WHERE id = ?",
				new UserMapper(), id);
		return user;
	}

	public int removeAll() {
		int count = jdbcTemplate.update("DELETE FROM test_sb_user");
		return count;
	}

	public int deleteByName(String name) {
		int count = jdbcTemplate.update("DELETE FROM test_sb_user WHERE name = ?", name);
		return count;
	}

	private static final class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setRemark(rs.getString("remark"));
			return user;
		}

	}
}
