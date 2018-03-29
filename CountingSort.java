import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	public static int[] gerarVector(int n) {
		int[] c = new int[n];
		Random gerador = new Random();
		for (int i = 0; i < n; i++) {
			c[i] = gerador.nextInt(100);
		}
		return c;

	}

	// percorrer e retorna o maior valor
	public static int max(int[] array) {
		int max = array[0];
		int currentInt;
		for (int index = 0; index < array.length; index++) {
			currentInt = array[index];
			if (array[index] > max) {
				max = currentInt;
			}
		}
		return max;
	}

	/*
	 * countingSort () irá implementar a ordenação de contagem para o array de
	 * parâmetros e armazenar o resultado dentro do array
	 */
	public static int[] countingSort(int[] array) {
		/*
		 * criando uma matriz de contagem que manterá a quantidade de vezes que cada
		 * valor ocorre
		 */
		int countLength = max(array);
		int count[] = new int[countLength];
		final int OFFSET = 1;
		for (int index = 0; index < array.length; index++) {
			count[array[index] - OFFSET]++;
		}
		/*
		 * desde que sabemos quantas vezes cada valor ocorre, podemos classificar a
		 * matriz
		 */
		int arrayIndex = 0;
		int countIndex = 0;
		int numTimes;
		while (arrayIndex < array.length) {
			numTimes = count[countIndex];
			while (numTimes > 0) {
				array[arrayIndex] = countIndex + OFFSET;
				arrayIndex++;
				numTimes--;
			}
			countIndex++;
		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = gerarVector(20);
		System.out.println("Vetor desordenado:");
		System.out.println(Arrays.toString(v));
		countingSort(v);
		System.out.println("Vetor Ordenado:");
		System.out.println(Arrays.toString(v));

	}

}
