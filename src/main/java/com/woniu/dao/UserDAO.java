package com.woniu.dao;

import java.util.List;

import com.woniu.pojo.User;
import com.woniu.tools.PageBean;

public interface UserDAO {
	void save(User obj);
	void update(User obj);
	void delete(User obj);
	User findOne(Integer id);
	List<User> findAll();
	User login(User user);
	List<User> findByPage(PageBean pageBean);
}
