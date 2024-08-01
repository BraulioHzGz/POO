package MAIN_PACKAGE;

/**
 *
 * @author Brau_
 */
public class Ordenamientos {
    
    Tools tools;    // Instancia de objeto a Tools
    
    public Ordenamientos(){
        tools = new Tools();
    }
    
    
    /***
     * @brief BubbleSort : método de ordenamiento búrbuja
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(n)
     *          Peor escenario:  O(n^2)
     *          Promediando:     O(n^2)
     *          Espacial:        O(1)
     *          Estabilidad:     SI
     * 
     * @param array : arreglo a ordenar
     */
    public void BubbleSort(float array[]){
        int n = array.length;
        
        for(int i = n-1; i>0; i--){
            int flag = 0;
            for(int j = 0; j < i; j++){
                if(array[j] > array[j+1]){
                    tools.swap(array, j, j+1);
                    flag = 1;
                }
            }
            
            if(flag == 0) break; 
        }
        
        System.out.println("\n\tEl arreglo ordenado es: \n");
        tools.PrintArray(array, n);
    }
    
    
    /***
     * @brief SelectionSort : método de ordenamiento por selección
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(n^2)
     *          Peor escenario:  O(n^2)
     *          Promediando:     O(n^2)
     *          Espacial:        O(1)
     *          Estabilidad:     NO
     * 
     * @param array : arreglo a ordenar
     */
    public void SelectionSort(float array[]){
        int n = array.length;

        for(int i = 0; i < n - 1; i++) {
            int menor = i;
            for(int j = i + 1; j < n; j++) {
                if(array[j] < array[menor]) {
                    menor = j;
                }
            }
            if(i != menor) tools.swap(array, i, menor);
        }
        
        System.out.println("\n\tEl arreglo ordenado es: \n");
        tools.PrintArray(array, n);
    }
    
    
    /***
     * @brief InsertionSort : método de ordenamiento por inserción
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(n)
     *          Peor escenario:  O(n^2)
     *          Promediando:     O(n^2)
     *          Espacial:        O(1)
     *          Estabilidad:     SI
     * 
     * @param array : arreglo a ordenar 
     */
    public void InsertionSort(float array[]){
        int n = array.length;
        int j;
        float aux;
        
        for(int i = 1; i < n; i++){
            j = i;
            aux = array[i];
            
            while(j > 0 && aux < array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = aux;
        }
        
        System.out.println("\n\tEl arreglo ordenado es: \n");
        tools.PrintArray(array, n);
    }
    
    /***
     * @brief ShellShort: método de ordenamiento por shell.
     *                    Versión generalizada de ordenamiento por inserción
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(nlog(n))
     *          Peor escenario:  O(n^2)
     *          Promediando:     O(nlog(n))
     *          Espacial:        O(1)
     *          Estabilidad:     NO
     * 
     * @param array : arreglo a ordenar 
     */
    public void ShellSort(float array[]){
        int n = array.length;
        
        // space puede tomar espacios de n/2, n/4, n/8, ...
        
        for(int space = n / 2; space > 0; space /= 2){
            for(int i = space; i < n; i++){
                float temp = array[i];
                int j;
                for(j = i; j >= space && array[j - space] > temp; j -= space){
                    array[j] = array[j - space];
                }
                array[j] = temp;
            }
        }
        
        System.out.println("\n\tEl arreglo ordenado es: \n");
        tools.PrintArray(array, n);
    }
    
    
    /***
     * @brief QuickSort: método de ordenamiento rápido aplicando recursividad
     *                   Funciona bajo el principio "divide y vencerás"
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(nlog(n))
     *          Peor escenario:  O(n^2)
     *          Promediando:     O(nlog(n))
     *          Espacial:        O(log(n))
     *          Estabilidad:     NO
     * 
     * @param array : arreglo a ordenar 
     * @param low   : posición inicial del subarreglo
     * @param high  : posición final del subarreglo
     */
    public void QuickSort(float array[], int low, int high){
        int n = array.length;
        
        if(low < high){
            int p = tools.partition(array, low, high);
            QuickSort(array, low, p-1);
            QuickSort(array, p+1, high);
        }
    }
    
    
    /***
     * @brief MergeSort: método de ordenamiento por fusión
     *                   Funciona bajo el principio "divide y vencerás"
     *                   Aplica técnicas de recursividad
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(nlog(n))
     *          Peor escenario:  O(nlog(n))
     *          Promediando:     O(nlog(n))
     *          Espacial:        O(n)
     *          Estabilidad:     SI
     * 
     * @param array : arreglo a ordenar 
     * @param low   : posición inicial del subarreglo
     * @param high  : posición final del subarreglo
     */
    public void MergeSort(float array[], int low, int high){
        if(low < high){
            int q = (low + high) / 2;
            MergeSort(array, low, q);
            MergeSort(array, q+1, high);
            tools.merge(array, low, q, high);
        }
    }
    
    
    /***
     * @brief HeapSort: método de ordenamiento usando Heaps
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(nlog(n))
     *          Peor escenario:  O(nlog(n))
     *          Promediando:     O(nlog(n))
     *          Espacial:        O(1)
     *          Estabilidad:     NO
     * 
     * @param array : arreglo a ordenar
     */
    public void HeapSort(float array[]){
        int n = array.length;
        
        for(int i = n/2 - 1; i >= 0; i--){
            tools.Heapify(array, n, i);
        }
        
        for(int i = n - 1; i > 0; i--){
            tools.swap(array, 0, i);
            tools.Heapify(array, i, 0);
        }
        
        System.out.println("\n\tEl arreglo ordenado es: \n");
        tools.PrintArray(array, n);
    }
    
    
    /***
     * @brief CountingSort: método de ordenamiento usando conteo de datos
     *                      Este método solo funciona con enteros (int)
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(n + k)
     *          Peor escenario:  O(n + k)
     *          Promediando:     O(n + k)
     *          Espacial:        O(max)
     *          Estabilidad:     SI
     * 
     * @param array : arreglo a ordenar
     */
    public void CountingSort(int array[]){
        int n = array.length;

        if (n == 0) return;

        int max = array[0];
        int min = array[0];
        for(int i = 1; i < n; i++) {
            if(array[i] > max) max = array[i];
            if(array[i] < min) min = array[i];
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        for(int i = 0; i < n; i++) {
            count[array[i] - min]++;
        }

        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for(int i = n - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        for(int i = 0; i < n; i++) {
            array[i] = output[i];
        }
        
        System.out.println("\n\tEl arreglo ordenado es: \n");
        tools.Print_ArrayInt(array, n);
    }
    
    
    /***
     * @brief CombSort: método de ordenamiento usando comparaciones adyacentes
     *                  Es una mejora al ordenamiento por búrbuja
     *                  Se reduce con un factor de 1.3 en cada iteración
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(nlog(n))
     *          Peor escenario:  O(n^2)
     *          Promediando:     O(n^2 / 2^p) | p son los incrementos
     *          Espacial:        O(1)
     *          Estabilidad:     SI
     * 
     * @param array : arreglo a ordenar
     */
    public void CombSort(float array[]){
        int n = array.length;
        int gap = n;
        boolean swap = true;
        
        while(gap != 1 && swap){
            gap = tools.getGap(gap);
            swap = false;
            
            for(int i = 0; i < n - gap; i++){
                if(array[i] > array[i + gap]){
                    tools.swap(array, i, i+gap);
                    swap = true;
                }
            }
        }
        
        System.out.println("\n\tEl arreglo ordenado es: \n");
        tools.PrintArray(array, n); 
    }
    
    
    /***
     * @brief CocktailSort: método de ordenamiento por cocteles
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(n)
     *          Peor escenario:  O(n^2)
     *          Promediando:     O(n^2)
     *          Espacial:        O(1)
     *          Estabilidad:     SI
     * 
     * @param array : arreglo a ordenar
     */
    public void CocktailSort(float array[]){
        int n = array.length;
        boolean swap = true;
        int start = 0;
        int end = n - 1;

        while (swap) {
            swap = false;

            for(int i = start; i < end; i++) {
                if(array[i] > array[i + 1]) {
                    tools.swap(array, i, i + 1);
                    swap = true;
                }
            }

            if(!swap) break;

            swap = false;
            end--;

            for(int i = end; i > start; i--) {
                if(array[i] < array[i - 1]) {
                    tools.swap(array, i, i - 1);
                    swap = true;
                }
            }

            start++;
        }

        System.out.println("\n\tEl arreglo ordenado es: \n");
        tools.PrintArray(array, n);
    }
}
