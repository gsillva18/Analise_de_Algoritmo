package gerador_vetores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;

/**
 * 
 * @author Gabriel
 *
 */
public class GeradorDeSequencias {

	private static Set<Long> arranjos;

	/**
	 * Esse método gera vetores ordenados do tamanho passardo por parâmetro
	 * 
	 * @param tamanho tamanho do array que é solicitado
	 * @return retorna um array ordenado de números do tipo long
	 */
	public static Long[] gerarSequenciaOrdenada(int tamanho) {

		preencherArranjo(tamanho);

		Long[] arranjo = new Long[tamanho];
		arranjo = arranjos.toArray(arranjo);

		return arranjo;
	}

	/**
	 * Método responsável por gerar vetor inversamente ordenado, ou seja,
	 * decrescente
	 * 
	 * @param tamanho tamanho do array que é solicitado
	 * @return retorna um array ordenado inversamente de números do tipo long
	 */
	public static Long[] gerarSequenciaInversamenteOrdenada(int tamanho) {

		Long[] arranjo = gerarSequenciaOrdenada(tamanho);

		Long[] arranjoInverso = arranjo.clone();

		int contador = 0;

		for (int i = arranjo.length - 1; i >= 0; i--) {

			arranjo[contador++] = arranjoInverso[i];
		}

		return arranjo;
	}

	/**
	 * Esse método gera uma sequência quase ordenada, com a concatenação de um vetor
	 * ordenado e um aleatório
	 * 
	 * @param tamanho tamanho do array que é solicitado
	 * @return retorna um array quase ordenado de números do tipo long
	 */
	public static Long[] gerarSequenciaQuaseOrdenada(int tamanho) {

		Long[] arranjo = gerarSequenciaOrdenada(tamanho);

		// divide-se o tamanho pela metade (t/2), para que o array gerado seja do
		// tamanho esperado e que ele contenha uma parte ordenada, e outra não

		Long[] arranjoOrdenado = Arrays.copyOfRange(arranjo, 0, tamanho / 2);
		Long[] arranjoDesordenado = Arrays.copyOfRange(arranjo, tamanho / 2, tamanho);

		// aqui embaralha-se o arranjo desordenado para colocar no arranjo completo
		Collections.shuffle(Arrays.asList(arranjoDesordenado));

		// aqui os dois arrays são concatenados para formar o arranjo(array) esperado
		arranjo = ArrayUtils.addAll(arranjoOrdenado, arranjoDesordenado);

		return arranjo;
	}

	/**
	 * Esse método é responsável por gerar um vetor de sequência aleatoria
	 * 
	 * @param tamanho tamanho do array que é solicitado
	 * @return retorna um array de sequância aleatória contendo números do tipo long
	 */
	public static Long[] gerarSequenciaAleatoria(int tamanho) {

		preencherArranjo(tamanho);

		List<Long> sequencia = new ArrayList<Long>(arranjos);

		Collections.shuffle(sequencia);

		Long[] arranjo = new Long[tamanho];
		arranjo = sequencia.toArray(arranjo);

		return arranjo;
	}

	private static void preencherArranjo(int tamanho) {

		arranjos = new LinkedHashSet<Long>();

		for (int i = 0; i < tamanho; i++) {

			arranjos.add((long) i);
		}
	}
}
