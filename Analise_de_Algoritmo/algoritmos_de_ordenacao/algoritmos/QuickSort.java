package algoritmos;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
/**
 * 
 * @author Gabriel
 *
 */
public class QuickSort extends AlgoritmoOrdenacao {
	
	private long numeroDeComparacoesDeChaves = 0;
	private long numeroDeMovimentacoesDeRegistros = 0;
	
	@Override
	public long[] sort(Long[] array) {
		
		Instant start = Instant.now();
		
		sort(array, 0, array.length-1);
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		
		return new long[] {durationInMillisseconds, numeroDeComparacoesDeChaves, numeroDeMovimentacoesDeRegistros};
	}
	
	
	public void sort(Long[] array, int i, int f) {
		int e = i, d = f;
		
		// Pivô calculado aleatoriamente
		Random random = new Random();
		long pivot = array[e + random.nextInt(d - e + 1)]; //aqui acontece uma movimentação de registro
		numeroDeMovimentacoesDeRegistros++;
		
		while(e <= d) {
			
			while(e <= f && array[e] < pivot) { //aqui acontece uma comparação de chaves
				numeroDeComparacoesDeChaves++;
				e++;
			}
			while(d >= i && array[d] > pivot) { //aqui acontece uma comparação de chaves
				numeroDeComparacoesDeChaves++;
				d--;
			}
			
			if(e <= d) {
				long aux = array[e];
				array[e] = array[d];
				array[d] = aux;
				
				numeroDeMovimentacoesDeRegistros += 3; //aqui acontecem 3 movimentações de registros
				
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
