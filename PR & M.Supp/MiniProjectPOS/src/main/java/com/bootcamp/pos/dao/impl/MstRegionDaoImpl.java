package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstRegionDao;
import com.bootcamp.pos.model.MstRegionModel;

@Repository
public class MstRegionDaoImpl implements MstRegionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstRegionModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstRegionModel> result = session.createQuery("from MstRegionModel").list();
		return result;
	}
	
	@Override
	public List<MstRegionModel> getByProvince(int provinceId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstRegionModel.class);
		criteria.add(Restrictions.eq("provinceId",provinceId));
		List<MstRegionModel> result = criteria.list();
		return result;
	}

	@Override
	public List<MstRegionModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstRegionModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstRegionModel> result = criteria.list();
		return result;
	}

	@Override
	public MstRegionModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstRegionModel result = session.get(MstRegionModel.class, id);
		return result;
	}

	@Override
	public void insert(MstRegionModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstRegionModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstRegionModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
