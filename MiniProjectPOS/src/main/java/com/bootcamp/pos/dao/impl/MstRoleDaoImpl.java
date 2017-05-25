package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstRoleDao;
import com.bootcamp.pos.model.MstRoleModel;

@Repository
public class MstRoleDaoImpl implements MstRoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstRoleModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstRoleModel> result = session.createQuery("from MstRoleModel").list();
		return result;
	}

	@Override
	public List<MstRoleModel> search(String keySearch) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstRoleModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstRoleModel> result = criteria.list();
		return result;
	}

	@Override
	public MstRoleModel getById(Long id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstRoleModel result = session.get(MstRoleModel.class, id);
		return result;
	}

	@Override
	public void insert(MstRoleModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstRoleModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstRoleModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
