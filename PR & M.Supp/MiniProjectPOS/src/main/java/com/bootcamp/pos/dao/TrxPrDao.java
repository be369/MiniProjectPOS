package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.TrxPrDetailModel;
import com.bootcamp.pos.model.TrxPrModel;
import com.bootcamp.pos.viewmodel.TrxPrViewModel;

public interface TrxPrDao {
	public String getCode() throws Exception;
	public List<TrxPrModel> get() throws Exception;
	public List<TrxPrModel> search(String keySearch) throws Exception;
	public TrxPrModel getById(int id) throws Exception;
	public TrxPrDetailModel getDetailById(int id) throws Exception;
	public void insert(TrxPrViewModel model) throws Exception;
	public void update(TrxPrViewModel model) throws Exception;
	public void delete(TrxPrModel model) throws Exception;
	public void deleteDetail(int id) throws Exception;

}
