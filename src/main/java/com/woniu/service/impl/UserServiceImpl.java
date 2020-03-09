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

@Service // ��spring�������й���
@Transactional // ��ǰservice�����еķ�������������Ĵ���
public class UserServiceImpl implements UserService {
	//��dao�����ע�뵽service����
	@Autowired
	UserDAO ud;
	//��dao�����ע�뵽service����
	@Autowired
	SessionFactory sf;

	@Override
	public void save2(User u1, User u2) {
		// ���session����
		// openSession������������һ��session����
		// ���session������dao��ʹ�õ�session������ͬһ��
//		//getCurrentSession()����ȷ��ÿ�λ��session������ͬһ������session������Ҫ�ֶ��ر�
//		Session session = sf.getCurrentSession();
//		Transaction trans = session.beginTransaction();
//		try {
		ud.save(u1);
		// ��������г����쳣����ô�쳣�������ݻ���лع�
//			System.out.println(1/0);
		ud.save(u2);
//			trans.commit();
//		}catch(Exception e) {
//			trans.rollback();
//			//��ӡ����ջ
//			e.printStackTrace();
//		}
	}

	@Override
	public void save(User obj) {
		// ��ʱ����Ȼû���������������룬������Ϊspring�����ļ��У��Ѿ����������������������Ҳ�����@Transactional
		// ���������еķ������Ѿ�����������
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
