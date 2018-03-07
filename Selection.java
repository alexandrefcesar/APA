import java.util.Arrays;
import java.util.Random;

public class Selection {

	public static int[] gerarVector(int n) {
		int[] c = new int[n];
		Random gerador = new Random();
		for (int i = 0; i < n; i++) {
			c[i] = gerador.nextInt(100);
		}
		return c;

	}

	private static void selectionSort(int[] v) {
		int min, aux;
		for (int i = 0; i < v.length; i++) {
			min = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[min]) {
					min = j;
				}

			}
			if (min != i) {
				aux = v[min];
				v[min] = v[i];
				v[i] = aux;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = gerarVector(20);
		System.out.println("Vetor desordenado:");
		System.out.println(Arrays.toString(v));
		selectionSort(v);
		System.out.println("Vetor Ordenado:");
		System.out.println(Arrays.toString(v));

	}

}
