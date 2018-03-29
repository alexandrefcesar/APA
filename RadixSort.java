import java.util.Arrays;
import java.util.Random;

public class RadixSort {

	public static int[] gerarVector(int n) {
		int[] c = new int[n];
		Random gerador = new Random();
		for (int i = 0; i < n; i++) {
			c[i] = gerador.nextInt(100);
		}
		return c;

	}

	public static void radixSort(int[] src) {
		int n = src.length;
		int max = getMax(src, n);
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countingSort(src, max, exp);
		}
	}

	// A ordenação do Radix usa internamente a ordenação por contagem para ordenar
	// os valores

	public static void countingSort(int[] src, int totNum, int exp) {

		// System.out.println("teste" + Arrays.toString(src));
		int c[] = new int[totNum];
		// Preenche o array de contagem
		for (int i = 0; i < src.length; i++)
			c[(src[i] / exp) % 10]++;
		// Então, some com o elemento da matriz anterior
		for (int i = 1; i < totNum; i++)
			c[i] += c[i - 1];
		// Inicializa saída do array
		int output[] = new int[src.length];
		for (int i = src.length - 1; i >= 0; i--)
			output[--c[(src[i] / exp) % 10]] = src[i];

		for (int i = 0; i < output.length; i++) {
			src[i] = output[i];
		}
		// System.out.println("teste" + Arrays.toString(src));

	}

	private static int getMax(int[] array, int n) {
		int max = array[0];
		for (int i = 1; i < n; i++)
			if (array[i] > max)
				max = array[i];
		return max;
	}

	public static void main(String[] args) {
		int[] v = gerarVector(20);
		System.out.println("Vetor desordenado:");
		System.out.println(Arrays.toString(v));
		radixSort(v);
		System.out.println("Vetor Ordenado:");
		System.out.println(Arrays.toString(v));

	}
}
