package simulacao;

/**
 * Classe para modelar um carro que chega no lava-jato.
 * @author George Lucas Gomes
 * @author Luiz Sergio
 *
 */
public class Carro {
	private String estadoDeSujeira;
	private float tempoInicialFila;

	public String getEstadoDeSujeira() {
		return estadoDeSujeira;
	}
 
	public void setEstadoDeSujeira(String estadoDeSujeira) {
		this.estadoDeSujeira = estadoDeSujeira;
	}
	
	public float getTempoInicialFila() {
		return tempoInicialFila;
	}

	public void setTempoInicialFila(float tempoEspera) {
		this.tempoInicialFila = tempoEspera;
	}

	/**
	 * Construtor da classe Carro.
	 * @param estadoDeSujeira
	 */
	public Carro (String estadoDeSujeira) {
		this.setEstadoDeSujeira(estadoDeSujeira);
	}
	
}
