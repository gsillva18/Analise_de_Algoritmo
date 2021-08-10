package algoritmos;

/**
 * 
 * @author Gabriel
 *
 */

public abstract class AlgoritmoOrdenacao {

	/**
	 * Método responsável por ordenar o array passado por parâmetro
	 * @param array Array que se deseja ordenar
	 * @return retorna um array de longs contendo o tempo em mili segundos, o numero de comparações de chaves e o numero de movimentações de registros,
	 * nas posições 0, 1 e 2 do array respectivamente
	 */
	public long[] sort(long[] array) {
		throw new UnsupportedOperationException("[ERRO] Operação de ordenação não suportada. Verifique os parâmetros de entrada");
	}
	
}
