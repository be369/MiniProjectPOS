package com.bootcamp.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.pos.dao.MstEmployeeDao;
import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.service.MstEmployeeService;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;

@Service
@Transactional
public class MstEmployeeServiceImpl implements MstEmployeeService {

	@Autowired private MstEmployeeDao dao;
	
	@Override
	public List<MstEmployeeModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstEmployeeModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstEmployeeModel getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.getById(id);
	}

	@Override
	public MstEmployeeModel getByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.getByEmail(email);
	}

	@Override
	public void insert(MstEmployeeViewModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public void update(MstEmployeeModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(MstEmployeeModel model) throws Exception {
		this.dao.delete(model);
	}

}
