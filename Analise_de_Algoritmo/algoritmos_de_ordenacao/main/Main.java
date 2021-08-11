package main;

import java.util.Arrays;

import algoritmos.AlgoritmoOrdenacao;
import algoritmos.BubbleSort;
import algoritmos.InsertionSort;
import algoritmos.MergeSort;
import algoritmos.QuickSort;
import algoritmos.SelectionSort;
import gerador_vetores.GeradorDeSequencias;

/**
 * 
 * @author Gabriel
 *
 */
public class Main {

	private static Long[] arrayOrdenado = null;
	private static Long[] arrayInverso = null;
	private static Long[][] arraysQuaseOrdenados = new Long[14][];
	private static Long[][] arraysAleatorios = new Long[14][];
	private static AlgoritmoOrdenacao algoritmoOrdenacao = null;

	public static void main(String[] args) {

		int tamanhoDaSequencia = 1000000;
		gerarArrays(tamanhoDaSequencia);

		// ALGORITMO - BubbleSort

		System.out.println("--BUBBLE SORT--\n");
		escolherAlgoritmo("BubbleSort");
		executarPrograma();

		// ALGORITMO - Insertion Sort

		System.out.println("--INSERTION SORT--\n");
		escolherAlgoritmo("InsertionSort");
		executarPrograma();

		// ALGORITMO - Merge Sort

		System.out.println("--MERGE SORT--\n");
		escolherAlgoritmo("MergeSort");
		executarPrograma();

		// ALGORITMO - Quick Sort

		System.out.println("--QUICK SORT--\n");
		escolherAlgoritmo("QuickSort");
		executarPrograma();

		// ALGORITMO - Selection Sort

		System.out.println("--SELECTION SORT--\n");
		escolherAlgoritmo("SelectionSort");
		executarPrograma();

	}

	public static void executarPrograma() {

		long[] resultado;

		Long[] arrayCopia;

		arrayCopia = Arrays.copyOf(arrayOrdenado, arrayOrdenado.length);
		resultado = algoritmoOrdenacao.sort(arrayCopia);

		System.out.println("---SEQUÊNCIA ORDENADA---\n");
		System.out.println(
				"Tempo gasto em Milisegundos: " + resultado[0] + "\nNúmero de comparações de chaves realizadas: "
						+ resultado[1] + "\nNúmero de movimentações de registros realizadas: " + resultado[2] + "\n");

		arrayCopia = Arrays.copyOf(arrayInverso, arrayInverso.length);
		resultado = algoritmoOrdenacao.sort(arrayCopia);
		System.out.println("---SEQUÊNCIA ORDENADA INVERSAMENTE---\n");
		System.out.println(
				"Tempo gasto em Milisegundos: " + resultado[0] + "\nNúmero de comparações de chaves realizadas: "
						+ resultado[1] + "\nNúmero de movimentações de registros realizadas: " + resultado[2] + "\n");

		System.out.println("---SEQUÊNCIA QUASE ORDENADA---\n");
		for (int i = 0; i < 14; i++) {
			arrayCopia = Arrays.copyOf(arraysQuaseOrdenados[i], arraysQuaseOrdenados[i].length);
			resultado = algoritmoOrdenacao.sort(arrayCopia);

			System.out.println("Sequência quase ordenada :" + i);
			System.out.println("Tempo gasto em Milisegundos: " + resultado[0]
					+ "\nNúmero de comparações de chaves realizadas: " + resultado[1]
							+ "\nNúmero de movimentações de registros realizadas: " + resultado[2] + "\n");
		}
		System.out.println("\n");

		System.out.println("---SEQUÊNCIA ALEATÓRIA---\n");
		for (int i = 0; i < 14; i++) {
			arrayCopia = Arrays.copyOf(arraysAleatorios[i], arraysAleatorios[i].length);
			resultado = algoritmoOrdenacao.sort(arrayCopia);

			System.out.println("Sequência aleatória :" + i);
			System.out.println("Tempo gasto em Milisegundos: " + resultado[0]
					+ "\nNúmero de comparações de chaves realizadas: " + resultado[1]
							+ "\nNúmero de movimentações de registros realizadas: " + resultado[2] + "\n");
		}

		System.out.println("\n");

	}

	public static void escolherAlgoritmo(String nomeAlgoritmo) {

		if (nomeAlgoritmo.equals("BubbleSort")) {

			algoritmoOrdenacao = new BubbleSort();

		} else if (nomeAlgoritmo.equals("InsertionSort")) {

			algoritmoOrdenacao = new InsertionSort();

		} else if (nomeAlgoritmo.equals("MergeSort")) {

			algoritmoOrdenacao = new MergeSort();

		} else if (nomeAlgoritmo.equals("QuickSort")) {

			algoritmoOrdenacao = new QuickSort();

		} else if (nomeAlgoritmo.equals("SelectionSort")) {

			algoritmoOrdenacao = new SelectionSort();
		}
	}

	public static void gerarArrays(int tamanho) {

		arrayOrdenado = GeradorDeSequencias.gerarSequenciaOrdenada(tamanho);
		arrayInverso = GeradorDeSequencias.gerarSequenciaInversamenteOrdenada(tamanho);

		for (int i = 0; i < 14; i++) {
			arraysQuaseOrdenados[i] = GeradorDeSequencias.gerarSequenciaQuaseOrdenada(tamanho);
		}

		for (int i = 0; i < 14; i++) {
			arraysAleatorios[i] = GeradorDeSequencias.gerarSequenciaQuaseOrdenada(tamanho);
		}

	}

}
