package com.wsz.rcpsum.server.model.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 
 * @author wsz 2017-11-8
 * 
 */
public class HibernateUtil {
	public static final ThreadLocal sessionThread = new ThreadLocal();
	public static SessionFactory sessionFactory;
	public static Configuration sessionConfig;

	static {
		try {
			sessionConfig = new Configuration().configure("/hibernate.cfg.xml");

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(sessionConfig.getProperties())
					.buildServiceRegistry();
			
			sessionFactory = sessionConfig.buildSessionFactory(serviceRegistry);
		} catch (Throwable t) {
			throw new ExceptionInInitializerError(t);
		}
	}
	
	/**
	 * 获取当前的Session
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public static Session getSessoin() throws HibernateException {
		Session session = (Session) sessionThread.get();
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
			sessionThread.set(session);
		}
		return session;
	}
	
	/**
	 * 释放Session
	 * 
	 * @throws HibernateException
	 */
	public static void closeSession() throws HibernateException {
		Session session = (Session) sessionThread.get();
		if (session != null) {
			session.close();
		}

		sessionThread.set(null);
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	public static void clearSession() {
		getSessoin().clear();
	}
}
