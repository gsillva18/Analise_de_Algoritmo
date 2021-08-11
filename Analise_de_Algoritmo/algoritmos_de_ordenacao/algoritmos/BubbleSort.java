package algoritmos;

import java.time.Duration;
import java.time.Instant;

/**
 * 
 * @author Gabriel
 *
 */

public class BubbleSort extends AlgoritmoOrdenacao {

	@Override
	public long[] sort(Long[] array) {

		long numeroDeComparacoesDeChaves = 0;
		long numeroDeMovimentacoesDeRegistros = 0;

		Instant start = Instant.now();

		// Se n�o houveram mudan�as, o array j� est� ordenado
		boolean hasChanged = true;

		while (hasChanged) {
			hasChanged = false;

			// Contador para que o �ltimo elemento n�o seja analisado
			int j = 0;

			for (int i = 0; i < array.length - 1 - j; i++) {

				// aqui abaixo ocorre a compara��o de chaves
				numeroDeComparacoesDeChaves++;

				if (array[i] > array[i + 1]) {
					// Troca do valor com seu sucessor
					long aux = array[i];
					array[i] = array[i + 1];
					array[i + 1] = aux;

					// se entrar no if, acontecer�o 3 movimenta��es de registros, na linha 38, 39 e
					// 40
					numeroDeMovimentacoesDeRegistros += 3;

					hasChanged = true;
				}
			}
			j++;
		}

		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();

		return new long[] { durationInMillisseconds, numeroDeComparacoesDeChaves, numeroDeMovimentacoesDeRegistros };
	}
}
