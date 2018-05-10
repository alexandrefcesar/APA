
public class AppMochila {

	public static int Mochila(int cap, int peso[], int valor[], int nElem) {

		// tabela que será preenchida
		int[][] v = new int[n + 1][W + 1];
		// inicializando a primeira linha e primeira coluna com 0
		for (int w = 0; w <= cap; w++) {
			v[0][w] = 0;
		}
		for (int i = 1; i <= nElem; i++) {
			v[i][0] = 0;
		}

		for (int i = 1; i <= nElem; i++) {
			for (int w = 1; w <= cap; w++) {
				// elemento pode fazer parte da solucao caso do max
				if (peso[i - 1] <= w) {
					// max
					if ((valor[i - 1] + v[i - 1][w - peso[i - 1]]) > v[i - 1][w])
						v[i][w] = valor[i - 1] + v[i - 1][w - peso[i - 1]];
					else
						v[i][w] = v[i - 1][w];

				} else {
					v[i][w] = v[i - 1][w];
				}
			}

		}

		return v[nElem][cap];

	}

	public static void main(String[] args) {

		// capacidade maxima da mochila
		int cap = 30;
		// numero de elementos
		int nElem = 4;
		// vetor de valores
		int[] valor = { 23, 29, 27, 25 };
		// vetor com os pesos
		int[] peso = { 13, 23, 17, 19 };

		// obter o maximo valor que pode ser colocado na mochila
		int maximo_valor = Mochila(cap, peso,valor, nElem);

		System.out.println("valor maximo:\n" + maximo_valor);

	}
}
