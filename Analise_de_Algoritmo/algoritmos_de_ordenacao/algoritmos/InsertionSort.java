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
	public long sort(long[] array) {
		System.out.println("Insertion Sort");
		Instant start = Instant.now();
		
		for(int i = 0; i < array.length - 1; i++) {			
			int j = i + 1;
			long number = array[j]; // N�mero a ser posicionado
			
			// Colocando um n�mero de sequ�ncia desordenado na sequ�ncia ordenada
			while(j > 0 && number < array[j-1]) {
				array[j] = array[j-1];
				j--;
			}
			
			array[j] = number;
		}
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return durationInMillisseconds;
	}
}
