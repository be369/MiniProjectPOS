package com.bootcamp.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.TrxPrDao;
import com.bootcamp.pos.model.TrxPrModel;
import com.bootcamp.pos.service.TrxPrService;
import com.bootcamp.pos.viewmodel.TrxPrViewModel;

@Service
@Transactional
public class TrxPrServiceImpl implements TrxPrService {
	
	@Autowired
	private TrxPrDao dao;
	
	@Override
	public List<TrxPrModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<TrxPrModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public TrxPrModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(TrxPrViewModel model) throws Exception {
	 this.dao.insert(model);

	}

	@Override
	public void update(TrxPrViewModel model) throws Exception {
		this.dao.update(model);

	}

	@Override
	public void delete(TrxPrModel model) throws Exception {
		this.dao.delete(model);

	}

	@Override
	public void deleteDetail(int id) throws Exception {
		this.dao.deleteDetail(id);

	}

}
