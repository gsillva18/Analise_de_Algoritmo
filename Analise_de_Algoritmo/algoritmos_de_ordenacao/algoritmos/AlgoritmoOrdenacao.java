package algoritmos;

/**
 * 
 * @author Gabriel
 *
 */

public abstract class AlgoritmoOrdenacao {

	/**
	 * M�todo respons�vel por ordenar o array passado por par�metro
	 * @param array Array que se deseja ordenar
	 * @return retorna um array de longs contendo o tempo em mili segundos, o numero de compara��es de chaves e o numero de movimenta��es de registros,
	 * nas posi��es 0, 1 e 2 do array respectivamente
	 */
	public long[] sort(long[] array) {
		throw new UnsupportedOperationException("[ERRO] Opera��o de ordena��o n�o suportada. Verifique os par�metros de entrada");
	}
	
}
