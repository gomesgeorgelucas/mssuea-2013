package simulacao;

import java.util.ArrayList;

/**
 * Classe que modela uma fila no lava-jato.
 * A fila pode estar vazia.
 * O tempo de cada elemento na fila deve ser gravado.
 * @author George Lucas Gomes
 *
 */
public class Fila {
	
	private boolean filaVazia;
	private boolean tempoNaFila;
	
	private ArrayList<Carro> myList = new ArrayList<Carro>();

	public boolean isFilaVazia() {
		return filaVazia;
	}

	public void setFilaVazia(boolean filaVazia) {
		this.filaVazia = filaVazia;
	}

	public ArrayList<Carro> getMyList() {
		return myList;
	}

	public void setMyList(ArrayList<Carro> myList) {
		this.myList = myList;
	}
	
	public boolean isTempoNaFila() {
		return tempoNaFila;
	}

	public void setTempoNaFila(boolean tempoNaFila) {
		this.tempoNaFila = tempoNaFila;
	}
	
	public void adicionaNaFila(Carro carro) {
		this.getMyList().add(carro);
	}
	
	public void removeDaFila(Carro carro) {
		if (this.getMyList().contains(carro) &&
				this.getMyList().get(this.getMyList().indexOf(carro)).hashCode() == carro.hashCode()) {
			this.getMyList().remove(this.getMyList().indexOf(carro));			
		}
			
	}

	public Fila(boolean filaVazia) {
		this.setFilaVazia(filaVazia);
	}
	
	
	
}
