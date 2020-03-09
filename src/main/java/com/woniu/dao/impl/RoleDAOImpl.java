package com.woniu.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.dao.RoleDAO;
import com.woniu.pojo.Role;

//dao实例被spring容器进行管理
@Repository
public class RoleDAOImpl implements RoleDAO {
	// SessionFactory通过spring注入进来
	@Autowired
	private SessionFactory sf;

	public Session getSession() {
		return sf.openSession();
	}

	@Override
	public void save(Role obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Role obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Role obj) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	@Override
	public Role findOne(Integer id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Criteria createCriteria = session.createCriteria(Role.class);
		createCriteria.add(Restrictions.eq("rid",id));
		Role role = (Role) createCriteria.uniqueResult();
		session.close();
		return role;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Criteria createCriteria = session.createCriteria(Role.class);
		List<Role> roleList = createCriteria.list();
		session.close();
		return roleList;
	}

}
