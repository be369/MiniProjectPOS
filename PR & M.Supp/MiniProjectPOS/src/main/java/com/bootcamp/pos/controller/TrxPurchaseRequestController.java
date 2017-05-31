package com.bootcamp.pos.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.bootcamp.pos.model.TrxPrModel;
import com.bootcamp.pos.service.TrxPrService;
import com.bootcamp.pos.viewmodel.TrxPrViewModel;

@Controller
public class TrxPurchaseRequestController extends BaseController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private TrxPrService service;
	
	@RequestMapping(value="/purchase/request")
	public ModelAndView TrxPrIndex(Model model){
		model.addAttribute("userName", this.getUserName());
		return new ModelAndView("/purchase/request");
	}
	
	@RequestMapping(value = "/purchase/request/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<TrxPrModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/purchase/request/list");
	}
	
	@RequestMapping(value = "/purchase/request/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<TrxPrModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/purchase/request/list");
	}
	
	@RequestMapping(value = "/purchase/request/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/purchase/request/add");
	}
	
	@RequestMapping(value = "/purchase/request/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		TrxPrModel result = new TrxPrModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		// mengganti format datetime
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String readyTime = df.format(result.getReadyTime());

		model.addAttribute("item", result);
		model.addAttribute("readyTime", readyTime);
		return new ModelAndView("/purchase/request/edit");
	}
	
	@RequestMapping(value = "/purchase/request/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		TrxPrModel result = new TrxPrModel();
		try {
			// dari dahulu object puchase request;
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);
		
		return new ModelAndView("/purchase/request/delete");
	}
	
	@RequestMapping(value = "/purchase/request/deleteDetail")
	public String deleteDetail(Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String result = "";
		try {
			// jika id tidak sama dengan nol
			if (id != 0) {
				this.service.deleteDetail(id);
			}
			result = "success";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = "failed";
		}
		model.addAttribute("message", result);

		return "/purchase/request/deleteDetail";
	}
	
	@RequestMapping(value = "/purchase/request/save")
	public String save(Model model, @ModelAttribute TrxPrViewModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		TrxPrModel tmp = null;
		try {	
			if (action.equals("insert")) {
				item.setCreatedBy(this.getUserId());
				item.setCreatedOn(new Date());
				item.setModifiedBy(this.getUserId());
				item.setCreatedOn(new Date());
				item.setOutletId(1);
				item.setStatusId(1);

				this.service.insert(item);
			} else if (action.equals("update")) {
				item.setModifiedBy(this.getUserId());
				item.setCreatedOn(new Date());
				
				this.service.update(item);
			} else if (action.equals("delete")){
				tmp = this.service.getById(item.getId());
				
				this.service.delete(tmp);
			}
			
			result = "success";

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = "failed";
		}

		model.addAttribute("message", result);

		return "/purchase/request/save";
	}
}
