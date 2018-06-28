package com.waylau.spring.boot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理控制器
 * @author xsx
 *
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

	@GetMapping
	public ModelAndView listUsers(Model model) {
		return new ModelAndView("admin/index","menuList",model);
	}
	 
}
