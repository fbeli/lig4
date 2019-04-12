package br.com.becb.lig4.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.becb.lig4.service.Log4Service;
import br.com.becb.lig4.suporte.EntidadeJogador;

@Controller
@SessionAttributes("jogador")
public class Log4Controller {

	@Autowired 
	Log4Service service;
	
	@Autowired
	EntidadeJogador jogador;
	
	@GetMapping("/log4")
	public ModelAndView log4Inicio() {
		
		
//		session.setAttribute("cor",service.getCor());
	//	session.addAttribute("cor",service.getCor());
	
		
		ModelAndView mv = new ModelAndView("lig4");		
		mv.addObject("cor",service.getCor());
		
		return mv;

	}
	
	@RequestMapping("/lig4")
	public String lig4Inicio(HttpServletRequest request,Map<String, Object> model ) {
	
		jogador = new EntidadeJogador();
		jogador.setCor(service.getCor());
		request.setAttribute("jogador",jogador);
		request.getSession().setAttribute("jogador", jogador);
		model.put("cor", jogador);
		return "lig4";

	}
}
