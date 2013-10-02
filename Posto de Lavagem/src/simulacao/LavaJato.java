package simulacao;

import java.util.ArrayList;

/**
 * Classe que modela um lava-jato com 3 n�ves de opera��o.
 * Os 3 n�veis s�o: Quase Limpo, Sujo e Bem Sujo.
 * O lava-jato pode indicar o seu estado de opera��o.
 * @author Luiz Sergio
 *
 */
public class LavaJato {
	private int tempoQuaseLimpo;
	private int tempoSujo;
	private int tempoBemSujo;
	private boolean emUso;
	private int tempoFinalLavagem;
	
	private ArrayList<String> estadoDosCarro = new ArrayList<String>(); 
	
	public int getTempoQuaseLimpo() {
		return tempoQuaseLimpo;
	}	
	
	public ArrayList<String> getEstadoDosCarro() {
		return estadoDosCarro;
	}

	public void setEstadoDosCarro(ArrayList<String> estadoDosCarro) {
		this.estadoDosCarro = estadoDosCarro;
	}

	public void setTempoQuaseLimpo(int tempoQuaseLimpo) {
		this.tempoQuaseLimpo = tempoQuaseLimpo;
	}

	public int getTempoSujo() {
		return tempoSujo;
	}

	public void setTempoSujo(int tempoSujo) {
		this.tempoSujo = tempoSujo;
	}

	public int getTempoBemSujo() {
		return tempoBemSujo;
	}

	public void setTempoBemSujo(int tempoBemSujo) {
		this.tempoBemSujo = tempoBemSujo;
	}	
	
	public boolean isEmUso() {
		return emUso;
	}

	public void setEmUso(boolean emUso) {
		this.emUso = emUso;
	}
	
	public int getTempoFinalLavagem() {
		return tempoFinalLavagem;
	}

	public void setTempoFinalLavagem(int tempoFinalLavagem) {
		this.tempoFinalLavagem = tempoFinalLavagem;
	}

	/**
	 * Construtor da classe LavaJato
	 * @param tempoQuaseLimpo
	 * @param tempoSujo
	 * @param tempoBemSujo
	 */
	public LavaJato(int tempoQuaseLimpo, int tempoSujo, int tempoBemSujo) {
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
