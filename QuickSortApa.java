
import java.util.Arrays;
import java.util.Random;

public class QuickSortApa {

	public static int[] gerarVector(int n) {
		int[] c = new int[n];
		Random gerador = new Random();
		for (int i = 0; i < n; i++) {
			c[i] = gerador.nextInt(100);
		}
		return c;

	}

	public static void quick(int[] vetor) {
		int[] vet = vetor;
		int tamanVettor = vetor.length;
		quicksort(vet, 0, tamanVettor - 1);
	}

	public static int[] quicksort(int vet[], int ini, int fim) {
		int pivo;
		if (fim > ini) {
			pivo = particiona(vet, ini, fim);
			quicksort(vet, ini, pivo-1);
			quicksort(vet, pivo+1, fim);
		}
		return vet;
	}

	public static int particiona(int vet[], int ini, int fim) {
		int esq, dir, pivo, aux;
		esq = ini;
		dir = fim;
		pivo = vet[ini];
		while (esq < dir) {
			while (vet[esq] <= pivo) {
				esq++;
			}
			while (vet[dir] > pivo) {
				dir--;
			}
			if (esq < dir) {
				aux = vet[esq];
				vet[esq] = vet[dir];
				vet[dir] = aux;
			}
		}
		vet[ini] = vet[dir];
		vet[dir] = pivo;
		return dir;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = gerarVector(20);
		System.out.println("Vetor desordenado:");
		System.out.println(Arrays.toString(v));
		quick(v);
		System.out.println("Vetor Ordenado:");
		System.out.println(Arrays.toString(v));

	}

}