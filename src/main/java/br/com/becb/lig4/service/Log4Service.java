package br.com.becb.lig4.service;

import org.springframework.stereotype.Service;

@Service
public class Log4Service {

	EntidadeApoio ea = EntidadeApoio.getInstance();
	
	private String cor;
	
	public String jogadaColuna(int coluna, String cor) {
		
		if(ea.getUltimaJogada().isApagarTudo())
			ea.getUltimaJogada().setApagarTudo(false,cor);
		int linha = verificaLinha(coluna);
		String slinha;
		
		if(linha<10)
			 slinha= "0"+linha;
		else
			slinha = ""+linha;
		
		ea.setPosicao(coluna, linha, cor);
		ea.setVez(cor);
		
		String resposta;
		if(coluna>9)
			resposta = ""+coluna+slinha;
		else
			resposta = "0"+coluna+slinha;
		
		ea.setResposta(resposta, cor);
		return resposta;
	}
	public String getResposta() {
		return ea.getResposta();
	}
	public void setResposta(){		ea.setResposta("");
	}
	public int verificaLinha(int coluna) {
		
		for(int linha = 7; linha >= 0 ; linha--) {
			if(null!=ea.getPosicao(coluna, linha)) {
				return linha+1;
			}
		}
		return 0;
	}
	
	public String verificaVez() {
		return ea.getVez();
	}
	
	public String getCor() {
		return ea.getCor();
		
	}
	public Marcar getUltimaJogada() {
		return ea.getUltimaJogada();
	}
	public String reiniciar(String cor) {
		ea.zerarPosicao();
		ea.setVez("azul");
		ea.getUltimaJogada().setAvisados(false);
		getUltimaJogada().setApagarTudo(true, cor);
	
		
		return "jogo reiniciado";
	}
	
}
