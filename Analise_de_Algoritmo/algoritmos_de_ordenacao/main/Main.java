package main;

import gerador_vetores.GeradorDeSequencias;
/**
 * 
 * @author Gabriel
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Long[] array = GeradorDeSequencias.gerarSequenciaAleatoria(10);
//		Long[] array = GeradorDeSequencias.gerarSequenciaOrdenada(10);
//		Long[] array = GeradorDeSequencias.gerarSequenciaInversamenteOrdenada(10);
//		Long[] array = GeradorDeSequencias.gerarSequenciaQuaseOrdenada(10);
		
		for (Long elemento : array) {
			System.out.println("array 1: "+elemento);
		}
				
	}
}
