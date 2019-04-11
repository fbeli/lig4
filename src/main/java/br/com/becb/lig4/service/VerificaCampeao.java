package br.com.becb.lig4.service;


import org.springframework.stereotype.Service;


import br.com.becb.lig4.suporte.CheckCampeao;

@Service
public class VerificaCampeao {

	final int maioValorColuna = 8;
	final int maioValorLinha = 7;

	int quantidadeCampeao = 4;

	public CheckCampeao verificaCampeao(String[][] jogadas) {

		return null;
	}

	public CheckCampeao verificaDiagonal(String[][] jogadas) {
		CheckCampeao cc = new CheckCampeao();
		cc = verificaDiagonalSuperior(jogadas, cc);
		if (cc.isTemCampeao())
			return cc;
		
		cc = verificaDiagonalInferior(jogadas, cc);
		
			return cc;
	}

	public CheckCampeao verificaDiagonalInferior(String[][] jogadas, CheckCampeao cc) {

		for (int coluna = 0; coluna < maioValorColuna - 3; coluna++) {
			for (int linha = maioValorLinha; linha >= maioValorLinha - 4; linha--) {
				reiniciaCheckCampeao(cc);
				if (jogadas[coluna][linha] != null) {
					cc.setCor(jogadas[coluna][linha]);
					verificarProximaInferior(cc, jogadas, coluna, linha, 1);
					if (cc.isTemCampeao())
						return cc;
				} 

			}
		}

		return cc;
	}

	private CheckCampeao verificarProximaInferior(CheckCampeao cc, String[][] jogadas, int coluna, int linha,
			int pecaNumero) {

		String colunaLinha = "0" + coluna + "0" + linha;

		if (pecaNumero == 4 && (coluna < maioValorColuna && linha <= maioValorLinha)) {
			cc.setPos4(colunaLinha);
			cc.setTemCampeao(true);
			return cc;
		}

		if (linha - 1 > 0) {
			if ((cc.getCor() == jogadas[coluna + 1][linha - 1])) {

				switch (pecaNumero) {
				case 1:
					cc.setPos1(colunaLinha);
					verificarProximaInferior(cc, jogadas, coluna + 1, linha - 1, pecaNumero + 1);
					break;
				case 2:
					cc.setPos2(colunaLinha);
					verificarProximaInferior(cc, jogadas, coluna + 1, linha - 1, pecaNumero + 1);
					break;
				case 3:
					cc.setPos3(colunaLinha);
					verificarProximaInferior(cc, jogadas, coluna + 1, linha - 1, pecaNumero + 1);
					break;

				}
			} else

				cc.setTemCampeao(false);
		}
		return cc;

	}

	/**
	 * 
	 * @param cc
	 * @param pecaNumero valor máximo 4, quantidade de peças que estaão em sequencia
	 *                   para ser campeao
	 * @return
	 */

	public CheckCampeao verificaDiagonalSuperior(String[][] jogadas, CheckCampeao cc) {

		for (int coluna = 0; coluna < maioValorColuna - 3; coluna++) {
			for (int linha = 0; maioValorColuna - 3 < 8; linha++) {
				reiniciaCheckCampeao(cc);
				if (jogadas[coluna][linha] != null) {
					cc.setCor(jogadas[coluna][linha]);
					verificarProximaSuperior(cc, jogadas, coluna, linha, 1);
					if (cc.isTemCampeao())
						return cc;
				} else
					break;

			}
		}

		return cc;
	}

	private CheckCampeao verificarProximaSuperior(CheckCampeao cc, String[][] jogadas, int coluna, int linha,
			int pecaNumero) {

		String colunaLinha = "0" + coluna + "0" + linha;

		if (pecaNumero == 4 && (coluna < maioValorColuna && linha < maioValorColuna)) {
			cc.setPos4(colunaLinha);
			cc.setTemCampeao(true);
			return cc;
		}

		if ((cc.getCor() == jogadas[coluna + 1][linha + 1] || pecaNumero == 4)) {

			switch (pecaNumero) {
			case 1:
				cc.setPos1(colunaLinha);
				verificarProximaSuperior(cc, jogadas, coluna + 1, linha + 1, pecaNumero + 1);
				break;
			case 2:
				cc.setPos2(colunaLinha);
				verificarProximaSuperior(cc, jogadas, coluna + 1, linha + 1, pecaNumero + 1);
				break;
			case 3:
				cc.setPos3(colunaLinha);
				verificarProximaSuperior(cc, jogadas, coluna + 1, linha + 1, pecaNumero + 1);
				break;

			}
		} else

			cc.setTemCampeao(false);

		return cc;
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
				} else
					reiniciaCheckCampeao(ea);
				if (coluna == maioValorColuna - 1) {
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

}
