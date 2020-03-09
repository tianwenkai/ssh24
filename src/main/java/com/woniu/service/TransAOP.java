package com.woniu.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
//@Aspect //��Ӧ��spring�����ļ������������Զ�����<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class TransAOP {
	@Autowired
	private SessionFactory sf;
	@Around("execution(* com.woniu.service.impl..*.*(..))")
	public Object around(ProceedingJoinPoint pjp) {
		Object obj = null;
		Session session = sf.getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
			obj = pjp.proceed();
			trans.commit();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			trans.rollback();
		}
		return obj;
	}
}
