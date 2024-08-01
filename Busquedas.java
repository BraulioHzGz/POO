package MAIN_PACKAGE;

import java.util.Scanner;

/**
 *
 * @author Brau_
 */
public class Busquedas {
    
    Scanner sc;     // Scanner
    float clave;    // clave a buscar en el arreglo
    int res;        // almacenar índice
    
    public Busquedas(String busqueda, float array[]){
        sc = new Scanner(System.in);
        
        if(busqueda == "Lineal"){
            System.out.println("Ingresa clave a buscar: ");
            clave = sc.nextFloat();
            res = Busqueda_Lineal(array, clave);
            
            if(res == -1) System.out.println("El elemento "+clave+" no existe");
            else System.out.println("Elemento está en el índice "+res);
            
        } else if(busqueda == "Binaria"){
            System.out.println("Ingresa clave a buscar: ");
            clave = sc.nextFloat();
            res = Busqueda_Binaria(array, clave);
            
            if(res == -1) System.out.println("El elemento "+clave+" no existe");
            else System.out.println("Elemento está en el índice "+res);
        }
    }
    
    
    /***
     * @brief Método de búsqueda lineal (elemento por elemento)
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario: O(1)
     *          Peor escenario:  O(n)
     *          Promediando:     O(n)
     *          Espacial:        O(1)
     * 
     * @brief VENTAJAS:
     *          No requiere espacio adicional.
     *          El arreglo puede estar ordenado o no
     *          Funciona bastante bien solo si se tienen pocos datos
     * 
     * @param array
     * @param clave
     * @return 
     */
    private int Busqueda_Lineal(float array[], float clave){
        for(int i = 0; i < array.length; i++){
            if(array[i] == clave){
                return i;
            }
        }
        return -1;
    }
    
    
    /***
     * @brief Método de búsqueda binaria (parte de la mitad)
     * 
     * @brief COMPLEJIDADES:
     *          Mejor escenario:    O(1)
     *          Peor escenario:     O(nlog(n))
     *          Promediando:        O(nlog(n))
     *          Espacial lineal:    O(1)
     *          Espacial recursivo: O(nlog(n))
     * 
     * @brief VENTAJAS:
     *          Más rápido y eficiente que búsqueda lineal
     *          Funciona excelente con archivos almacenados de manera externa
     *          Funciona bastante bien con muchos datos
     * 
     * @brief DESVENTAJAS:
     *          El arreglo debe estar perfectamente ordenado
     *          Los datos deben estar almacenados de manera contigua
     * 
     * @param array
     * @param clave
     * @return 
     */
    private int Busqueda_Binaria(float array[], float clave){
        int low = 0, high = array.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(array[mid] == clave) return mid;
            if(array[mid] < clave) low = mid + 1;
            else high = mid - 1; 
        }
        
        return -1;
    }
}
