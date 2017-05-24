package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstCategoryDao;
import com.bootcamp.pos.model.MstCategoryModel;



@Repository
public class MstCategoryDaoImpl implements MstCategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstCategoryModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstCategoryModel> result = session.createQuery("from MstCategoryModel").list();
		return result;
	}

	@Override
	public List<MstCategoryModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstCategoryModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstCategoryModel> result = criteria.list();
		return result;
	}

	@Override
	public MstCategoryModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstCategoryModel result = session.get(MstCategoryModel.class, id);
		return result;
	}

	@Override
	public void insert(MstCategoryModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstCategoryModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstCategoryModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
