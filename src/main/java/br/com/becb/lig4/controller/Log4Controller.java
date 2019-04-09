package br.com.becb.lig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.becb.lig4.service.Log4Service;

@Controller
public class Log4Controller {

	@Autowired 
	Log4Service service;
	
	@GetMapping("/log4")
	public ModelAndView log4Inicio() {
		
		ModelAndView mv = new ModelAndView("lig4");		
		return mv;

	}
}
