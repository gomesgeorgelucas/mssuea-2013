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
	private int tempoNaFila;
	private int tamFila;
	private int maxTamFila;
	
	private ArrayList<Carro> myList = new ArrayList<Carro>();

	
	
	public int getTamFila() {
		return tamFila;
	}

	public void setTamFila(int tamFila) {
		this.tamFila = tamFila;
	}

	public int getMaxTamFila() {
		return maxTamFila;
	}

	public void setMaxTamFila(int maxTamFila) {
		this.maxTamFila = maxTamFila;
	}

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
	
	public int getTempoNaFila() {
		return tempoNaFila;
	}

	public void setTempoNaFila(int tempoNaFila) {
		this.tempoNaFila = tempoNaFila;
	}
	
	public void adicionaNaFila(Carro carro) {
		this.getMyList().add(carro);
		if (this.getMyList().size() < this.getMaxTamFila())
			this.setTamFila(this.getTamFila()+1);
		
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
	
	public Fila(boolean filaVazia, int maxTam) {
		this.setFilaVazia(filaVazia);
		this.setMaxTamFila(maxTam);
	}
	
	
}
