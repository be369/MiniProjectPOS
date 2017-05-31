package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstProvinceDao;
import com.bootcamp.pos.model.MstProvinceModel;


@Repository
public class MstProvinceDaoImpl implements MstProvinceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstProvinceModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstProvinceModel> result = session.createQuery("from MstProvinceModel").list();
		return result;
	}

	@Override
	public List<MstProvinceModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstProvinceModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstProvinceModel> result = criteria.list();
		return result;
	}

	@Override
	public MstProvinceModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstProvinceModel result = session.get(MstProvinceModel.class, id);
		return result;
	}

	@Override
	public void insert(MstProvinceModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstProvinceModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstProvinceModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
