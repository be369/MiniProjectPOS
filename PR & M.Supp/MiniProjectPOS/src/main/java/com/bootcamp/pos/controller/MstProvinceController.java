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

import com.bootcamp.pos.model.MstProvinceModel;
import com.bootcamp.pos.service.MstProvinceService;

@Controller
public class MstProvinceController extends BaseController {
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private MstProvinceService service;

	@RequestMapping(value = "/master/province")
	public ModelAndView MstProvinceIndex(Model model) {
		model.addAttribute("userName", this.getUserName());
		return new ModelAndView("/master/province");
	}

	@RequestMapping(value = "/master/province/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstProvinceModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/province/list");
	}

	@RequestMapping(value = "/master/province/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstProvinceModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/province/list");
	}

	@RequestMapping(value = "/master/province/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/master/province/add");
	}

	@RequestMapping(value = "/master/province/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstProvinceModel result = new MstProvinceModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/province/edit");
	}

	@RequestMapping(value = "/master/province/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MstProvinceModel result = new MstProvinceModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/province/delete");
	}

	@RequestMapping(value = "/master/province/save")
	public String save(Model model, @ModelAttribute MstProvinceModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstProvinceModel tmp = null;
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

		return "/master/province/save";
	}
}
