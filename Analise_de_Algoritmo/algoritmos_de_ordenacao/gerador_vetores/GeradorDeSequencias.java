package gerador_vetores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
/**
 * 
 * @author Gabriel
 *
 */
public class GeradorDeSequencias {

	private static Set<Long> arranjos = new LinkedHashSet<Long>();

	/**
	 * Esse método gera vetores ordenados do tamanho passardo por parâmetro
	 * @param tamanho tamanho do array que é solicitado
	 * @return retorna um array ordenado de números do tipo long
	 */
	public static Long[] gerarSequenciaOrdenada(int tamanho) {

		Long[] arranjo = gerarSequenciaAleatoria(tamanho);

		Arrays.sort(arranjo); // aqui acontece a ordenação dos vetores

		return arranjo;
	}

	/**
	 * Método responsável por gerar vetor inversamente ordenado, ou seja, decrescente
	 * @param tamanho tamanho do array que é solicitado
	 * @return retorna um array ordenado inversamente de números do tipo long
	 */
	public static Long[] gerarSequenciaInversamenteOrdenada(int tamanho) {

		Long[] arranjo = gerarSequenciaOrdenada(tamanho);

		//Esse ArrayList foi utilizado para criação do vetor decrescente, pois um de seus métodos
		//auxilia na adição de elementos informando a posição em que se deseja adicionar o memso
		ArrayList<Long> arranjoInverso = new ArrayList<Long>(); 

		for (Long numero : arranjo) {
			arranjoInverso.add(0, numero); //aqui sempre é adicionado o numéro na posição 0, assim gerando um array decrescente
		}

		arranjo = arranjoInverso.toArray(new Long[tamanho]); // O arrayList é transformado em um array do tipo Long

		return arranjo;
	}

	/**
	 * Esse método gera uma sequência quase ordenada, com a concatenação de um vetor ordenado e um aleatório
	 * @param tamanho tamanho do array que é solicitado 
	 * @return retorna um array quase ordenado de números do tipo long
	 */
	public static Long[] gerarSequenciaQuaseOrdenada(int tamanho) {

		//divide-se o tamanho pela metade, para que o array gerado seja do tamanho esperado
		//e que ele contenha uma parte ordenada, e outra não
		int metade = tamanho/2; 
		
		Long[] arranjoOrdenado = gerarSequenciaOrdenada(metade);
		Long[] arranjoDesordenado = gerarSequenciaAleatoria(metade);
		
		//aqui os dois arrays são concatenados para formar o arranjo(array) esperado
		Long[] arranjo = ArrayUtils.addAll(arranjoOrdenado, arranjoDesordenado);
		

		return arranjo;
	}

	/**
	 * Esse método é responsável por gerar um vetor de sequência aleatoria
	 * @param tamanho tamanho do array que é solicitado 
	 * @return retorna um array de sequância aleatória contendo números do tipo long
	 */
	public static Long[] gerarSequenciaAleatoria(int tamanho) {

		while (true) {

			//aqui é gerado o número aleatório que pode ser entre 0 e 100000000
			long numero = (long) (Math.random() * 100000000);
			
			//depois o número é adicionado ao Set de longs chamado arranjos
			//obs: por ser um Set, números repetidos não podem ser adicionados
			arranjos.add(numero);

			//caso o Set não contenha a quantidade de elementos igual ao tamanho recebido por parâmetro, o laço executa novamente
			if (arranjos.size() == tamanho) {
				break;
			}

		}

		//O Set é tranformado em uma array de números do tipo Long
		Long[] arranjo = new ArrayList<Long>(arranjos).toArray(new Long[tamanho]);

		//São removidos os elementos presentes dentro do Set
		arranjos.removeAll(arranjos);

		return arranjo;
	}
}
