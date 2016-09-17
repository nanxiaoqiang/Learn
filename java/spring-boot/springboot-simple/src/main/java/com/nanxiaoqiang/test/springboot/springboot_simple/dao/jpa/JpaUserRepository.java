package com.nanxiaoqiang.test.springboot.springboot_simple.dao.jpa;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nanxiaoqiang.test.springboot.springboot_simple.domain.account.jpa.User;

@CacheConfig(cacheNames = "users")
public interface JpaUserRepository extends JpaRepository<User, Long> {

	public User findByNameIgnoreCase(String name);

	public List<User> findByNameLikeOrderByIdDesc(String name);

	@Cacheable(key = "#p0")
	public User findByName(String name);

	public User findById(Long id);

	@Override
	@SuppressWarnings("unchecked")
	@CachePut(key = "#p0.name")// 不能使用id
	public User save(User user);// 只把新key的做了更新，旧的Key没有删除

	@Override
	@CacheEvict(key = "#p0.name")// 不对，未能删除
	public void delete(User user);
}
