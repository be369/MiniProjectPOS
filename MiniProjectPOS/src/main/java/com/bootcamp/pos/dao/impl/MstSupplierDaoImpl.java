package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstSupplierDao;
import com.bootcamp.pos.model.MstSupplierModel;

@Repository
public class MstSupplierDaoImpl implements MstSupplierDao {

	@Autowired private SessionFactory sessionFactory;
	
	@Override
	public List<MstSupplierModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstSupplierModel> result = session.createQuery("from MstSupplierModel").list();
		return result;
	}

	@Override
	public List<MstSupplierModel> search(String keySearch) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstSupplierModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstSupplierModel> result = criteria.list();
		return result;
	}

	@Override
	public MstSupplierModel getById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstSupplierModel result = session.get(MstSupplierModel.class, id);
		return result;
	}

	@Override
	public void insert(MstSupplierModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstSupplierModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstSupplierModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
