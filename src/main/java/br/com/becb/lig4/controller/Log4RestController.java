
package br.com.becb.lig4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.becb.lig4.service.Log4Service;
import br.com.becb.lig4.suporte.Marcar;

@RestController
public class Log4RestController {

	@Autowired 
	Log4Service log4service;
	
	@RequestMapping(value = "/jogada", method = RequestMethod.GET)
	public @ResponseBody String jogada(String coluna, String cor) {

		System.out.println("Vez: "+log4service.verificaVez() +"  Cor solicitante: "+ cor);
		if(log4service.verificaVez().equals(cor)){
		
			String result = log4service.jogadaColuna(new Integer(coluna), cor);
			System.out.println("coluna/linha: "+ coluna +" cor: "+cor);
	
			return result;
		}
		return "";
	}

	@RequestMapping(value = "/cor", method = RequestMethod.GET)
	public @ResponseBody String cor() {

		String result = log4service.getCor();
		return result;
	}

	@RequestMapping(value = "/reiniciar", method = RequestMethod.GET)
	public @ResponseBody String reiniciar(String cor) {

		log4service.reiniciar(cor);
		return "reiniciando";
	}
	
	@RequestMapping(value = "/respostaOponente", method = RequestMethod.GET)
	public @ResponseBody Marcar respostaOponente(String cor) {
		
		String resposta = log4service.getResposta();
		if(null == resposta)
			return null;
		
		if(!log4service.getUltimaJogada().isAvisados()) {
			if(log4service.getUltimaJogada().isLaranjaAvisado() && log4service.getUltimaJogada().isAzulAvisado())
				log4service.getUltimaJogada().setAvisados(true);
			else {
				if("laranja".equals(cor))
					log4service.getUltimaJogada().setLaranjaAvisado(true);
				else
					log4service.getUltimaJogada().setAzulAvisado(true);
			}	
		}else
			log4service.getUltimaJogada().setApagarTudo(false, cor);;
		
		return log4service.getUltimaJogada();
	}
	
}
