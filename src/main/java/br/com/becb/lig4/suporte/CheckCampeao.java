package br.com.becb.lig4.suporte;

import org.springframework.stereotype.Service;

/**
 * suporte para verificar se houve campeão.
 * 
 * campeão tem que estar com 4 colunas subsequentes.
 * 
 * linha horizontal 0000 0100 0200 0300
 * linha vertical 0100 0101 0102 0103
 * diagonal 0000 0101 0202 0303
 * diagona 0404 0503 0602 0701
 * @author fredb
 *
 */

public class CheckCampeao {

	
	private String cor;
	private String pos1="";
	private String pos2="";
	private String pos3="";
	private String pos4="";
	private boolean temCampeao = false;
	
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPos1() {
		return pos1;
	}
	public void setPos1(String pos1) {
		this.pos1 = pos1;
	}
	public String getPos2() {
		return pos2;
	}
	public void setPos2(String pos2) {
		this.pos2 = pos2;
	}
	public String getPos3() {
		return pos3;
	}
	public void setPos3(String pos3) {
		this.pos3 = pos3;
	}
	public String getPos4() {
		return pos4;
	}
	public void setPos4(String pos4) {
		this.pos4 = pos4;
	}
	public boolean isTemCampeao() {
		return temCampeao;
	}
	public void setTemCampeao(boolean temCampeao) {
		this.temCampeao = temCampeao;
	}
	
}
