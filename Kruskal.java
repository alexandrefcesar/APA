package Apa;

import java.util.ArrayList;

public class Kruskal {

	public static ArrayList<Aresta> mst(Grafo g) {

		if (g.estaVazio()) {
			throw new NullPointerException("The Graph is empty");
		}

		ArrayList<Aresta> result = new ArrayList<Aresta>();

		FilaDePrioridades peq = new FilaDePrioridades();
		for (int i = 0; i < g.E; i++) {
			peq.add(g.aresta[i]);
		}

		// cria subconjunto de todos os vertices
		SubConjunto subConjunto[] = new SubConjunto[g.V];
		for (int v = 0; v < g.V; ++v) {
			subConjunto[v] = new SubConjunto(v, 0);
		}

		// se a fila de aresta priorit�ria n�o estiver vazia, a arvore minima n�o estar�
		// completa.
		while (!peq.estaVazio()) {
			if (result.size() >= g.V - 1)
				break;

			// obter a aresta
			Aresta novaAresta = peq.poll();

			// Encontre subconjuntos baseados na origem e no destino da aresta atual.
			int x = find(subConjunto, novaAresta.origem);
			int y = find(subConjunto, novaAresta.destino);

			// Se o subconjunto y (destino) n�o for subconjunto x (origem), junte-os.
			if (x != y) {
				result.add(novaAresta);
				Union(subConjunto, x, y);
			}
		}

		return result;
	}

	// Retorna o v�rtice pai de um subconjunto. Se o pai ainda n�o est� definido

	private static int find(SubConjunto subConjunto[], int i) {
		if (subConjunto[i].ligado != i) {
			subConjunto[i].ligado = find(subConjunto, subConjunto[i].ligado);
		}

		return subConjunto[i].ligado;

	}

	// Uni�o, subconjunto X e subconjunto Y, com base na classifica��o.
	private static void Union(SubConjunto subConjunto[], int x, int y) {
		int xRaiz = find(subConjunto, x);
		int yRaiz = find(subConjunto, y);

		if (subConjunto[xRaiz].classificacao < subConjunto[yRaiz].classificacao) {
			subConjunto[xRaiz].ligado = yRaiz;
		} else if (subConjunto[xRaiz].classificacao > subConjunto[yRaiz].classificacao) {
			subConjunto[yRaiz].ligado = xRaiz;
		} else {
			subConjunto[yRaiz].ligado = xRaiz;
			subConjunto[xRaiz].classificacao++;
		}
	}
}
