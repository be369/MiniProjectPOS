package com.bootcamp.pos.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.pos.dao.TrxPrDao;
import com.bootcamp.pos.model.TrxPrDetailModel;
import com.bootcamp.pos.model.TrxPrHistoryModel;
import com.bootcamp.pos.model.TrxPrModel;
import com.bootcamp.pos.viewmodel.TrxPrDetailViewModel;
import com.bootcamp.pos.viewmodel.TrxPrViewModel;

@Repository
public class TrxPrDaoImpl implements TrxPrDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getCode() throws Exception {
		return null;
	}

	@Override
	public List<TrxPrModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<TrxPrModel> result = session.createQuery("from TrxPrModel").list();
		return result;
	}

	@Override
	public List<TrxPrModel> search(String keySearch) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TrxPrModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<TrxPrModel> result = criteria.list();
		return result;
	}

	@Override
	public TrxPrModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPrModel result = session.get(TrxPrModel.class, id);
		return result;
	}

	@Override
	public TrxPrDetailModel getDetailById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPrDetailModel result = session.get(TrxPrDetailModel.class, id);
		return result;
	}

	@Override
	public void insert(TrxPrViewModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		
		//save PR header
		TrxPrModel pr = new TrxPrModel();
		pr.setReadyTime(model.getReadyTime());
		pr.setPrNo("123456");
		pr.setOutletId(model.getOutletId());
		pr.setStatusId(model.getStatusId());
		pr.setNotes(model.getNotes());
		pr.setCreatedBy(model.getCreatedBy());
		pr.setCreatedOn(model.getCreatedOn());
		pr.setModifiedBy(model.getModifiedBy());
		pr.setModifiedOn(model.getModifiedOn());
		session.save(pr);
		
		//save PR History
		TrxPrHistoryModel prHistory = new TrxPrHistoryModel();
		prHistory.setPrId(pr.getId());
		prHistory.setStatusId(pr.getStatusId());
		prHistory.setCreatedBy(model.getCreatedBy());
		prHistory.setCreatedOn(model.getCreatedOn());
		session.save(prHistory);
		
		//save PR Detail
		List<TrxPrDetailViewModel> listDetail = model.getDetail();
		if(listDetail != null && listDetail.size() > 0){
			for(TrxPrDetailViewModel item : listDetail){
				TrxPrDetailModel prDetail = new TrxPrDetailModel();
				prDetail.setPrId(pr.getId());
				prDetail.setVariantId(item.getVariantId());
				prDetail.setRequestQty(item.getRequestQty());
				prDetail.setCreatedBy(model.getCreatedBy());
				prDetail.setCreatedOn(model.getCreatedOn());
				prDetail.setModifiedBy(model.getModifiedBy());
				prDetail.setModifiedOn(model.getModifiedOn());
				session.save(prDetail);
			}
		}

	}

	@Override
	public void update(TrxPrViewModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		
		//save PR Header
		TrxPrModel pr = this.getById(model.getId());
		if(pr != null){
			pr.setReadyTime(model.getReadyTime());
			pr.setNotes(model.getNotes());
			pr.setModifiedBy(model.getModifiedBy());
			pr.setModifiedOn(model.getModifiedOn());
			session.update(pr);
		}
		
		//save PR Detail
		List<TrxPrDetailViewModel> listDetail = model.getDetail();
		if(listDetail != null && listDetail.size() > 0){
			for(TrxPrDetailViewModel item : listDetail){
				TrxPrDetailModel prDetail = this.getDetailById(item.getId());
				prDetail.setRequestQty(item.getRequestQty());
				prDetail.setModifiedBy(model.getModifiedBy());
				prDetail.setModifiedOn(model.getModifiedOn());
				session.update(prDetail);
			}
		}
	}

	@Override
	public void delete(TrxPrModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteriaDetail = session.createCriteria(TrxPrDetailModel.class);
		criteriaDetail.add(Restrictions.eq("prId", model.getId()));
		List<TrxPrDetailModel> details = criteriaDetail.list();
		if(details != null && details.size() > 0 ){
			for(TrxPrDetailModel detail : details){
				session.delete(detail);
			}
		}
		
		//cari History
		Criteria criteriaHistory = session.createCriteria(TrxPrHistoryModel.class);
		criteriaHistory.add(Restrictions.eq("prId", model.getId()));
		List<TrxPrHistoryModel> histories = criteriaHistory.list();
		if(histories !=null && histories.size() > 0){
			for(TrxPrHistoryModel hitory : histories){
				session.delete(hitory);
			}
		}
		//delete PR Header
		session.delete(model);
	}

	@Override
	public void deleteDetail(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPrDetailModel model = this.getDetailById(id);
		if(model != null){
			session.delete(model);
		}

	}

}
