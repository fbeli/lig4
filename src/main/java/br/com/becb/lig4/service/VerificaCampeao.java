package br.com.becb.lig4.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import br.com.becb.lig4.suporte.CheckCampeao;

@Service
public class VerificaCampeao {

	int maioValorColuna = 8;
	public CheckCampeao verificaCampeao(String[][] jogadas) {

		return null;
	}

	public CheckCampeao verificaHorizontal(String[][] jogadas) {

		CheckCampeao ea = new CheckCampeao();
		for (int linha = 0; linha < 8; linha++) {
			for (int coluna = 0; coluna < maioValorColuna; coluna++) {
				/*
				 * if(null == jogadas[coluna][linha]) { reiniciaCheckCampeao(ea); break; }
				 */
				
				if (jogadas[coluna][linha] != null) {
					if (null == ea.getCor())
						ea.setCor(jogadas[coluna][linha]);
					if (ea.getCor() == jogadas[coluna][linha]) {
						temCampeao(ea, "0" + coluna + "0" + linha);
						if (ea.isTemCampeao())
							return ea;
					} else {
						reiniciaCheckCampeao(ea);
						ea.setCor(jogadas[coluna][linha]);
						ea.setPos1("0" + coluna + "0" + linha);
					}
				}else
					reiniciaCheckCampeao(ea);
				if( coluna == maioValorColuna-1) {
					reiniciaCheckCampeao(ea);
				}
			}
		}

		return ea;
	}

	public CheckCampeao verificaVertical(String[][] jogadas) {

		CheckCampeao ea = new CheckCampeao();
		for (int coluna = 0; coluna < 8; coluna++) {
			for (int linha = 0; linha < 8; linha++) {
				if (null == jogadas[coluna][linha]) {
					reiniciaCheckCampeao(ea);
					break;
				}
				if (null == ea.getCor())
					ea.setCor(jogadas[coluna][linha]);
				if (ea.getCor() == jogadas[coluna][linha]) {
					temCampeao(ea, "0" + coluna + "0" + linha);
					if (ea.isTemCampeao())
						return ea;
				} else {
					ea.setCor(jogadas[coluna][linha]);
					ea.setPos1("0" + coluna + "0" + linha);
				}

			}
		}

		return ea;
	}

	private CheckCampeao temCampeao(CheckCampeao cc, String colunaLinha) {
		if (cc.getPos1().isEmpty())
			cc.setPos1(colunaLinha);
		else if (cc.getPos2().isEmpty())
			cc.setPos2(colunaLinha);
		else if (cc.getPos3().isEmpty())
			cc.setPos3(colunaLinha);
		else if (cc.getPos4().isEmpty()) {
			cc.setPos4(colunaLinha);
			cc.setTemCampeao(true);
		}
		return cc;

	}

	private void reiniciaCheckCampeao(CheckCampeao cc) {
		cc.setCor(null);
		cc.setPos1("");
		cc.setPos2("");
		cc.setPos3("");
		cc.setPos4("");
		cc.setTemCampeao(false);
	}

	public CheckCampeao verificaDiagonal(String[][] jogadas) {

		return null;
	}

}
