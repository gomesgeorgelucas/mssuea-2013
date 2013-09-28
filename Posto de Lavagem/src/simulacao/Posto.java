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
	
	private double tempoDeOperacao;
	private int quantidadeDeLavaJatos;
	private int carrosLavados;
	private int carrosNaoLavados;
	
	private Fila areaDeEspera = new Fila(true);
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


	public double getTempoDeOperacao() {
		return tempoDeOperacao;
	}


	public void setTempoDeOperacao(double tempoDeOperacao) {
		this.tempoDeOperacao = tempoDeOperacao;
	}


	public int getQuantidadeDeLavaJatos() {
		return quantidadeDeLavaJatos;
	}


	public void setQuantidadeDeLavaJatos(int quantidadeDeLavaJatos) {
		this.quantidadeDeLavaJatos = quantidadeDeLavaJatos;
	}


	public int getCarrosLavados() {
		return carrosLavados;
	}


	public void setCarrosLavados(int carrosLavados) {
		this.carrosLavados = carrosLavados;
	}


	public int getCarrosNaoLavados() {
		return carrosNaoLavados;
	}


	public void setCarrosNaoLavados(int carrosNaoLavados) {
		this.carrosNaoLavados = carrosNaoLavados;
	}
	
	/**
	 * Método para criar lava-jatos do posto.
	 */
	public void criaLavaJatos() {
		
		for (int i=0; i <= this.getQuantidadeDeLavaJatos(); i++) {
			 this.getMeusLavaJatos().add(new LavaJato());
		}
	}
	
	/**
	 * Construtor da classe Posto
	 * @param quantidadeDeLavaJatos
	 * @param tempoDeOperacao
	 */
	public Posto(int quantidadeDeLavaJatos, double tempoDeOperacao) {
		this.setQuantidadeDeLavaJatos(quantidadeDeLavaJatos);
		this.setTempoDeOperacao(tempoDeOperacao);
		
		 
		
		this.criaLavaJatos();
		
	}
	
	
}
