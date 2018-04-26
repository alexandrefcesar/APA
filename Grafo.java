package Apa;

public class Grafo {
	public int V;
	public int E;
	public Aresta[] aresta;
	
	public Grafo(int v, int e) {
		V = v;
		E = e;
		aresta = new Aresta[E];
	}
	
//Retorna true se o gráfico inteiro NÃO estiver preenchido
	public boolean estaVazio() {
		for (int i = 0; i < E; i++) {
			if ( aresta[i] == null )
				return true;
		}
		
		return false;
	}
}
