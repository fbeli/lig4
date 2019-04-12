package br.com.becb.lig4.suporte;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EntidadeJogador {

	
	String cor;

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
