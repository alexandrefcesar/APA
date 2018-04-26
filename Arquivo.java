package Apa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Arquivo {
private static ArrayList memoria;

public static ArrayList arquivo() {
	ArrayList lista = new ArrayList();
	File arquivo = new File("arquivo.txt");
	String linha;
	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)));
		while (br.ready()) {
			linha = br.readLine();
			lista.add(linha);
		}

		br.close();
	} catch (Exception e) {
		System.out.println("Erro: " + e.getMessage());
	}
	return lista;
}

public static ArrayList lista() {
	ArrayList lista = Arquivo.arquivo();
	return lista;
}
}