import java.util.Arrays;
import java.util.Random;

public class MergeApa {


	public static int[] gerarVector(int n) {
		int[] c = new int[n];
		Random gerador = new Random();
		for (int i = 0; i < n; i++) {
			c[i] = gerador.nextInt(100);
		}
		return c;

	}

	public static void vetorOrdRecursivo(int[] vetor) {
		int[] vet = vetor;
		int tamanVettor = vetor.length;
		int[]w = new int[vetor.length];
		MergeSortRecursivo(vet, w , 0, tamanVettor - 1);
	}

	public static void MergeSortRecursivo(int[] vetor,int[] w, int ini, int fim) {

		if (ini < fim) {
			int meio = (ini+fim) / 2 ;

			MergeSortRecursivo(vetor,w , ini, meio);
			MergeSortRecursivo(vetor,w, meio + 1, fim);
			intercalar(vetor,w ,  ini, meio, fim);

		}

	}

	public static void intercalar(int vetor[],int[] w , int ini, int meio, int fim) {
             for(int k =ini; k<= fim ;k++ ) {
            	 w[k]=vetor[k]; //copia dos vetores
             }
             int i = ini ; 
             int j = meio +1 ;
             for (int k=ini ; k<=fim ;k++) {
            	 if(i > meio) vetor[k] = w[j++];
            	 else if (j>fim) vetor[k]= w[i++]; // se já acabou 
            	 else if(w[i]<w[j]) vetor[k]= w[i++];
            	 else vetor[k]= w[j++];
            	 
             }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = gerarVector(20);
		System.out.println("Vetor desordenado:");
		System.out.println(Arrays.toString(v));
		vetorOrdRecursivo(v);
		System.out.println("Vetor Ordenado:");
		System.out.println(Arrays.toString(v));

	}

}