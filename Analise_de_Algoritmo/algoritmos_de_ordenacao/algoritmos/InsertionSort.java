package algoritmos;

import java.time.Duration;
import java.time.Instant;
/**
 * 
 * @author Gabriel
 *
 */
public class InsertionSort extends AlgoritmoOrdenacao {

	@Override
	public long[] sort(Long[] array) {

		long numeroDeComparacoesDeChaves = 0;
		long numeroDeMovimentacoesDeRegistros = 0;
		Instant start = Instant.now();
		
		for(int i = 0; i < array.length - 1; i++) {			
			int j = i + 1;
			
			long number = array[j]; // Número a ser posicionado
			
			numeroDeMovimentacoesDeRegistros++; // aqui acontece uma movimentação de registro
			
			// Colocando um número de sequência desordenado na sequência ordenada
			while(j > 0 && number < array[j-1]) {
				
				numeroDeComparacoesDeChaves++; // aqui acontece uma comparação de chaves
				array[j] = array[j-1];
				j--;
			}
			
			array[j] = number;
			numeroDeMovimentacoesDeRegistros++; // aqui acontece uma movimentação de registro
		}
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		
		return new long[] {durationInMillisseconds, numeroDeComparacoesDeChaves, numeroDeMovimentacoesDeRegistros};
	}
}
