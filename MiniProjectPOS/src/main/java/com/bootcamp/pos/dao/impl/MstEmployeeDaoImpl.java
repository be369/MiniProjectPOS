package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.MstEmployeeDao;
import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.model.MstEmployeeOutletModel;
import com.bootcamp.pos.model.MstUserModel;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;

@Repository
public class MstEmployeeDaoImpl implements MstEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MstEmployeeModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstEmployeeModel> result = session.createQuery("from MstEmployeeModel").list();
		return result;
	}

	@Override
	public List<MstEmployeeModel> search(String keySearch) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstEmployeeModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstEmployeeModel> result = criteria.list();
		return result;
	}

	@Override
	public MstEmployeeModel getById(Integer id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstEmployeeModel result = session.get(MstEmployeeModel.class, id);
		return result;
	}

	@Override
	public MstEmployeeModel getByEmail(String email) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MstEmployeeModel x where x.email = :email");
		query.setParameter("email", email);
		MstEmployeeModel result = (MstEmployeeModel) query.getSingleResult();
		return result;
	}

	@Override
	public void insert(MstEmployeeViewModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// employee
		MstEmployeeModel emp = new MstEmployeeModel();
		emp.setFirstName(model.getFirstName());
		emp.setLastName(model.getLastName());
		emp.setEmail(model.getEmail());
		emp.setTitle(model.getTitle());
		emp.setHaveAccount(model.getHaveAccount());
		emp.setCreateBy(model.getCreatedBy());
		emp.setCreateOn(model.getCreatedOn());
		emp.setModifiedBy(model.getModifiedBy());
		emp.setModifiedOn(model.getModifiedOn());
		emp.setActive(true);
		session.save(emp);

		// outlet
		List<Long> outletList = model.getOutletId();
		if (outletList != null && outletList.size() > 0) {
			for (Long item : outletList) {
				MstEmployeeOutletModel outletEmp = new MstEmployeeOutletModel();
				outletEmp.setEmployeeId(emp.getId());
				outletEmp.setOutletId(item);
				session.save(outletEmp);
			}
		}
		
		// save ke user
		if(model.getRoleId() > 0 && !model.getUserName().equals("") && !model.getPassword().equals("")){
		MstUserModel user = new MstUserModel();
		user.setUsername(model.getUserName());
		user.setPassword(model.getPassword());
		user.setEmployeeId(emp.getId());
		user.setRoleId(model.getRoleId());
		user.setCreatedBy(model.getCreatedBy());
		user.setCreatedOn(model.getCreatedOn());
		user.setModifiedBy(model.getModifiedBy());
		user.setModifiedOn(model.getModifiedOn());
		user.setActive(true);
		session.save(user);
		}
	}

	@Override
	public void update(MstEmployeeModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);

	}

	@Override
	public void delete(MstEmployeeModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}
}
