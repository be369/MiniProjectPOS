package com.bootcamp.pos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.pos.dao.MstRoleDao;
import com.bootcamp.pos.model.MstRoleModel;
import com.bootcamp.pos.service.MstRoleService;

@Service
@Transactional
public class MstRoleServiceImpl implements MstRoleService {

	@Autowired private MstRoleDao dao;
	
	@Override
	public List<MstRoleModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstRoleModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstRoleModel getById(Long id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstRoleModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public void update(MstRoleModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(MstRoleModel model) throws Exception {
		this.dao.delete(model);
	}

}
