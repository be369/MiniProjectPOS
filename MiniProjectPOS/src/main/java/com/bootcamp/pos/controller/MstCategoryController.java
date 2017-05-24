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

import com.bootcamp.pos.model.MstCategoryModel;
import com.bootcamp.pos.service.MstCategoryService;


@Controller
public class MstCategoryController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MstCategoryService service;

	@RequestMapping(value = "/master/category")
	public ModelAndView MstCategoryIndex(Model model) {
		model.addAttribute("userName", this.getUserName());
		return new ModelAndView("/master/category");
	}

	@RequestMapping(value = "/master/category/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstCategoryModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/category/list");
	}

	@RequestMapping(value = "/master/category/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstCategoryModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/category/list");
	}

	@RequestMapping(value = "/master/category/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/master/category/add");
	}

	@RequestMapping(value = "/master/category/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstCategoryModel result = new MstCategoryModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/category/edit");
	}

	@RequestMapping(value = "/master/category/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstCategoryModel result = new MstCategoryModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/category/delete");
	}

	@RequestMapping(value = "/master/category/save")
	public String save(Model model, @ModelAttribute MstCategoryModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstCategoryModel tmp = null;
		try {
			tmp = this.service.getById(item.getId());

			if (action.equals("insert")) {
				item.setCreatedBy(1);
				item.setCreatedOn(new Date());
				item.setModifiedBy(1);
				item.setCreatedOn(new Date());
				item.setActive(1);
				
				this.service.insert(item);
			} else if (action.equals("update")){
				item.setModifiedBy(1);
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

		return "/master/category/save";
	}
}
