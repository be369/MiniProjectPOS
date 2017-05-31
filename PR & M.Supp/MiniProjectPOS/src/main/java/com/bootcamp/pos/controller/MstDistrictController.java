package com.bootcamp.pos.controller;

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

import com.bootcamp.pos.model.MstDistrictModel;
import com.bootcamp.pos.model.MstRegionModel;
import com.bootcamp.pos.service.MstDistrictService;

@Controller
public class MstDistrictController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MstDistrictService service;

	@RequestMapping(value = "/master/district")
	public ModelAndView MstDistrictIndex(Model model) {
		model.addAttribute("userName", this.getUserName());
		return new ModelAndView("/master/district");
	}

	@RequestMapping(value = "/master/district/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstDistrictModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/district/list");
	}
	
	@RequestMapping(value = "/master/district/listByRegion", method = RequestMethod.GET)
	public String listByRegion(Model model, HttpServletRequest request) {
		int regionId = Integer.parseInt(request.getParameter("regionId"));
		Collection<MstDistrictModel> result = null;
		try {
			result = this.service.getByRegion(regionId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return "/master/district/listByRegion";
	}

	@RequestMapping(value = "/master/district/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstDistrictModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/district/list");
	}

	@RequestMapping(value = "/master/district/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/master/district/add");
	}

	@RequestMapping(value = "/master/district/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstDistrictModel result = new MstDistrictModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/district/edit");
	}

	@RequestMapping(value = "/master/district/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstDistrictModel result = new MstDistrictModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/district/delete");
	}

	@RequestMapping(value = "/master/district/save")
	public String save(Model model, @ModelAttribute MstDistrictModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstDistrictModel tmp = null;
		try {
			tmp = this.service.getById(item.getId());

			if (action.equals("insert")) {
				item.setCreatedBy(this.getUserId());
				item.setCreatedOn(new Date());
				item.setModifiedBy(this.getUserId());
				item.setCreatedOn(new Date());
				item.setActive(1);
				
				this.service.insert(item);
			} else if (action.equals("update")){
				item.setModifiedBy(this.getUserId());
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

		return "/master/district/save";
	}
}
