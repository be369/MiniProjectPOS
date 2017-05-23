package com.bootcamp.pos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.bootcamp.pos.model.MstEmployeeModel;
import com.bootcamp.pos.service.MstEmployeeService;
import com.bootcamp.pos.viewmodel.MstEmployeeViewModel;

@Controller
public class MstEmployeeController {

	private Log log = LogFactory.getLog(getClass());
	
	@Autowired private MstEmployeeService service;
	
	/*@Autowired
	private MstProvinceService provinceService;
	
	@Autowired
	private MstRoleService roleService;*/
	
	@RequestMapping(value="/master/employee")
	public ModelAndView index(){
		return new ModelAndView("/master/employee");
	}
	
	@RequestMapping(value="/master/employee/list")
	public ModelAndView list(Model model){
		List<MstEmployeeModel> result = new ArrayList();
		try {
			result = this.service.get();
		} catch (Exception e) {
			
		}		
		model.addAttribute("list",result);
		return new ModelAndView("/master/employee/list");
	}
	
	/*@RequestMapping(value="/master/employee/add")
	public ModelAndView add(Model model){
		List<MstProvinceModel> provinceList = null;
		try {
			provinceList = this.provinceService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		List<MstRoleModel> roleList = null;
		try {
			roleList = this.roleService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("roleList", roleList);
		model.addAttribute("provinceList", provinceList);
		
		return new ModelAndView("/master/employee/add");
	}*/
	
	/*@RequestMapping(value="/master/employee/edit")
	public ModelAndView edit(Model model, HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		MstEmployeeModel item = null;
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		List<MstProvinceModel> provinceList = null;
		try {
			provinceList = this.provinceService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		List<MstRoleModel> roleList = null;
		try {
			roleList = this.roleService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("item", item);
		model.addAttribute("roleList", roleList);
		model.addAttribute("provinceList", provinceList);
		
		return new ModelAndView("/master/employee/edit");
	}*/
	
	@RequestMapping(value="/master/employee/save")
	public String save(Model model, @ModelAttribute MstEmployeeViewModel employee, HttpServletRequest request){
		String result = "";
		String action = request.getParameter("action");
		try {
			if (action.equals("insert")) {
				employee.setCreatedBy((long) 1);
				employee.setCreatedOn(new Date());
				employee.setModifiedBy((long) 1);
				employee.setCreatedOn(new Date());
				employee.setActive(true);
				
				this.service.insert(employee);
			} else if (action.equals("update")){
				
			}				
			else if (action.equals("delete"))
			{
				
			}

			result = "success";

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = "failed";
		}

		model.addAttribute("message", result);
		
		return "/master/employee/save";
	}
}
