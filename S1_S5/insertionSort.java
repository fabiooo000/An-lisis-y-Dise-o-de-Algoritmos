public class Insercion {
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int clave = arr[i];  // Elemento actual a insertar
            int j = i - 1;
            
            // Mover elementos mayores que la clave una posición adelante
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insertar la clave en su posición correcta
            arr[j + 1] = clave;
        }
    }
}
