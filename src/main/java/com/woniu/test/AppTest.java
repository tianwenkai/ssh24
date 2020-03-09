package com.woniu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.dao.UserDAO;
import com.woniu.pojo.Role;
import com.woniu.pojo.User;
import com.woniu.service.UserService;

public class AppTest {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO ud = (UserDAO) ac.getBean("userDAOImpl");
		User user = new User();
		user.setUname("twk123");
		user.setUpwd("123");
		Role role = new Role();
		role.setRid(1);
		user.setRole(role);
		ud.save(user);
		
	}
	
	@SuppressWarnings("resource")
	@Test
	public void testService() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService) ac.getBean("userServiceImpl");
		User user = new User();
		user.setUname("ddd");
		user.setUpwd("123");
		Role role = new Role();
		role.setRid(1);
		user.setRole(role);
		
		User user2 = new User();
		user2.setUname("eee");
		user2.setUpwd("222");
		Role role2 = new Role();
		role2.setRid(1);
		user2.setRole(role);
		
		us.save2(user, user2);
		
	}

}
