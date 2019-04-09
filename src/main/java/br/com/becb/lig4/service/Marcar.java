package br.com.becb.lig4.service;

public class Marcar {

	
	private String cor;
	private String coluna;
	private String linha;
	private String colunalinha;
	
	private boolean apagarTudo = false;
	
	// para garantir que azul e laranja tenham sido avisados deve estar setado como true prata parar de mandar msg
	private boolean azulAvisado = true;
	private boolean laranjaAvisado = true;
	private boolean avisados = true;
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getColuna() {
		return coluna;
	}
	public void setColuna(String coluna) {
		this.coluna = coluna;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public String getColunalinha() {
		return colunalinha;
	}
	public void setColunalinha(String colunalinha) {
		this.colunalinha = colunalinha;
	}
	public boolean isApagarTudo() {
		return apagarTudo;
	}
	public void setApagarTudo(boolean apagarTudo, String cor) {
		this.apagarTudo = apagarTudo;
		if(apagarTudo)
			this.colunalinha="";
	}
	public boolean isAzulAvisado() {
		return azulAvisado;
	}
	public void setAzulAvisado(boolean azulAvisado) {
		this.azulAvisado = azulAvisado;
	}
	public boolean isLaranjaAvisado() {
		return laranjaAvisado;
	}
	public void setLaranjaAvisado(boolean laranjaAvisado) {
		this.laranjaAvisado = laranjaAvisado;
	}
	public boolean isAvisados() {
		if(laranjaAvisado && azulAvisado)
			return true;
		return false;
	}
	public void setAvisados(boolean avisados) {
		if(!avisados) {
			this.avisados = avisados;
			this.laranjaAvisado = false;
			this.azulAvisado = false;
		}
		this.avisados = avisados;
	}
	
	
	
	
}
