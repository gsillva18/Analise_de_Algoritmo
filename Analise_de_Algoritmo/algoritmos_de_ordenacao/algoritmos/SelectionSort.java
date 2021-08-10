package algoritmos;

import java.time.Duration;
import java.time.Instant;
/**
 * 
 * @author Gabriel
 *
 */
public class SelectionSort extends AlgoritmoOrdenacao {
	
	@Override
	public long[] sort(Long[] array) {
		
		long numeroDeComparacoesDeChaves = 0;
		long numeroDeMovimentacoesDeRegistros = 0;
		
		Instant start = Instant.now();
		
		for (int i = 0; i < array.length; i++) {			
			// Identificando o índice de menor elemento de um vetor
			int indexSmaller = i; // assume-se que o menor é o i-ésimo
			
			// A iteração em busca do menor valor deve acontecer ap�s
			// a posição do i, pois este trecho já está ordenado
			for (int j = i+1; j < array.length; j++) {
				
				numeroDeComparacoesDeChaves++;
				if(array[j] < array[indexSmaller]) //aqui acontece uma comparação de chaves
					indexSmaller = j;
			}
			
			// troca do i-ésimo valor com o menor valor encontrado
			long aux = array[i];
			array[i] = array[indexSmaller];
			array[indexSmaller] = aux;
			
			numeroDeMovimentacoesDeRegistros+= 3; //acontecem 3 movimentações de registros anteriormente
		}
		
		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();
		return new long[] {durationInMillisseconds, numeroDeComparacoesDeChaves, numeroDeMovimentacoesDeRegistros};
	}
}
