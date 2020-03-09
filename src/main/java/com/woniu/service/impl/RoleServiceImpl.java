package com.woniu.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.dao.RoleDAO;
import com.woniu.pojo.Role;
import com.woniu.service.RoleService;
@Service //��spring�������й���
@Transactional //��ǰservice�����еķ�������������Ĵ���
public class RoleServiceImpl implements RoleService {
	//��dao�����ע�뵽service����
	@Autowired
	RoleDAO rd;
	//��dao�����ע�뵽service����
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
