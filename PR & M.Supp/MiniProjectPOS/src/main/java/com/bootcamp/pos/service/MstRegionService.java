package com.bootcamp.pos.service;

import java.util.List;

import com.bootcamp.pos.model.MstRegionModel;

public interface MstRegionService {
	public List<MstRegionModel> get() throws Exception;
	public List<MstRegionModel> getByProvince(int provinceId) throws Exception;
	public List<MstRegionModel> search(String keySearch) throws Exception;
	public MstRegionModel getById(int id) throws Exception;
	public void insert(MstRegionModel model) throws Exception;
	public void update(MstRegionModel model) throws Exception;
	public void delete(MstRegionModel model) throws Exception;
}
