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
	private String[][] jogadaDiagonalSuperiorCampeao = new String[8][8];
	private String[][] jogadaDiagonalInferiorCampeao = new String[8][8];
	
	
	
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
		jogadaHorizontalCampeao[4][3] = "azul";
		
		jogadaDiagonalSuperiorCampeao[2][0] = "laranja";
		jogadaDiagonalSuperiorCampeao[3][0] = "azul";//
		jogadaDiagonalSuperiorCampeao[4][0] = "azul";
		jogadaDiagonalSuperiorCampeao[4][1] = "laranja";//
	
		jogadaDiagonalSuperiorCampeao[0][0] = "laranja";
		jogadaDiagonalSuperiorCampeao[1][0] = "laranja";
		jogadaDiagonalSuperiorCampeao[4][2] = "azul";
		jogadaDiagonalSuperiorCampeao[3][1] = "laranja";
	
		
		jogadaDiagonalSuperiorCampeao[5][1] = "azul";
		jogadaDiagonalSuperiorCampeao[5][2] = "laranja";//
		jogadaDiagonalSuperiorCampeao[5][3] = "laranja";
		jogadaDiagonalSuperiorCampeao[5][0] = "azul";
		
		jogadaDiagonalSuperiorCampeao[6][1] = "azul";
		jogadaDiagonalSuperiorCampeao[6][2] = "azul";
		jogadaDiagonalSuperiorCampeao[6][3] = "laranja";//
		jogadaDiagonalSuperiorCampeao[6][0] = "laranja";
		
		jogadaDiagonalSuperiorCampeao[7][0] = "azul";
		jogadaDiagonalSuperiorCampeao[7][1] = "azul";
		jogadaDiagonalSuperiorCampeao[7][2] = "azul";
		jogadaDiagonalSuperiorCampeao[7][3] = "laranja";
		jogadaDiagonalSuperiorCampeao[7][4] = "laranja";//
		jogadaDiagonalSuperiorCampeao[7][5] = "azul";
		
		
		jogadaDiagonalSuperiorCampeao[5][5] = "laranja";//
		jogadaDiagonalSuperiorCampeao[5][4] = "laranja";
		jogadaDiagonalSuperiorCampeao[0][1] = "azul";
		jogadaDiagonalSuperiorCampeao[1][1] = "azul";
		jogadaDiagonalSuperiorCampeao[1][3] = "laranja";
		jogadaDiagonalSuperiorCampeao[1][2] = "azul";
		
		
////
		
		jogadaDiagonalInferiorCampeao[2][0] = "laranja";
		jogadaDiagonalInferiorCampeao[3][0] = "azul";
		jogadaDiagonalInferiorCampeao[4][0] = "azul";
		jogadaDiagonalInferiorCampeao[1][1] = "laranja";
	
		jogadaDiagonalInferiorCampeao[4][1] = "laranja";
		jogadaDiagonalInferiorCampeao[4][3] = "azul";
		jogadaDiagonalInferiorCampeao[4][2] = "azul";
		jogadaDiagonalInferiorCampeao[4][4] = "laranja";//
	
		
		jogadaDiagonalInferiorCampeao[5][1] = "azul";
		jogadaDiagonalInferiorCampeao[5][2] = "laranja";
		jogadaDiagonalInferiorCampeao[5][3] = "laranja";//
		jogadaDiagonalInferiorCampeao[5][0] = "azul";
		
		jogadaDiagonalInferiorCampeao[6][1] = "azul";
		jogadaDiagonalInferiorCampeao[6][2] = "laranja";//
		jogadaDiagonalInferiorCampeao[6][3] = "azul";
		jogadaDiagonalInferiorCampeao[6][0] = "laranja";
		
		jogadaDiagonalInferiorCampeao[7][0] = "azul";
		jogadaDiagonalInferiorCampeao[7][1] = "laranja";//
		jogadaDiagonalInferiorCampeao[7][2] = "azul";
		jogadaDiagonalInferiorCampeao[7][3] = "azul";
		jogadaDiagonalInferiorCampeao[7][4] = "azul";
		jogadaDiagonalInferiorCampeao[7][5] = "azul";
		
		
		jogadaDiagonalInferiorCampeao[5][5] = "laranja";
		jogadaDiagonalInferiorCampeao[5][4] = "laranja";
		jogadaDiagonalInferiorCampeao[0][1] = "azul";
		jogadaDiagonalInferiorCampeao[1][4] = "azul";
		jogadaDiagonalInferiorCampeao[1][3] = "laranja";
		jogadaDiagonalInferiorCampeao[1][2] = "azul";
		
	}
	
	@Test
	public void jogadaDiagonalSuperior() {
		System.out.println("/nIniciando Teste... CampeaoTest");
		System.out.println("Jogada DiagonalSuperior");
		CheckCampeao cc;
		cc = vc.verificaDiagonal(jogadaDiagonalSuperiorCampeao);				
		assertEquals(cc.isTemCampeao(),true);
		if(cc.isTemCampeao()) {
			System.out.println(cc.getCor());
			System.out.println(cc.getPos1() +"  "+cc.getPos2() +"  "+cc.getPos3() +"  "+cc.getPos4());
		}
		
		jogadaDiagonalSuperiorCampeao[5][2] = "azul";//
		cc = vc.verificaDiagonal(jogadaDiagonalSuperiorCampeao);	
		assertEquals(cc.isTemCampeao(),false);
		
		
	}
	
	
	@Test
	public void jogadaDiagonalInferior() {
		CheckCampeao cc = new CheckCampeao();
		System.out.println("/nIniciando Teste... CampeaoTest");
		System.out.println("Jogada Inferior");
	
		cc = vc.verificaDiagonalInferior(jogadaDiagonalInferiorCampeao,cc);				
		assertEquals(cc.isTemCampeao(),true);
		if(cc.isTemCampeao()) {
			System.out.println(cc.getCor());
			System.out.println(cc.getPos1() +"  "+cc.getPos2() +"  "+cc.getPos3() +"  "+cc.getPos4());
		}
		jogadaDiagonalInferiorCampeao[4][4] = "azul";
		cc = vc.verificaDiagonalInferior(jogadaDiagonalInferiorCampeao,cc);		
		assertEquals(cc.isTemCampeao(),false);
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
		
		cc = vc.verificaHorizontal(jogadaDiagonalSuperiorCampeao);				
		assertEquals(cc.isTemCampeao(),false);
		
	}
}
