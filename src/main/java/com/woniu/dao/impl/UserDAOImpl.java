package com.woniu.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.dao.UserDAO;
import com.woniu.pojo.User;
import com.woniu.tools.PageBean;
//dao实例被spring容器进行管理
@Repository
public class UserDAOImpl implements UserDAO {
	//SessionFactory通过spring注入进来
	@Autowired
	private SessionFactory sf;
	
	public Session getSession() {
		return sf.openSession();
	}
	@Override
	public void save(User obj) {
		Session s = getSession();
		s.beginTransaction();
		s.save(obj);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void update(User obj) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	@Override
	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Criteria createCriteria = session.createCriteria(User.class);
		createCriteria.add(Restrictions.eq("uid", id));
		User user = (User) createCriteria.uniqueResult();
		session.close();
		return user;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<User> findAll() {
		Session session = this.getSession();
		Criteria createCriteria = session.createCriteria(User.class);
		List<User> userList = createCriteria.list();
		return userList;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Criteria createCriteria = session.createCriteria(User.class);
		createCriteria.add(Restrictions.eq("uname", user.getUname()));
		createCriteria.add(Restrictions.eq("upwd", user.getUpwd()));
		User u=(User) createCriteria.uniqueResult();
		return u;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<User> findByPage(PageBean pageBean) {
		Session session = this.getSession();
		Criteria createCriteria = session.createCriteria(User.class);
		//添加分页功能
		createCriteria.setFirstResult((pageBean.getNowPage()-1)*pageBean.getPageRow());
		createCriteria.setMaxResults(pageBean.getPageRow());
		List<User> userList = createCriteria.list();
		return userList;
	}

}
