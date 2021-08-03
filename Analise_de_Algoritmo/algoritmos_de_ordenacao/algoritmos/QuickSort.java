package algoritmos;

import java.util.Random;
/**
 * 
 * @author Gabriel
 *
 */
public class QuickSort extends AlgoritmoOrdenacao {
	
	@Override
	public void sort(long[] array, int i, int f) {
		int e = i, d = f;
		
		// Pivô calculado aleatoriamente
		Random random = new Random();
		long pivot = array[e + random.nextInt(d - e + 1)];
		
		while(e <= d) {
			while(e <= f && array[e] < pivot)
				e++;
			while(d >= i && array[d] > pivot)
				d--;
			
			if(e <= d) {
				long aux = array[e];
				array[e] = array[d];
				array[d] = aux;
				
				e++;
				d--;
			}
		}
		
		if(e < f) 
			sort(array, e, f);
		if(d > i)
			sort(array, i, d);
	}
}
