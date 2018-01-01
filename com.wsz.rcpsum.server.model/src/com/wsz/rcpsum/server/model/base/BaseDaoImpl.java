package com.wsz.rcpsum.server.model.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.wsz.rcpsum.server.model.util.HibernateUtil;

public class BaseDaoImpl implements IBaseDao {

	@Override
	public Object getObjById(Class<?> obj, Object id) {
		return getSession().get(obj, (Serializable) id);
	}

	@Override
	public List findList(String hql, Object... values) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (null != values && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	@Override
	public List findListByIds(String hql, Object... ids) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (ids != null && ids.length > 0) {
			query.setParameterList("ids", ids);
		}
		return query.list();
	}

	public List findListForPageBySql(String sql, Integer offset, Integer length, Object... values) {
		Session session = getSession();
		SQLQuery query = session.createSQLQuery(sql);

		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		if (offset != null && length != null) {
			query.setMaxResults(length);
			query.setFirstResult(offset);
		}
		return query.list();
	}

	public List findListBySql(String sql, Object... values) {
		Session session = getSession();
		SQLQuery query = session.createSQLQuery(sql);

		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query.list();
	}

	@Override
	public Serializable save(Object obj) {
		return getSession().save(obj);
	}

	@Override
	public void update(Object obj) {
		getSession().update(obj);
	}

	@Override
	public void saveOrUpdate(Object obj) {
		getSession().saveOrUpdate(obj);
	}

	@Override
	public void delete(Object obj) {
		getSession().delete(obj);
	}

	protected Session getSession() {
		return HibernateUtil.getSessoin();
	}

	@Override
	public void executeByIds(String hql, Object[] ids, Object... parms) {
		Query query = getSession().createQuery(hql);
		if (ids != null && ids.length > 0) {
			query.setParameterList("ids", ids);
		}
		if (parms != null && parms.length > 0) {
			for (int j = 0; j < parms.length; j++) {
				query.setParameter(j, parms[j]);
			}
		}
		query.executeUpdate();
	}

	public void executeByParms(String hql, Object... parms) {
		Query query = getSession().createQuery(hql);
		if (parms != null && parms.length > 0) {
			for (int j = 0; j < parms.length; j++) {
				query.setParameter(j, parms[j]);
			}
		}
		query.executeUpdate();
	}
}
