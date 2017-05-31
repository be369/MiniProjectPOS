package com.bootcamp.pos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.MstProvinceDao;
import com.bootcamp.pos.model.MstProvinceModel;
import com.bootcamp.pos.service.MstProvinceService;

@Service
@Transactional
public class MstProvinceServiceImpl implements MstProvinceService {
	
	@Autowired private MstProvinceDao dao;
	
	@Override
	public List<MstProvinceModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstProvinceModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstProvinceModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstProvinceModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public void update(MstProvinceModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(MstProvinceModel model) throws Exception {
		this.dao.delete(model);
	}

}
