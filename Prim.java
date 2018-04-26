package Apa;

import java.util.ArrayList;

public class Prim {

	public static ArrayList<Aresta> mst(Grafo g) {

		// checando o grafo
		if (g.estaVazio()) {
			throw new NullPointerException("O grafo est� vazio");
		}

		ArrayList<Aresta> result = new ArrayList<Aresta>();

		ArrayList<ArrayList<Aresta>> adj = gerandoArestaAdjacencyGrafo(g);

		FilaDePrioridades peq = new FilaDePrioridades();
		for (int i = 0; i < adj.get(0).size(); i++) {
			Aresta e = adj.get(0).get(i);
			peq.add(e);
		}

		//
		// Marque o primeiro v�rtice como visitado.
		boolean[] visitado = new boolean[g.E];
		visitado[0] = true;

		// enquanto contem arestas a arvore n�o est� completa

		while (!peq.estaVazio()) {

			// Retorne e remova a aresta mais pr�xima na fila de arestas prioritarias.
			Aresta e = peq.poll();

			// Se qualquer v�rtice nessa borda tiver sido visitado, continue.
			if (visitado[e.origem] && visitado[e.destino])
				continue;

			// Marque este v�rtice da fonte das arestas como visitado.
			visitado[e.origem] = true;

			// Olhe atrav�s de cada aresta que compartilha o v�rtice de arestas de arestas
			// estouradas
			for (Aresta edge : adj.get(e.destino)) {

				// Se o v�rtice da aresta da aresta rec�m-checada tamb�m nunca foi visitado ...
				if (!visitado[edge.destino]) {

					// Adiciona na fila!
					peq.add(edge);
				}
			}

			// Marque esse v�rtice de destino de arestas como visitado.
			visitado[e.destino] = true;

			// Adicione esta aresta a arvoreminina.
			result.add(e);
		}
		return result;
	}

	private static ArrayList<ArrayList<Aresta>> gerandoArestaAdjacencyGrafo(Grafo g) {
		ArrayList<ArrayList<Aresta>> G = new ArrayList<>();
		for (int i = 0; i < g.E; i++) {
			G.add(new ArrayList<>());
		}
		for (int i = 0; i < g.E; i++) {
			Aresta aresta = g.aresta[i];
			Aresta reverse = new Aresta(aresta.destino, aresta.origem, aresta.peso);

			G.get(aresta.origem).add(aresta);
			G.get(aresta.destino).add(reverse);
		}

		return G;
	}
}
