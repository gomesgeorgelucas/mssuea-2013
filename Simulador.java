package simulacao;

import java.io.ObjectInputStream.GetField;
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
			
			if (tempo%taxaDeChegada == 0) {
				if (((tempo/taxaDeChegada)-1) <= 39)
					myPosto.getAreaDeEspera().
						adicionaNaFila(carrosDia.get((tempo/taxaDeChegada)-1));
				else
					System.out.println("Full");
			}
			
			if (myPosto.getAreaDeEspera().isFilaVazia() == false) {
				myPosto.getAreaDeEspera().removeDaFila(myPosto.getAreaDeEspera().getMyList().get(0));
				myPosto.getMeusLavaJatos().
					get(myPosto.getQuantidadeDeLavaJatos()-1).
						setEmUso(true);
			}
			
			
			
		}
		
		
		
		
		
		
		

	}

}
