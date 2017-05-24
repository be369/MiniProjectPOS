package com.bootcamp.pos.service;

import java.util.List;

import com.bootcamp.pos.model.MstCategoryModel;

public interface MstCategoryService {
	public List<MstCategoryModel> get() throws Exception;
	public List<MstCategoryModel> search(String keySearch) throws Exception;
	public MstCategoryModel getById(int id) throws Exception;
	public void insert(MstCategoryModel model) throws Exception;
	public void update(MstCategoryModel model) throws Exception;
	public void delete(MstCategoryModel model) throws Exception;
}
