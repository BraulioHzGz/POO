package MAIN_PACKAGE;

/**
 *
 * @author Brau_
 */
public class Tools {
    
    public Tools(){}
    
    
    public void swap(float array[], int i, int j){
        float aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    
    
    public void PrintArray(float array[], int n){
        for(int i=0; i < n; i++){
            System.out.print("  "+array[i]+"  ");
        }
        System.out.println("");
    }
    
    
    public void Print_ArrayInt(int array[], int n){
        for(int i=0; i < n; i++){
            System.out.print("  "+array[i]+"  ");
        }
        System.out.println("");
    }
    
    
    public void Heapify(float array[], int n, int i){
        int root = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        
        if(left < n && array[left] > array[root]){
            root = left;
        }
        
        if(right < n && array[right] > array[root]){
            root = right;
        }
        
        if(root != i){
            swap(array, i, root);
            Heapify(array, n, root);
        }
    }
    
    
    public int partition(float array[], int low, int high){
        float pivot = array[high];
        int j, i = low - 1;
        
        for(j = low; j <= (high-1); j++){
            if(array[j] < pivot){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, high);
        return i+1;
    }
    
    
    public void merge(float array[], int low, int q, int high){
        int n1 = q - low + 1;
        int n2 = high - q;
        
        float LEFT[] = new float[n1];
        float RIGHT[] = new float[n2];
        
        for(int i = 0; i < n1; i++) LEFT[i] = array[low + i];
        for(int k = 0; k < n2; k++) RIGHT[k] = array[q + 1 + k];
        
        int i = 0, j = 0, k = low;
        
        while(i < n1 && j < n2){
            if(LEFT[i] <= RIGHT[j]){
                array[k] = LEFT[i];
                i++;
            } else {
                array[k] = RIGHT[j];
                j++;
            }
            k++;
        }
        
        while(i < n1){
            array[k] = LEFT[i];
            i++;
            k++;
        }
        
        while(j < n2){
            array[k] = RIGHT[j];
            j++;
            k++;
        }
    }
    
    
    public int getGap(int gap){
        gap = (gap * 10) / 13;
        if(gap < 1){
            return 1;
        }
        return gap;
    }
}
