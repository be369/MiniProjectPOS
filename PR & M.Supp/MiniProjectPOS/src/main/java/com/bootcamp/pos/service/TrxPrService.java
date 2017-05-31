package com.bootcamp.pos.service;

import java.util.List;
import com.bootcamp.pos.model.TrxPrModel;
import com.bootcamp.pos.viewmodel.TrxPrViewModel;

public interface TrxPrService {
	public List<TrxPrModel> get() throws Exception;
	public List<TrxPrModel> search(String keySearch) throws Exception;
	public TrxPrModel getById(int id) throws Exception;
	public void insert(TrxPrViewModel model) throws Exception;
	public void update(TrxPrViewModel model) throws Exception;
	public void delete(TrxPrModel model) throws Exception;
	public void deleteDetail(int id) throws Exception;
}
