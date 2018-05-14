
public class AppMochila {

	public static void Mochila(int cap, int peso[], int valor[], int nElem) {

		// tabela que será preenchida
		int[][] v = new int[nElem + 1][cap + 1];  // p incluir os 0
		// inicializando a primeira linha e primeira coluna com 0
		for (int w = 0; w <= cap; w++) {
			v[0][w] = 0;
		}
		for (int i = 1; i <= nElem; i++) {
			v[i][0] = 0;
		}
                // iterando em numero de elementos 
		for (int i = 1; i <= nElem; i++) {
			//iterando em linha para cada elemento 
			for (int w = 1; w <= cap; w++) {
				// elemento pode fazer parte da solucao caso do max
				if (peso[i - 1] <= w) {
					// max para comparação 
					//xn que está na solução otima vn +  f(n-1, P -Pn)
					// xn não está na solução otima f(n-1,p)
					if ((valor[i - 1] + v[i - 1][w - peso[i - 1]]) > v[i - 1][w])
						v[i][w] = valor[i - 1] + v[i - 1][w - peso[i - 1]];
					else
						v[i][w] = v[i - 1][w];

				} else {
					v[i][w] = v[i - 1][w];
				}
			}

		}

		int valorMaximo= v[nElem][cap];
		System.out.println("Valor maximo da mochila: "+valorMaximo);
		System.out.println("\n");
		
		int w=cap;
		//percorrer o for do final para o começo a partir do numero de elementos 
		for (int i = nElem; valorMaximo>0;i-- ) {
		   // se o valor for igual sobe a iteração do i , ou seja , sobe uma linha
                  if(valorMaximo == v[i-1][w]) {			
                	  continue;
                  }
                  else {  // caso contrario retorna o item e faz coluna(capacidade que está olhando) - linha (peso do elemento) 
                	  System.out.println("item: "+i);
                	  valorMaximo=valorMaximo -valor[i-1];
                	  System.out.println(w);
                	  w=w-peso[i-1];
                	  System.out.println(peso[i-1]);
                  
                  }
		}
		
		

	}

	public static void main(String[] args) {

		// capacidade maxima da mochila
		int cap = 23;
		// numero de elementos
		int nElem = 7;
		// vetor de valores
		int[] valor = { 1,6,18,22,28,40,60 };
		// vetor com os pesos
		int[] peso = { 1, 2, 5, 6,7,9,11 };

		// obter o maximo valor que pode ser colocado na mochila
		 Mochila(cap, peso,valor, nElem);


	}
}
