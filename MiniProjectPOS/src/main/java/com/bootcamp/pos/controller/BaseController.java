/**
 * 
 */
package com.bootcamp.pos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	
	public String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			return userDetail.getUsername();
		}
		return null;
	}
	
	public int getUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null) {
			User user = (User) auth.getPrincipal();
			return 0;
		}
		return 0;
	}
	
	public int getOutletId(HttpSession session){
		int outletId = 0;
		if(!session.getAttribute("outletId").toString().equals("")){
			outletId = Integer.parseInt(session.getAttribute("outletId").toString());
		}
		return outletId;
	}
}
