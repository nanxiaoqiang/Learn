package com.nanxiaoqiang.test.springboot.springboot_simple.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jpa.User;

public interface JpaUserRepository extends JpaRepository<User, Long> {

	public User findByNameIgnoreCase(String name);

	public List<User> findByNameLikeOrderByIdDesc(String name);
}
