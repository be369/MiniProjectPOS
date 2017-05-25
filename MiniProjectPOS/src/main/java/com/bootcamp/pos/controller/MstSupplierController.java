package com.bootcamp.pos.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bootcamp.pos.model.MstSupplierModel;
import com.bootcamp.pos.service.MstSupplierService;

@Controller
public class MstSupplierController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired MstSupplierService service;
	
	/*@Autowired MstProvinceService provinceService;*/
	
	@RequestMapping(value = "/master/supplier")
	public ModelAndView index(Model model) {
		
		return new ModelAndView("/master/supplier");
	}
	
	@RequestMapping(value = "/master/supplier/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstSupplierModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/supplier/list");
	}
	
	@RequestMapping(value = "/master/supplier/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstSupplierModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/supplier/list");
	}
	
	@RequestMapping(value = "/master/supplier/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		/*List<MstProvinceModel> provinceList = new ArrayList<>();*/
		try {
			/*provinceList = this.provinceService.get();*/
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		/*model.addAttribute("provinceList",provinceList);*/
		return new ModelAndView("/master/supplier/add");
	}
	
	@RequestMapping(value = "/master/supplier/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstSupplierModel result = new MstSupplierModel();
		try {
			result = this.service.getById((long) id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		/*List<MstProvinceModel> provinceList = new ArrayList<>();
		try {
			provinceList = this.provinceService.get();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		model.addAttribute("provinceList",provinceList);*/
		model.addAttribute("item", result);

		return new ModelAndView("/master/supplier/edit");
	}
	
	@RequestMapping(value = "/master/supplier/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstSupplierModel result = new MstSupplierModel();
		try {
			result = this.service.getById((long) id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/supplier/delete");
	}
	
	@RequestMapping(value = "/master/supplier/save")
	public String save(Model model, @ModelAttribute MstSupplierModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstSupplierModel tmp = null;
		try {
			tmp = this.service.getById(item.getId());

			if (action.equals("insert")) {
				item.setCreatedBy((long) 1);
				item.setCreatedOn(new Date());
				item.setModifiedBy((long) 1);
				item.setCreatedOn(new Date());
				item.setActive(true);
				
				this.service.insert(item);
			} else if (action.equals("update")){
				item.setModifiedBy((long) 1);
				item.setCreatedOn(new Date());
				this.service.update(item);
			}				
			else if (action.equals("delete"))
				this.service.delete(tmp);

			result = "success";

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = "failed";
		}

		model.addAttribute("message", result);

		return "/master/supplier/save";
	}
	
}
