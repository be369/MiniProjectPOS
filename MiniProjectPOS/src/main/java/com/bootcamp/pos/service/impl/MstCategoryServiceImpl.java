package com.bootcamp.pos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.MstCategoryDao;
import com.bootcamp.pos.model.MstCategoryModel;
import com.bootcamp.pos.service.MstCategoryService;



@Service
@Transactional
public class MstCategoryServiceImpl implements MstCategoryService {
	
	@Autowired private MstCategoryDao dao;
	
	@Override
	public List<MstCategoryModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstCategoryModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstCategoryModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstCategoryModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public void update(MstCategoryModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(MstCategoryModel model) throws Exception {
		this.dao.delete(model);
	}

}
