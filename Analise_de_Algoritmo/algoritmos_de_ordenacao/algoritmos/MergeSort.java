package algoritmos;
/**
 * 
 * @author Gabriel
 *
 */
public class MergeSort extends AlgoritmoOrdenacao {
	
	@Override
	public void sort(long[] array, int i, int f) {
		if(i < f) {
			int middle = (i + f) / 2;
			sort(array, i, middle);
			sort(array, middle+1, f);
			merge(array, i, middle, f);
		}
	}

	public void merge(long array[], int left, int middle, int right) { 
        // Obtendo o tamanho dos subarrays a serem intercalados 
        int n1 = middle - left + 1; 
        int n2 = right - middle; 
  
        // Criação dos arrays temporários
        long Left[] = new long[n1]; 
        long Right[] = new long[n2]; 
  
        // Respectivos valores copiados para os arrays temporários
        for (int i = 0; i < n1; ++i) 
            Left[i] = array[left + i]; 
        for (int j = 0; j < n2; ++j) 
            Right[j] = array[middle + 1 + j];
        
        /* Intercalando os arrays temporários */
        // Indices iniciais do primeiro e segundo subarrays 
        int i = 0, j = 0; 
  
        // Indicice inicial do array intercalado 
        int k = left; 
        while (i < n1 && j < n2) { 
            if (Left[i] <= Right[j]) { 
                array[k] = Left[i]; 
                i++; 
            } else { 
                array[k] = Right[j]; 
                j++; 
            } 
            k++; 
        } 
  
        // Cópia dos elementos restantes de Left[] se existirem
        while (i < n1) { 
            array[k] = Left[i]; 
            i++; 
            k++; 
        } 
  
        // Cópia dos elementos restantes de Right[] se existirem
        while (j < n2) { 
            array[k] = Right[j]; 
            j++; 
            k++; 
        }
    }
}
