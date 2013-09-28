package simulacao;

import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		
		//Cria um posto com 1 lava jato e que trabalha
		//1440 minutos por dia
		Posto myPosto = new Posto(1, 1440);
		
		ArrayList<Carro> carrosDia = new ArrayList<Carro>();
		
		//Começar casos
		
		/**
		 * Caso 1:
		 *  Será que a área de espera disponível (para no máximo quatro
		 *	automóveis) é suficiente?
 		 *	Será que o tempo de serviço é aceitável?
 		 *	Será que a produtividade do operador é adequada?
		 */	
		
		//Define area de espera para 4 carros
		int quantidadeDeCarros = 40;
		int taxaDeChegada = 10;
		myPosto.getAreaDeEspera().setMaxTamFila(4);
		myPosto.getMeusLavaJatos().get(0).setTempoSujo(15);
		myPosto.getMeusLavaJatos().get(0).setTempoQuaseLimpo(10);
		myPosto.getMeusLavaJatos().get(0).setTempoBemSujo(25);
		
		
		//Gera carros com níves de sujeira variados
		for (int carro = 1; carro <= quantidadeDeCarros; carro++) {
			carrosDia.add(new Carro(geraEstadoDeSujeira()));
			//System.out.println(carrosDia.get(carro - 1).getEstadoDeSujeira());
		}
		
		for (int tempo = 1; tempo <= myPosto.getTempoDeOperacao(); tempo++) {
			
			//A cada tempo de chegada adiciona carro na fila
			if (tempo%taxaDeChegada == 0) {
				if (((tempo/taxaDeChegada)-1) <= 39) {
					//adiciona carro na fila
					
					//Se o carro que chegou, encontrar a fila cheia
					if (myPosto.getAreaDeEspera().getMyList().size()  ==
							myPosto.getAreaDeEspera().getMaxTamFila()) {
						
						//Adiciona carro não lavado
						myPosto.setCarrosNaoLavados(myPosto.getCarrosNaoLavados()+1);
						
					}
					
					myPosto.getAreaDeEspera().
						adicionaNaFila(carrosDia.get((tempo/taxaDeChegada)-1));
					
					//adiciona tempo de espera do carro
					myPosto.getAreaDeEspera().getTempoFila().add(new Integer(0));
					
					//adiciona um carro não lavado
					myPosto.setCarrosNaoLavados(myPosto.getCarrosNaoLavados()+1);
				
					
					//Next Op
				
				
				}
					else
					System.out.println("Maximum number of cars reached.");
				
			}//fecha if
			
			
			//incrementa o tempo dos carros na fila
			for (int i = 0; i < myPosto.getAreaDeEspera().getMyList().size(); i++ ) {
				myPosto.getAreaDeEspera().
					getTempoFila().set(i,myPosto.getAreaDeEspera().
							getTempoFila().get(i) + 1); 
			}//fecha if incremento
			
			
			//Fila não vazia - Remover carro da fila e Define o lava jato em uso
			if (!myPosto.getAreaDeEspera().isFilaVazia() &&
						!myPosto.getMeusLavaJatos().get(myPosto.
								getQuantidadeDeLavaJatos()-1).isEmUso() ) {
				
				//define em quanto tempo o carro será lavado
				myPosto.getMeusLavaJatos().
					get(myPosto.getQuantidadeDeLavaJatos()-1).
						getEstadoDosCarro().add(new String(myPosto.
								getAreaDeEspera().getMyList().
									get(0).getEstadoDeSujeira()));
				
				//remove carro da fila
				myPosto.getAreaDeEspera().
					removeDaFila(myPosto.
							getAreaDeEspera().
								getMyList().
									get(0));
				
				myPosto.getMeusLavaJatos().get(myPosto.
						getQuantidadeDeLavaJatos()-1).setEmUso(true);
				
				
				
				myPosto.setCarrosNaoLavados(myPosto.getCarrosNaoLavados() - 1);
				
				myPosto.setCarrosLavados(myPosto.getCarrosLavados() + 1);
				
			}//fecha if 
			
			//Define lava-jato ligado ou desligado
			
			
			
			
			if (myPosto.getMeusLavaJatos().get(myPosto.
					getQuantidadeDeLavaJatos()-1).isEmUso()) {
				
				if (myPosto.getMeusLavaJatos().
						get(myPosto.getQuantidadeDeLavaJatos()-1).
							getEstadoDosCarro().get(0).equals("Bem Sujo")) {
					
					if (tempo%myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								getTempoBemSujo() == 0) {
						
						myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								setEmUso(false);
						
						myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								getEstadoDosCarro().remove(0);
						
					}
					
				} else if (myPosto.getMeusLavaJatos().
						get(myPosto.getQuantidadeDeLavaJatos()-1).
							getEstadoDosCarro().get(0).equals("Sujo")) {
					
					if (tempo%myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								getTempoSujo() == 0) {
						
						myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								setEmUso(false);
						
						myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								getEstadoDosCarro().remove(0);
						
					}
					
					
				} else {
					
					if (tempo%myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								getTempoQuaseLimpo() == 0) {
						
						myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								setEmUso(false);
						
						myPosto.getMeusLavaJatos().
							get(myPosto.getQuantidadeDeLavaJatos()-1).
								getEstadoDosCarro().remove(0);
						
					}
				}
				
			}
			
			
			
			
		}//fecha for
		
		
		
		
		
		
		

	}
	
	public static void log (String message) {
		System.out.println(message);
	}

}
