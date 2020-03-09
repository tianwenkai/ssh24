package com.woniu.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.dao.UserDAO;
import com.woniu.pojo.User;
import com.woniu.service.UserService;
import com.woniu.tools.PageBean;

@Service // 被spring容器进行管理
@Transactional // 当前service类所有的方法切入事务处理的代码
public class UserServiceImpl implements UserService {
	//将dao层对象注入到service层中
	@Autowired
	UserDAO ud;
	//将dao层对象注入到service层中
	@Autowired
	SessionFactory sf;

	@Override
	public void save2(User u1, User u2) {
		// 获得session对象
		// openSession方法是新生成一个session对象
		// 这个session对象与dao中使用的session对象不是同一个
//		//getCurrentSession()可以确保每次获得session对象是同一个，该session对象不需要手动关闭
//		Session session = sf.getCurrentSession();
//		Transaction trans = session.beginTransaction();
//		try {
		ud.save(u1);
		// 如果运行中出现异常，那么异常运行内容会进行回滚
//			System.out.println(1/0);
		ud.save(u2);
//			trans.commit();
//		}catch(Exception e) {
//			trans.rollback();
//			//打印错误栈
//			e.printStackTrace();
//		}
	}

	@Override
	public void save(User obj) {
		// 这时，虽然没有在这添加事务代码，但是因为spring配置文件中，已经配置了事务管理器，本类也添加了@Transactional
		// 本类中所有的方法都已经添加事务代码
		ud.save(obj);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return ud.login(user);
	}

	@Override
	public List<User> findByPage(PageBean pageBean) {
		Integer countRow = ud.findAll().size();
		Integer countPage = countRow % pageBean.getPageRow() == 0 ? countRow / pageBean.getPageRow()
				: countRow / pageBean.getPageRow() + 1;
		pageBean.setCountRow(countRow);
		pageBean.setCountPage(countPage);
		List<User> userList = ud.findByPage(pageBean);
		return userList;
	}

	@Override
	public User findOne(int uid) {
		// TODO Auto-generated method stub
		return ud.findOne(uid);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		ud.update(user);
	}

}
