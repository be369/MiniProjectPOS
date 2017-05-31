package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstDistrictDao;
import com.bootcamp.pos.model.MstDistrictModel;

@Repository
public class MstDistrictDaoImpl implements MstDistrictDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstDistrictModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstDistrictModel> result = session.createQuery("from MstDistrictModel").list();
		return result;
	}
	
	@Override
	public List<MstDistrictModel> getByRegion(int regionId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstDistrictModel.class);
		criteria.add(Restrictions.eq("regionId",regionId));
		List<MstDistrictModel> result = criteria.list();
		return result;
	}

	@Override
	public List<MstDistrictModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstDistrictModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstDistrictModel> result = criteria.list();
		return result;
	}

	@Override
	public MstDistrictModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstDistrictModel result = session.get(MstDistrictModel.class, id);
		return result;
	}

	@Override
	public void insert(MstDistrictModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstDistrictModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstDistrictModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
