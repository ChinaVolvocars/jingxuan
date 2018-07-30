package com.jiameng.jingxuan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Device device, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		return "zh_cn/index";
	}
	
	
}
