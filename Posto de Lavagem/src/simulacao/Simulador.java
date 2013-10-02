package simulacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Classe de testes para um posto a definir.
 * @author George Lucas Gomes
 * @author Luiz Sergio
 *
 */
public class Simulador {
	
	public static String geraEstadoDeSujeira() {
		Random randomGen = new Random();
		
		if ((randomGen.nextInt(3)+1) == 1)
			return "QuaseLimpo";
		else if ((randomGen.nextInt(3)+1) == 2)
			return "Sujo";
		else			
			return "BemSujo";
	}
	 
	public static void main(String[] args) throws IOException {
		int tempoChegadas = 0;
		int tempoAtendimento = 0;
		float qtdCarrosAtendidos = 0;
		float qtdCarrosPerdidos = 0;
		FileWriter fw = new FileWriter("resultados.txt", true);
		BufferedWriter out = new BufferedWriter( fw );
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
	
		for( int i = 0; i < 30; i++ ) {
			//Cria um posto com 1 lava jato e que trabalha
			//600 minutos por dia(10 horas)
			Posto myPosto = new Posto( 1, 600 );
			Random rand = new Random();
			
			//Começar casos
			
			/**
			 * Caso 1:
			 *  Será que a área de espera disponível (para no máximo quatro
			 *	automóveis) é suficiente?
	 		 *	Será que o tempo de serviço é aceitável?
	 		 *	Será que a produtividade do operador é adequada?
			 */	
			//Quantidade de carros que foram embora por não ter mais vaga na área de espera
			int carrosPerdidos = 0;
			//Quantidade de carros lavados
			int carrosLavados = 0;
			//Define area de espera para 4 carros
			myPosto.setMaxTamFila(4);
			
			//Cada máquina tem um tempo de lavagem diferente?
			myPosto.getMeusLavaJatos().get(0).setTempoSujo(10);
			myPosto.getMeusLavaJatos().get(0).setTempoQuaseLimpo(10);
			myPosto.getMeusLavaJatos().get(0).setTempoBemSujo(10);
		
			while( myPosto.getTempoDeOperacao() > 0 ) {
				Carro carro = new Carro( geraEstadoDeSujeira() );
				//Atributo que verifica se o carro que chegou conseguiu ir direto pra máquina ou vai para a fila
				boolean isLavando = false;
				//tempo de chegada entre 5 e 15 unidades de tempo
				int tempoChegada = 5 + rand.nextInt( 11 );
				//Passa o tempo na simulação
				myPosto.diminuirTempo( tempoChegada );
				
				//Verifica se tem algum lava jato disponível no momento
				for( LavaJato lj : myPosto.getMeusLavaJatos() ) {
					//Verifica se o carro que estava usando o lava jato já foi lavado
					if( lj.getTempoFinalLavagem() != 0 && myPosto.getTempoDeOperacao() <= lj.getTempoFinalLavagem() ) {
						lj.setEmUso( false );
					}
					
					//Se não estiver em uso, verifica se existe algum carro na fila. Se não existir, começa o processo para o carro que chegou.
					if( !lj.isEmUso() ) {
						if( myPosto.getAreaDeEspera().isEmpty() ) {
							myPosto.lavar( carro, lj );
							isLavando = true;
						}else{
							myPosto.lavar( myPosto.getAreaDeEspera().pegaPrimeiroDaFila(), lj );
							myPosto.getAreaDeEspera().removeDaFila( myPosto.getAreaDeEspera().pegaPrimeiroDaFila() );
							isLavando = false;
						}
						carrosLavados++;
					}
				}
				
				//Se não conseguiu ir direto para o lava jato, verifica se tem vaga disponível na area de espera.
				if ( !isLavando && myPosto.getAreaDeEspera().temVaga() ) {
					myPosto.getAreaDeEspera().adicionaNaFila( carro );
				}
				
				//Não conseguiu vaga na área de espera
				if( !isLavando && !myPosto.getAreaDeEspera().temVaga() ) {
					System.out.println( "Carro foi embora por não ter mais vagas!" );
					carrosPerdidos++;
				}
				
			}
			qtdCarrosAtendidos += carrosLavados;
			qtdCarrosPerdidos += carrosPerdidos;
			//escreve em um arquivo os resultados obtidos
			out.write( "Simulacao " + (i + 1) + ":\n" );
			out.write( "A quantidade de carros lavados foi de: " + carrosLavados + "\n" );
			out.write( "A quantidade de carros perdidos foi de: " + carrosPerdidos + "\n" );
			out.write( "------------------------------------------------------------------\n" );
	
		}
		out.write( "A media de carros atendidos e de: " + df.format( qtdCarrosAtendidos/30 ) + "\n" );
		out.write( "A media de carros perdidos e de: " + df.format( qtdCarrosPerdidos/30 ) + "\n" );
		out.close();
	}
}

