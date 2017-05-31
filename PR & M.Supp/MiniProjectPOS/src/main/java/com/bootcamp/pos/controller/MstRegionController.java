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

import com.bootcamp.pos.model.MstRegionModel;
import com.bootcamp.pos.service.MstRegionService;

@Controller
public class MstRegionController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MstRegionService service;

	@RequestMapping(value = "/master/region")
	public ModelAndView MstRegionIndex(Model model) {
		model.addAttribute("userName", this.getUserName());
		return new ModelAndView("/master/region");
	}

	@RequestMapping(value = "/master/region/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstRegionModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/region/list");
	}
	
	@RequestMapping(value = "/master/region/listByProvince", method = RequestMethod.GET)
	public String listByProvince(Model model, HttpServletRequest request) {
		int provinceId = Integer.parseInt(request.getParameter("provinceId"));
		Collection<MstRegionModel> result = null;
		try {
			result = this.service.getByProvince(provinceId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return "/master/region/listByProvince";
	}

	@RequestMapping(value = "/master/region/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstRegionModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/region/list");
	}

	@RequestMapping(value = "/master/region/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/master/region/add");
	}

	@RequestMapping(value = "/master/region/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstRegionModel result = new MstRegionModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/region/edit");
	}

	@RequestMapping(value = "/master/region/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstRegionModel result = new MstRegionModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/region/delete");
	}

	@RequestMapping(value = "/master/region/save")
	public String save(Model model, @ModelAttribute MstRegionModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstRegionModel tmp = null;
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

		return "/master/region/save";
	}
}
