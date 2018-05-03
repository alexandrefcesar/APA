
public class AppMochila {

	public static int Knapsack(int W, int wt[], int b[], int n) {

		// tabela que será preenchida
		int[][] v = new int[n + 1][W + 1];
		// int v[n+1][W+1];
		// inicializando a primeira linha e primeira coluna com 0
		for (int w = 0; w <= W; w++) {
			v[0][w] = 0;
		}
		for (int i = 1; i <= n; i++) {
			v[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= W; w++) {
				// elemento pode fazer parte da solucao caso do max
				if (wt[i - 1] <= w) {
					// max
					if ((b[i - 1] + v[i - 1][w - wt[i - 1]]) > v[i - 1][w])
						v[i][w] = b[i - 1] + v[i - 1][w - wt[i - 1]];
					else
						v[i][w] = v[i - 1][w];

				} else {
					v[i][w] = v[i - 1][w];
				}
			}

		}

		return v[n][W];

	}

	public static void main(String[] args) {

		// capacidade maxima da mochila
		int w = 30;
		// numero de elementos
		int n = 4;
		// vetor de valores
		int[] b = { 23, 29, 27, 25 };
		// vetor com os pesos
		int[] wt = { 13, 23, 17, 19 };

		// obter o maximo valor que pode ser colocado na mochila
		int max_valor = Knapsack(w, wt, b, n);

		System.out.println("valor maximo:\n" + max_valor);

	}
}
