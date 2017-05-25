package com.bootcamp.pos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.pos.dao.MstSupplierDao;
import com.bootcamp.pos.model.MstSupplierModel;
import com.bootcamp.pos.service.MstSupplierService;

@Service
@Transactional
public class MstSupplierServiceImpl implements MstSupplierService {

	@Autowired private MstSupplierDao dao;
	
	@Override
	public List<MstSupplierModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstSupplierModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstSupplierModel getById(Long id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstSupplierModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public void update(MstSupplierModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(MstSupplierModel model) throws Exception {
		this.dao.delete(model);
	}

}
