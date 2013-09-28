package simulacao;

import java.util.ArrayList;

/**
 * Classe que modela um lava-jato com 3 níves de operação.
 * Os 3 níveis são: Quase Limpo, Sujo e Bem Sujo.
 * O lava-jato pode indicar o seu estado de operação.
 * @author Luiz Sergio
 *
 */
public class LavaJato {
	private double tempoQuaseLimpo;
	private double tempoSujo;
	private double tempoBemSujo;
	private boolean emUso;
	
	private ArrayList<String> estadoDosCarro = new ArrayList<String>(); 
	
	public double getTempoQuaseLimpo() {
		return tempoQuaseLimpo;
	}	
	
	public ArrayList<String> getEstadoDosCarro() {
		return estadoDosCarro;
	}

	public void setEstadoDosCarro(ArrayList<String> estadoDosCarro) {
		this.estadoDosCarro = estadoDosCarro;
	}

	public void setTempoQuaseLimpo(double tempoQuaseLimpo) {
		this.tempoQuaseLimpo = tempoQuaseLimpo;
	}

	public double getTempoSujo() {
		return tempoSujo;
	}

	public void setTempoSujo(double tempoSujo) {
		this.tempoSujo = tempoSujo;
	}

	public double getTempoBemSujo() {
		return tempoBemSujo;
	}

	public void setTempoBemSujo(double tempoBemSujo) {
		this.tempoBemSujo = tempoBemSujo;
	}	
	
	public boolean isEmUso() {
		return emUso;
	}

	public void setEmUso(boolean emUso) {
		this.emUso = emUso;
	}

	/**
	 * Construtor da classe LavaJato
	 * @param tempoQuaseLimpo
	 * @param tempoSujo
	 * @param tempoBemSujo
	 */
	public LavaJato(double tempoQuaseLimpo, double tempoSujo, double tempoBemSujo) {
		this.setTempoBemSujo(tempoBemSujo);
		this.setTempoQuaseLimpo(tempoQuaseLimpo);
		this.setTempoSujo(tempoSujo);
	}
	
	/**
	 * Construtor abstrato da classe LavaJato.
	 */
	public LavaJato() {
		
	}

}
