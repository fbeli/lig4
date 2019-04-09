package br.com.becb.lig4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.becb.lig4.service.EntidadeApoio;
import br.com.becb.lig4.service.Log4Service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Log4Test {
	
	
	@Autowired
	Log4Service logService;
	

	/**
	 * Enviar a coluna e responder a coluna/linha
	 * 
	 * 
	 */
	@Test
	public void jogadaTest() {
		
		assertEquals(logService.jogadaColuna(5,"laranja"),"0500");
		
		assertEquals(logService.jogadaColuna(5,"azul"),"0501");
		
		setPosicao();
		assertEquals(logService.jogadaColuna(6,"laranja"),"0604");
		
	}
	private void setPosicao() {
		String cor = "laranja";
		
		EntidadeApoio ea = EntidadeApoio.getInstance();
		for (int coluna = 0; coluna<12; coluna++) {
			for(int linha = 0 ; linha<4; linha ++) {
				if("laranja".equals(cor))
					cor = "azul";
				else
					cor="laranja";
				ea.setPosicao(coluna, linha, cor);
			}
		}
	}

	
	
	
	
	public Log4Service getLogService() {
		return logService;
	}


	public void setLogService(Log4Service logService) {
		this.logService = logService;
	}

}
