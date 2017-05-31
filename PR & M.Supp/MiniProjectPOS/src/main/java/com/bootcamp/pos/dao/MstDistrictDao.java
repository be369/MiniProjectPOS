package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.MstDistrictModel;

public interface MstDistrictDao {
	public List<MstDistrictModel> get() throws Exception;
	public List<MstDistrictModel> getByRegion(int regionId) throws Exception;
	public List<MstDistrictModel> search(String keySearch) throws Exception;
	public MstDistrictModel getById(int id) throws Exception;
	public void insert(MstDistrictModel model) throws Exception;
	public void update(MstDistrictModel model) throws Exception;
	public void delete(MstDistrictModel model) throws Exception;
}
