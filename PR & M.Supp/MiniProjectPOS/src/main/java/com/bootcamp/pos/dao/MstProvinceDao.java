package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.MstProvinceModel;


public interface MstProvinceDao {
	public List<MstProvinceModel> get() throws Exception;
	public List<MstProvinceModel> search(String keySearch) throws Exception;
	public MstProvinceModel getById(int id) throws Exception;
	public void insert(MstProvinceModel model) throws Exception;
	public void update(MstProvinceModel model) throws Exception;
	public void delete(MstProvinceModel model) throws Exception;
}
