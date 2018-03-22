
import java.util.Arrays;
import java.util.Random;

public class HeapSort {

	public static int[] gerarVector(int n) {
		int[] c = new int[n];
		Random gerador = new Random();
		for (int i = 0; i < n; i++) {
			c[i] = gerador.nextInt(100);
		}
		return c;

	}

	/*
	 * static void ordenaArvore(int a[], int tamanhoDoVetor, int posicao) { int max,
	 * filho; filho = 2 * posicao + 1; max = posicao; if (filho < tamanhoDoVetor) if
	 * (a[filho] > a[max]) max = filho; if (filho + 1 < tamanhoDoVetor) if (a[filho
	 * + 1] > a[max]) max = filho + 1; if (max != posicao) { int temp = a[posicao];
	 * a[posicao] = a[max]; a[max] = temp; ordenaArvore(a, tamanhoDoVetor, max); } }
	 * 
	 */
	static void ordenaArvore(int vet[], int i, int f) {
		int aux = vet[i];
		int j = i * 2 + 1;
		while (j <= f) {
			if (j < f) {
				if (vet[j] < vet[j + 1]) {
					j = j + 1;

				}
			}
			if (aux < vet[j]) {
				vet[i] = vet[j];
				i = j;
				j = 2 * i + 1;
			} else {
				j = f + 1;
			}

		}
		vet[i] = aux;

	}

	static void heapS(int[] v, int n) {
		int i, aux;
		for (i = (n - 1) / 2; i >= 0; i--) {
			ordenaArvore(v, i, n - 1);

		}
		for (i = n - 1; i >= 1; i--) {
			aux = v[0];
			v[0] = v[i];
			v[i] = aux;
			ordenaArvore(v, 0, i - 1);
		}

	}

	/*
	 * static void montarArvore(int v[]) { for (int i = v.length / 2 - 1; i >= 0;
	 * i--) ordenaArvore(v, v.length, i); }
	 * 
	 * static void heapSort(int a[]) { montarArvore(a); for (int i = a.length - 1; i
	 * >= 1; i--) { int temp = a[0]; a[0] = a[i]; a[i] = temp; ordenaArvore(a, i,
	 * 0); } }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = gerarVector(20);
		System.out.println("Vetor desordenado:");
		System.out.println(Arrays.toString(v));
		heapS(v, 20);
		System.out.println("Vetor Ordenado:");
		System.out.println(Arrays.toString(v));

	}

}