package com.woniu.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.dao.RoleDAO;
import com.woniu.pojo.Role;
import com.woniu.service.RoleService;
@Service //被spring容器进行管理
@Transactional //当前service类所有的方法切入事务处理的代码
public class RoleServiceImpl implements RoleService {
	//将dao层对象注入到service层中
	@Autowired
	RoleDAO rd;
	//将dao层对象注入到service层中
	@Autowired
	SessionFactory sf;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rd.findAll();
	}
	@Override
	public Role findOne(int rid) {
		// TODO Auto-generated method stub
		return rd.findOne(rid);
	}

}
