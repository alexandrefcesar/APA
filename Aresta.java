package Apa;

public class Aresta implements Comparable<Aresta> {
	public int origem;
	public int destino;
	public int peso;

	public Aresta(int origem, int destino, int peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}

	public int compareTo(Aresta comparaAresta) {
		return this.peso - comparaAresta.peso;
	}

};