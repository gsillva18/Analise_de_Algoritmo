package algoritmos;

import java.time.Duration;
import java.time.Instant;

/**
 * 
 * @author Gabriel
 *
 */
public class MergeSort extends AlgoritmoOrdenacao {

	private long numeroDeComparacoesDeChaves = 0;
	private long numeroDeMovimentacoesDeRegistros = 0;

	@Override
	public long[] sort(Long[] array) {

		Instant start = Instant.now();

		sort(array, 0, array.length - 1);

		Instant end = Instant.now();

		Duration duration = Duration.between(start, end);
		long durationInMillisseconds = duration.toMillis();

		return new long[] { durationInMillisseconds, numeroDeComparacoesDeChaves, numeroDeMovimentacoesDeRegistros };

	}

	public void sort(Long[] array, int i, int f) {
		if (i < f) {
			int middle = (i + f) / 2;
			sort(array, i, middle);
			sort(array, middle + 1, f);
			merge(array, i, middle, f);
		}
	}

	public void merge(Long array[], int left, int middle, int right) {
		// Obtendo o tamanho dos subarrays a serem intercalados
		int n1 = middle - left + 1;
		int n2 = right - middle;

		// Criação dos arrays temporários
		long Left[] = new long[n1];
		long Right[] = new long[n2];

		// Respectivos valores copiados para os arrays temporários
		for (int i = 0; i < n1; ++i) {
			Left[i] = array[left + i]; // aqui acontece uma movimentaçao de registro
			numeroDeMovimentacoesDeRegistros++;
		}

		for (int j = 0; j < n2; ++j) {
			Right[j] = array[middle + 1 + j]; // aqui acontece uma movimentaçao de registro
			numeroDeMovimentacoesDeRegistros++;
		}

		/* Intercalando os arrays temporários */
		// Indices iniciais do primeiro e segundo subarrays
		int i = 0, j = 0;

		// Indicice inicial do array intercalado
		int k = left;
		while (i < n1 && j < n2) {

			numeroDeComparacoesDeChaves++;

			if (Left[i] <= Right[j]) { // aqui acontece uma comparação de chaves
				array[k] = Left[i];
				i++;
			} else {
				array[k] = Right[j];
				j++;
			}

			numeroDeMovimentacoesDeRegistros++; // aqui acontece uma movimentaçao de registro, entrando no if ou no else
			k++;
		}

		// Cópia dos elementos restantes de Left[] se existirem
		while (i < n1) {

			array[k] = Left[i]; // aqui acontece uma movimentaçao de registro
			numeroDeMovimentacoesDeRegistros++;

			i++;
			k++;
		}

		// Cópia dos elementos restantes de Right[] se existirem
		while (j < n2) {

			array[k] = Right[j]; // aqui acontece uma movimentaçao de registro
			numeroDeMovimentacoesDeRegistros++;
			j++;
			k++;
		}
	}
}
