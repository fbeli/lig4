<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width" />
<title>usuarios</title>


	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"	rel="stylesheet"></link>	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>

<body onload="verificaCor()">


<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	
<style type="text/css">
<!--
.azul{
background-color:#0af;
}
.laranja{
background-color:#f06;
}
.vazio{
background-color:#fff;
}
-->
</style>


<script>

var minhavez = false;
var intervalId = 0;
//faz com que a cada 3 segundos a chamada seja feita
intervalId = setInterval(aguardaOponente, 2000);
var cor = "";

function aguardaOponente(){
	
	
		$.ajax({
	        url : 'respostaOponente',
	        data : {
				cor : cor
	        }
		}).done( function(data) {
				if(null != data){
					if(data.apagarTudo){
						zerar();
						alert("seu oponente reiniciou o jogo");
						
					}else{
						tag = "#"+data.colunalinha;
						$(tag).removeClass("vazio");
						$(tag).addClass(data.cor);
		            	//alert("oponente: "+data.cor + " jogou: "+data.colunalinha);
		            	//minhavez = true;
					}
					if(data.cor == "azul"){
						$("#vez").removeClass("azul");
						$("#vez").addClass("laranja");
					}else{
						$("#vez").removeClass("laranja");
						$("#vez").addClass("azul");
					}
				}
			
	    });
	
}
function verificaCor(){

	$.ajax({
		url : 'cor'
	}).done(function(msg){

		//alert(msg);
		cor = msg;
		$("#divCor").addClass(cor);
		
		//ajustaVez(cor);
	});

	
}	
function ajustaVez(cor){
	if(cor=="azul"){
		minhavez = true;
	}
}
function alteraVez(){
	if(false == minhavez)
		minhavez = true;
	else
		minhavez=false;
}
function encaixaFicha(logColuna) {
	//if(minhavez){
		$.ajax({
			url : 'jogada',
			data : {
				coluna : logColuna,
				cor : cor
			}		
		}).done(function(msg){
			
			tag = "#"+msg;
			$(tag).removeClass("vazio");
			$(tag).addClass(cor);
			alteraVez();
		} );
		
	//}
}

function reiniciar(){
	zerar();
	$.ajax({
		url : 'reiniciar'
				
	});
	
}
function zerar(){
   coluna = 0; // max 12
   linha = 0; //max 8
   msg = "";
   linhaColuna = "";
	for(coluna = 0; coluna <8; coluna++){
		for(linha =0; linha <8;linha++){
				tag = "#"+"0"+coluna+"0"+linha; 
			
			$(tag).addClass("vazio");
			
		}
	}
}

