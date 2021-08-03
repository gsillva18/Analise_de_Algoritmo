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
	public long sort(long[] array) {
		System.out.println("Bubble Sort");
		Instant start = Instant.now();
		
		// Se não houveram mudanças, o array já está ordenado
		boolean hasChanged = true;
		
		while (hasChanged) {
			hasChanged = false;
			
			// Contador para que o último elemento não seja analisado
			int j = 0;
			
			for (int i = 0; i < array.length -1 - j; i++) {
				
				if(array[i] > array[i+1]) {
					// Troca do valor com seu sucessor
					long aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
					hasChanged = true;			
				}
			}
			j++;
		}
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return durationInMillisseconds;
	}
}
