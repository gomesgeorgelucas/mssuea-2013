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
	
	private int maxTamFila;
	
	private ArrayList<Carro> myList = new ArrayList<Carro>();

	public int getMaxTamFila() {
		return maxTamFila;
	}

	public void setMaxTamFila(int maxTamFila) {
		this.maxTamFila = maxTamFila;
	}

	public ArrayList<Carro> getMyList() {
		return myList;
	}

	public void setMyList(ArrayList<Carro> myList) {
		this.myList = myList;
	}
	
	public void adicionaNaFila(Carro carro) {
		System.out.println("Carro adicionado na fila");
		if (this.getMyList().size() < this.getMaxTamFila()){
			this.getMyList().add(carro);
		}
	}
	
	public void removeDaFila( Carro carro ) {
		if (this.getMyList().contains( carro ) ) 
			this.getMyList().remove( carro );			
	}
	
	public boolean isEmpty() {
		return this.getMyList().isEmpty();
	}
	
	public boolean temVaga() {
		return this.getMyList().size() < this.maxTamFila;
	}
	
	public Carro pegaPrimeiroDaFila() {
		return this.myList.get( 0 );
	}

	public Fila() {
	}
	
	public Fila( int maxTam ) {
		this.setMaxTamFila(maxTam);
	}
	
	
}