</script>

	<div class="container has-text-centered panel panel-default">
		<div class="panel-heading mx-auto">Lig 4</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-4" > 
				<div id="divCor"> <p > Sua cor</p></div> 
			</div>
			<div class="col-4" > 
				<button class="btn btn-sm btn-primary" onclick="reiniciar();"> Reiniciar</button> 
			</div>
			<div class="col-4" >  
				<p id="vez">Cor da Jogada</p> 
			</div>
		</div>
	</div>
	<div class="row">
	<div class="col-2">
	</div>

	<div class="col-8">
	<div class="row justify-content-md-center">
				<div class="col-1"  onclick="encaixaFicha(00);" id="0007" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>
		
		<div class="col-1"  onclick="encaixaFicha(01);" id="0107" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>

		<div class="col-1"  onclick="encaixaFicha(02);" id="0207" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%">
		</div>

		<div class="col-1" id="0307" onclick="encaixaFicha(03);" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1 "  id="0407" style="margin: 0; padding: 0;" onclick="encaixaFicha(04);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1" id="0507" style="margin: 0; padding: 0;" onclick="encaixaFicha(05);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%" >
		</div>

		<div class="col-1" id="0607" style="margin: 0; padding: 0;" onclick="encaixaFicha(06);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		<div class="col-1" id="0707"  style="margin: 0; padding: 0;" onclick="encaixaFicha(07);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		
			</div>
	
	<div class="row justify-content-md-center">
				<div class="col-1"  onclick="encaixaFicha(00);" id="0006" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>
		
		<div class="col-1"  onclick="encaixaFicha(01);" id="0106" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>

		<div class="col-1"  onclick="encaixaFicha(02);" id="0206" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%">
		</div>

		<div class="col-1" id="0306" onclick="encaixaFicha(03);" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1 "  id="0406" style="margin: 0; padding: 0;" onclick="encaixaFicha(04);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1" id="0506" style="margin: 0; padding: 0;" onclick="encaixaFicha(05);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%" >
		</div>

		<div class="col-1" id="0606" style="margin: 0; padding: 0;" onclick="encaixaFicha(06);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		<div class="col-1" id="0706"  style="margin: 0; padding: 0;" onclick="encaixaFicha(07);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

	
			</div>

		<div class="row justify-content-md-center">
				<div class="col-1"  onclick="encaixaFicha(00);" id="0005" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>
		
		<div class="col-1"  onclick="encaixaFicha(01);" id="0105" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>

		<div class="col-1"  onclick="encaixaFicha(02);" id="0205" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%">
		</div>

		<div class="col-1" id="0305" onclick="encaixaFicha(03);" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1 "  id="0405" style="margin: 0; padding: 0;" onclick="encaixaFicha(04);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1" id="0505" style="margin: 0; padding: 0;" onclick="encaixaFicha(05);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%" >
		</div>

		<div class="col-1" id="0605" style="margin: 0; padding: 0;" onclick="encaixaFicha(06);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		<div class="col-1" id="0705"  style="margin: 0; padding: 0;" onclick="encaixaFicha(07);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

	
			</div>
	
		<div class="row justify-content-md-center">
				<div class="col-1"  onclick="encaixaFicha(00);" id="0004" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>
		
		<div class="col-1"  onclick="encaixaFicha(01);" id="0104" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>

		<div class="col-1"  onclick="encaixaFicha(02);" id="0204" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%">
		</div>

		<div class="col-1" id="0304" onclick="encaixaFicha(03);" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1 "  id="0404" style="margin: 0; padding: 0;" onclick="encaixaFicha(04);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1" id="0504" style="margin: 0; padding: 0;" onclick="encaixaFicha(05);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%" >
		</div>

		<div class="col-1" id="0604" style="margin: 0; padding: 0;" onclick="encaixaFicha(06);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		<div class="col-1" id="0704"  style="margin: 0; padding: 0;" onclick="encaixaFicha(07);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

	
			</div>
	
	
	<div class="row justify-content-md-center">
				<div class="col-1"  onclick="encaixaFicha(00);" id="0003" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>
		
		<div class="col-1"  onclick="encaixaFicha(01);" id="0103" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>

		<div class="col-1"  onclick="encaixaFicha(02);" id="0203" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%">
		</div>

		<div class="col-1" id="0303" onclick="encaixaFicha(03);" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1 "  id="0403" style="margin: 0; padding: 0;" onclick="encaixaFicha(04);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1" id="0503" style="margin: 0; padding: 0;" onclick="encaixaFicha(05);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%" >
		</div>

		<div class="col-1" id="0603" style="margin: 0; padding: 0;" onclick="encaixaFicha(06);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		<div class="col-1" id="0703"  style="margin: 0; padding: 0;" onclick="encaixaFicha(07);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

	
			</div>

	<div class="row justify-content-md-center">
		<div class="col-1"  onclick="encaixaFicha(00);" id="0002" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>
		
		<div class="col-1"  onclick="encaixaFicha(01);" id="0102" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>

		<div class="col-1"  onclick="encaixaFicha(02);" id="0202" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%">
		</div>

		<div class="col-1" id="0302" onclick="encaixaFicha(03);" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1 "  id="0402" style="margin: 0; padding: 0;" onclick="encaixaFicha(04);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1" id="0502" style="margin: 0; padding: 0;" onclick="encaixaFicha(05);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%" >
		</div>

		<div class="col-1" id="0602" style="margin: 0; padding: 0;" onclick="encaixaFicha(06);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		<div class="col-1" id="0702"  style="margin: 0; padding: 0;" onclick="encaixaFicha(07);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

			
	</div>



	<div class="row justify-content-md-center">
				<div class="col-1"  onclick="encaixaFicha(00);" id="0001" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>
		
		<div class="col-1"  onclick="encaixaFicha(01);" id="0101" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>

		<div class="col-1"  onclick="encaixaFicha(02);" id="0201" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%">
		</div>

		<div class="col-1" id="0301" onclick="encaixaFicha(03);" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1 "  id="0401" style="margin: 0; padding: 0;" onclick="encaixaFicha(04);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1" id="0501" style="margin: 0; padding: 0;" onclick="encaixaFicha(05);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%" >
		</div>

		<div class="col-1" id="0601" style="margin: 0; padding: 0;" onclick="encaixaFicha(06);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		<div class="col-1" id="0701"  style="margin: 0; padding: 0;" onclick="encaixaFicha(07);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

			
	</div>






	
	<div class="row justify-content-md-center">
				<div class="col-1"  onclick="encaixaFicha(00);" id="0000" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%" >
		</div>
		
		<div class="col-1"  onclick="encaixaFicha(01);" id="0100" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%"	height="100%">
		</div>

		<div class="col-1"  onclick="encaixaFicha(02);" id="0200" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%">
		</div>

		<div class="col-1" id="0300" onclick="encaixaFicha(03);" style="margin: 0; padding: 0;">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1 "  id="0400" style="margin: 0; padding: 0;" onclick="encaixaFicha(04);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%">
		</div>

		<div class="col-1" id="0500" style="margin: 0; padding: 0;" onclick="encaixaFicha(05);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" height="100%" >
		</div>

		<div class="col-1" id="0600" style="margin: 0; padding: 0;" onclick="encaixaFicha(06);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

		<div class="col-1" id="0700"  style="margin: 0; padding: 0;" onclick="encaixaFicha(07);">
			<img src="/images/vazio.png" alt="jogue aqui" width="100%" 	height="100%" >
		</div>

	
		
	</div>
			
	</div> 
</body>
</html>