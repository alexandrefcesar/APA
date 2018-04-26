package Apa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;




public class App {
	private static ArrayList lista;
	public static int auxNovo;
	public static Scanner dado = new Scanner(System.in);
	private static String operacao = null;
	private static String operacao1 = null;
	private static String operacao2 = null;
	private static int processo = 0;

	public static String decodificaOperacao(String s) {
		lista = Arquivo.lista();
		String Demo = s;
		StringTokenizer Tok = new StringTokenizer(Demo, " ");

		while (Tok.hasMoreElements()) {
			operacao = Tok.nextToken();
			operacao1 = Tok.nextToken();
			operacao2 = Tok.nextToken();

		}

		return operacao;
	}
	public static void main(String[] args) {

		int V = 5; // Numero of vertices (0,1,2,3,4)
		int E = 7; // Numero of arestas

		// criando o grafo
		Grafo g = new Grafo(V, E);
		g.aresta[0] = new Aresta(0, 1, 9);
		g.aresta[1] = new Aresta(0, 2, 8);
		g.aresta[2] = new Aresta(0, 3, 6);
		g.aresta[3] = new Aresta(1, 3, 12);
		g.aresta[4] = new Aresta(2, 3, 5);
		g.aresta[5] = new Aresta(1, 4, 7);
		g.aresta[6] = new Aresta(3, 4, 4);

		ArrayList<Aresta> mstKruskal = Kruskal.mst(g);

		System.out.println("Kruskal Arvore minima saída:\n");
		saida(mstKruskal);

		ArrayList<Aresta> mstPrims = Prim.mst(g);

		System.out.println("Prims Arvore minima saída:\n");
		saida(mstPrims);
	}

	private static void saida(ArrayList<Aresta> resultado) {
		int pesoTotal = 0;
		for (int i = 0; i < resultado.size(); ++i) {
			Aresta r = resultado.get(i);
			pesoTotal += r.peso;
			System.out.println( r.origem + " " + r.destino + " Peso: " + r.peso);
		}
		System.out.println();
		System.out.println("Numero of Vertices: " + resultado.size());
		System.out.println("Total Peso: " + pesoTotal);
		System.out.println();
	}

}