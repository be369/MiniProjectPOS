package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.MstSupplierModel;

public interface MstSupplierDao {
	public List<MstSupplierModel> get() throws Exception;
	public List<MstSupplierModel> search(String keySearch) throws Exception;
	public MstSupplierModel getById(int id) throws Exception;
	public void insert(MstSupplierModel model) throws Exception;
	public void update(MstSupplierModel model) throws Exception;
	public void delete(MstSupplierModel model) throws Exception;
}
