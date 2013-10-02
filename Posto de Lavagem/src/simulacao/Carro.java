package simulacao;

/**
 * Classe para modelar um carro que chega no lava-jato.
 * @author George Lucas Gomes
 * @author Luiz Sergio
 *
 */
public class Carro {
	private String estadoDeSujeira;

	public String getEstadoDeSujeira() {
		return estadoDeSujeira;
	}
 
	public void setEstadoDeSujeira(String estadoDeSujeira) {
		this.estadoDeSujeira = estadoDeSujeira;
	}
	
	/**
	 * Construtor da classe Carro.
	 * @param estadoDeSujeira
	 */
	public Carro (String estadoDeSujeira) {
		this.setEstadoDeSujeira(estadoDeSujeira);
	}
	
}
