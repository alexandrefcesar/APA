
import java.util.Arrays;
import java.util.Random;

public class Insertion {

	public static int[] gerarVector(int n) {
		int[] c = new int[n];
		Random gerador = new Random();
		for (int i = 0; i < n; i++) {
			c[i] = gerador.nextInt(100);
		}
		return c;

	}

	private static void insertionSort(int[] v) {
		
		for (int i=1 ; i<v.length ;i++) {
			int aux = v[i];
			for(int j=i-1; j>=0 && v[j]>aux; j--) {
				v[j+1]= v[j];
				v[j]=aux;
			}
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = gerarVector(20);
		System.out.println("Vetor desordenado:");
		System.out.println(Arrays.toString(v));
		insertionSort(v);
		System.out.println("Vetor Ordenado:");
		System.out.println(Arrays.toString(v));

	}

}
