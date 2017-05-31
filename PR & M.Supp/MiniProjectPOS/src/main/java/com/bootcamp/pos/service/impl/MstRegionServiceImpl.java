package com.bootcamp.pos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.MstRegionDao;
import com.bootcamp.pos.model.MstRegionModel;
import com.bootcamp.pos.service.MstRegionService;

@Service
@Transactional
public class MstRegionServiceImpl implements MstRegionService {
	
	@Autowired private MstRegionDao dao;
	
	@Override
	public List<MstRegionModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstRegionModel> getByProvince(int provinceId) throws Exception {
		return this.dao.getByProvince(provinceId);
	}
	
	@Override
	public List<MstRegionModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstRegionModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstRegionModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public void update(MstRegionModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(MstRegionModel model) throws Exception {
		this.dao.delete(model);
	}

}
