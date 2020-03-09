package com.woniu.service;

import java.util.List;

import com.woniu.pojo.User;
import com.woniu.tools.PageBean;

public interface UserService {
	void save2(User u1,User u2);
	void save(User obj);
	User login(User user);
	List<User> findByPage(PageBean pageBean);
	User findOne(int uid);
	void update(User user);
}
