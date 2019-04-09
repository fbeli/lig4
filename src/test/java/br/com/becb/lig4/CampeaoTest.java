package br.com.becb.lig4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.becb.lig4.service.VerificaCampeao;
import br.com.becb.lig4.suporte.CheckCampeao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampeaoTest {

	@Autowired
	VerificaCampeao vc;
	private String[][] jogadaVerticalCampeao = new String[8][8];
	private String[][] jogadaHorizontalCampeao = new String[8][8];
	
	
	@Before
	public void ajustaVariaveis() {
		jogadaVerticalCampeao[0][0] = "laranja";
		jogadaVerticalCampeao[0][1] = "azul";
		jogadaVerticalCampeao[1][0] = "laranja";
		jogadaVerticalCampeao[1][1] = "azul";
		jogadaVerticalCampeao[1][2] = "laranja";
		jogadaVerticalCampeao[1][3] = "laranja";
		jogadaVerticalCampeao[2][0] = "laranja";
		jogadaVerticalCampeao[2][1] = "azul";
		jogadaVerticalCampeao[4][0] = "azul";
		jogadaVerticalCampeao[4][1] = "laranja";//
		jogadaVerticalCampeao[4][2] = "laranja";//
		jogadaVerticalCampeao[4][3] = "laranja";//
		jogadaVerticalCampeao[4][4] = "laranja";//
		
	
		jogadaHorizontalCampeao[2][0] = "laranja";
		jogadaHorizontalCampeao[2][1] = "laranja";
		jogadaHorizontalCampeao[3][0] = "laranja";
		jogadaHorizontalCampeao[4][0] = "laranja";
		jogadaHorizontalCampeao[5][0] = "azul";
		jogadaHorizontalCampeao[6][0] = "laranja";
		jogadaHorizontalCampeao[7][0] = "azul";
		jogadaHorizontalCampeao[4][1] = "laranja";
		jogadaHorizontalCampeao[5][1] = "azul";
		jogadaHorizontalCampeao[6][1] = "laranja";
		jogadaHorizontalCampeao[7][1] = "azul";
		jogadaHorizontalCampeao[4][2] = "laranja";//
		jogadaHorizontalCampeao[5][2] = "laranja";//
		jogadaHorizontalCampeao[6][2] = "laranja";//
		jogadaHorizontalCampeao[7][2] = "laranja";//
		jogadaHorizontalCampeao[3][3] = "laranja";
		jogadaHorizontalCampeao[4][3] = "laranja";
		
		
	}
	
	@Test
	public void jogadaVertical() {
		
		System.out.println("/nIniciando Teste... CampeaoTest");
		System.out.println("Jogada Vertical");
		CheckCampeao cc = vc.verificaVertical(jogadaVerticalCampeao);				
		assertEquals(cc.isTemCampeao(),true);
		if(cc.isTemCampeao()) {
			System.out.println(cc.getCor());
			System.out.println(cc.getPos1() +"  "+cc.getPos2() +"  "+cc.getPos3() +"  "+cc.getPos4());
		}
		
		cc = vc.verificaVertical(jogadaHorizontalCampeao);				
		assertEquals(cc.isTemCampeao(),false);
		
		
	}
	
	@Test
	public void jogadaHorizontal() {
		
		System.out.println("/nIniciando Teste... CampeaoTest");
		System.out.println("Jogada Horizontal");
		CheckCampeao cc = vc.verificaHorizontal(jogadaHorizontalCampeao);				
		assertEquals(cc.isTemCampeao(),true);
		if(cc.isTemCampeao()) {
			System.out.println(cc.getCor());
			System.out.println(cc.getPos1() +"  "+cc.getPos2() +"  "+cc.getPos3() +"  "+cc.getPos4());
		}
		
	}
}
