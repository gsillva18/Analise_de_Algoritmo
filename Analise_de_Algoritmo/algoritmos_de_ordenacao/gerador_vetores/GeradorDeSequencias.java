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
	 * Esse m�todo gera vetores ordenados do tamanho passardo por par�metro
	 * @param tamanho tamanho do array que � solicitado
	 * @return retorna um array ordenado de n�meros do tipo long
	 */
	public static Long[] gerarSequenciaOrdenada(int tamanho) {

		Long[] arranjo = gerarSequenciaAleatoria(tamanho);

		Arrays.sort(arranjo); // aqui acontece a ordena��o dos vetores

		return arranjo;
	}

	/**
	 * M�todo respons�vel por gerar vetor inversamente ordenado, ou seja, decrescente
	 * @param tamanho tamanho do array que � solicitado
	 * @return retorna um array ordenado inversamente de n�meros do tipo long
	 */
	public static Long[] gerarSequenciaInversamenteOrdenada(int tamanho) {

		Long[] arranjo = gerarSequenciaOrdenada(tamanho);

		//Esse ArrayList foi utilizado para cria��o do vetor decrescente, pois um de seus m�todos
		//auxilia na adi��o de elementos informando a posi��o em que se deseja adicionar o memso
		ArrayList<Long> arranjoInverso = new ArrayList<Long>(); 

		for (Long numero : arranjo) {
			arranjoInverso.add(0, numero); //aqui sempre � adicionado o num�ro na posi��o 0, assim gerando um array decrescente
		}

		arranjo = arranjoInverso.toArray(new Long[tamanho]); // O arrayList � transformado em um array do tipo Long

		return arranjo;
	}

	/**
	 * Esse m�todo gera uma sequ�ncia quase ordenada, com a concatena��o de um vetor ordenado e um aleat�rio
	 * @param tamanho tamanho do array que � solicitado 
	 * @return retorna um array quase ordenado de n�meros do tipo long
	 */
	public static Long[] gerarSequenciaQuaseOrdenada(int tamanho) {

		//divide-se o tamanho pela metade, para que o array gerado seja do tamanho esperado
		//e que ele contenha uma parte ordenada, e outra n�o
		int metade = tamanho/2; 
		
		Long[] arranjoOrdenado = gerarSequenciaOrdenada(metade);
		Long[] arranjoDesordenado = gerarSequenciaAleatoria(metade);
		
		//aqui os dois arrays s�o concatenados para formar o arranjo(array) esperado
		Long[] arranjo = ArrayUtils.addAll(arranjoOrdenado, arranjoDesordenado);
		

		return arranjo;
	}

	/**
	 * Esse m�todo � respons�vel por gerar um vetor de sequ�ncia aleatoria
	 * @param tamanho tamanho do array que � solicitado 
	 * @return retorna um array de sequ�ncia aleat�ria contendo n�meros do tipo long
	 */
	public static Long[] gerarSequenciaAleatoria(int tamanho) {

		while (true) {

			//aqui � gerado o n�mero aleat�rio que pode ser entre 0 e 100000000
			long numero = (long) (Math.random() * 100000000);
			
			//depois o n�mero � adicionado ao Set de longs chamado arranjos
			//obs: por ser um Set, n�meros repetidos n�o podem ser adicionados
			arranjos.add(numero);

			//caso o Set n�o contenha a quantidade de elementos igual ao tamanho recebido por par�metro, o la�o executa novamente
			if (arranjos.size() == tamanho) {
				break;
			}

		}

		//O Set � tranformado em uma array de n�meros do tipo Long
		Long[] arranjo = new ArrayList<Long>(arranjos).toArray(new Long[tamanho]);

		//S�o removidos os elementos presentes dentro do Set
		arranjos.removeAll(arranjos);

		return arranjo;
	}
}
