package com.bootcamp.pos.dao;

import java.util.List;

import com.bootcamp.pos.model.MstRoleModel;

public interface MstRoleDao {

	public List<MstRoleModel> get() throws Exception;
	public List<MstRoleModel> search(String keySearch) throws Exception;
	public MstRoleModel getById(Long id) throws Exception;
	public void insert(MstRoleModel model) throws Exception;
	public void update(MstRoleModel model) throws Exception;
	public void delete(MstRoleModel model) throws Exception; 
}
