package simulacao;

import java.util.ArrayList;

/**
 * Esta classe modela um posto de lava-jatos.
 * O posto deve operar por um tempo determinado.
 * O poste deve ter uma quantidade fixa de lava-jatos.
 * Carros podem ficar sem ser lavados no fim do tempo de operação.
 * @author George Lucas Gomes
 * @author Luiz Sergio
 *
 */

public class Posto {
	 
	private int tempoDeOperacao;
	private int quantidadeDeLavaJatos;
	
	private Fila areaDeEspera = new Fila();
	private ArrayList<LavaJato> meusLavaJatos = new ArrayList<LavaJato>();

	public Fila getAreaDeEspera() {
		return areaDeEspera;
	}

	public void setAreaDeEspera(Fila areaDeEspera) {
		this.areaDeEspera = areaDeEspera;
	}
	
	public ArrayList<LavaJato> getMeusLavaJatos() {
		return meusLavaJatos;
	}


	public void setMeusLavaJatos(ArrayList<LavaJato> meusLavaJatos) {
		this.meusLavaJatos = meusLavaJatos;
	}


	public int getTempoDeOperacao() {
		return tempoDeOperacao;
	}


	public void setTempoDeOperacao(int tempoDeOperacao) {
		this.tempoDeOperacao = tempoDeOperacao;
	}


	public int getQuantidadeDeLavaJatos() {
		return quantidadeDeLavaJatos;
	}


	public void setQuantidadeDeLavaJatos(int quantidadeDeLavaJatos) {
		this.quantidadeDeLavaJatos = quantidadeDeLavaJatos;
	}


	public boolean isAreaEsperaVazia() { 
		return this.getAreaDeEspera().isEmpty();
	}
	
	public void setMaxTamFila(int maxTamFila) {
		this.getAreaDeEspera().setMaxTamFila( maxTamFila );
	}
	
	/**
	 * Método para criar lava-jatos do posto.
	 */
	public void criaLavaJatos() {
		
		for (int i=0; i < this.getQuantidadeDeLavaJatos(); i++) {
			 this.getMeusLavaJatos().add(new LavaJato());
		}
	}
	
	/**
	 * Construtor da classe Posto
	 * @param quantidadeDeLavaJatos
	 * @param tempoDeOperacao
	 */
	public Posto( int quantidadeDeLavaJatos, int tempoDeOperacao ) {
		this.setQuantidadeDeLavaJatos(quantidadeDeLavaJatos);
		this.setTempoDeOperacao(tempoDeOperacao);
		
		 
		
		this.criaLavaJatos();
		
	}
	
	//Método utilizado pra lavar um carro
	public float lavar( Carro carro, LavaJato lj ) {
		lj.setEmUso( true );
		System.out.println( "Lavando Carro" );
		if( carro.getEstadoDeSujeira().equals( "QuaseLimpo" ) ) {
			lj.setTempoFinalLavagem( this.tempoDeOperacao - lj.getTempoQuaseLimpo() );
			return lj.getTempoQuaseLimpo();
		} else if( carro.getEstadoDeSujeira().equals( "Sujo" ) ) {
			lj.setTempoFinalLavagem( this.tempoDeOperacao - lj.getTempoSujo() );
			return lj.getTempoSujo();
		}else {
			lj.setTempoFinalLavagem( this.tempoDeOperacao - lj.getTempoBemSujo() );
			return lj.getTempoBemSujo();
		}
		
	}
	
	public float getTempoEspera( Carro carro ) {
		return carro.getTempoInicialFila() - this.tempoDeOperacao;
	}
	
	//"Passa" o tempo na simulação
	public void diminuirTempo( int tempo ) {
		this.tempoDeOperacao -= tempo;
	}
}
