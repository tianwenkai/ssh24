package com.woniu.dao;

import java.util.List;

import com.woniu.pojo.Role;

public interface RoleDAO {
	void save(Role obj);
	void update(Role obj);
	void delete(Role obj);
	Role findOne(Integer id);
	List<Role> findAll();
}
