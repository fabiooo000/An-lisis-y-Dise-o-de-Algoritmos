public class BusquedaLineal
{
    /*
     * Busca un elemento en un arreglo
     * Complejidad Temporal: O(n) - peor caso recorre todo el arreglo
     * Complejidad Espacial: O(1) - usa espacio constante
     */
    public static int buscarElemento(int[] arreglo, int elemento) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elemento) {
                return i; //indice
            }
        }
        return -1; //-1 si no lo encuentra
    }
    
    public static void main(String[] args) {
        int[] numeros = {5, 2, 8, 1, 9, 3};
        int buscar = 8;
        
        int resultado = buscarElemento(numeros, buscar);
        if (resultado != -1) {
            System.out.println("Elemento encontrado en posición: " + resultado);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}
