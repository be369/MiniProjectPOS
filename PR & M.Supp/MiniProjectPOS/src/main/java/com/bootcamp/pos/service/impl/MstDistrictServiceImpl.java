package com.bootcamp.pos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.MstDistrictDao;
import com.bootcamp.pos.model.MstDistrictModel;
import com.bootcamp.pos.service.MstDistrictService;

@Service
@Transactional
public class MstDistrictServiceImpl implements MstDistrictService {
	
	@Autowired private MstDistrictDao dao;
	
	@Override
	public List<MstDistrictModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstDistrictModel> getByRegion(int regionId) throws Exception {
		return this.dao.getByRegion(regionId);
	}
	
	@Override
	public List<MstDistrictModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstDistrictModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstDistrictModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public void update(MstDistrictModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(MstDistrictModel model) throws Exception {
		this.dao.delete(model);
	}

}
