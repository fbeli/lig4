package br.com.becb.lig4.service;

public final class EntidadeApoio {

	private static boolean cor = false;
	private String cor1 = "azul";
	private String cor2 = "laranja";
	private String vez = "azul";
	private String resposta;
	private Marcar ultimaJogada = new Marcar();
	
	
	private static final EntidadeApoio instance = new EntidadeApoio();

	private String[][] posicao = new String[12][8];

	public void setPosicao(int coluna, int linha, String cor) {
		posicao[coluna][linha] = cor;
	}
	public void zerarPosicao() {
		posicao = new String[12][8];	
	}

	public String getPosicao(int coluna, int linha) {
		return posicao[coluna][linha];
	}

	public static EntidadeApoio getInstance() {
		return instance;
	}

	public String getCor() {
		if (!cor) {
			cor = !cor;
			return cor1;
		}else {
			cor = !cor;
			return cor2;
		}
	}

	public String getVez() {
		return vez;
	}

	public void setVez(String cor) {
		if("laranja".equals(cor))
			vez = "azul";
		else
			this.vez = "laranja";
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
		ultimaJogada.setColunalinha(resposta);
	}
	public void setResposta(String resposta, String cor) {
		this.resposta = resposta;
		ultimaJogada.setCor(cor);
		ultimaJogada.setColunalinha(resposta);
	}


	public Marcar getUltimaJogada() {
		return ultimaJogada;
	}

	public void setUltimaJogada(Marcar ultimaJogada) {
		this.ultimaJogada = ultimaJogada;
	}

}
