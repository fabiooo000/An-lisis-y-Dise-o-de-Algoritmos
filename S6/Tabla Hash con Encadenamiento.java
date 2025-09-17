import java.util.LinkedList;

/**
 * Implementación de una tabla hash usando encadenamiento para resolver colisiones
 * Esta técnica almacena múltiples elementos en la misma posición usando listas enlazadas
 */
public class TablaHashEncadenamiento {
    private LinkedList<ParClaveValor>[] tabla;
    private int tamaño;
    
    // Clase interna para almacenar pares clave-valor
    private static class ParClaveValor {
        String clave;
        int valor;
        
        public ParClaveValor(String clave, int valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }
    
    /**
     * Constructor que inicializa la tabla hash
     * @param tamaño Tamaño inicial de la tabla
     */
    public TablaHashEncadenamiento(int tamaño) {
        this.tamaño = tamaño;
        tabla = new LinkedList[tamaño];
        
        // Inicializar cada posición con una lista vacía
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }
    
    /**
     * Función de dispersión usando el método de división
     * @param clave La clave a convertir en índice
     * @return Índice en la tabla hash
     */
    private int funcionHash(String clave) {
        // Suma de los valores ASCII de los caracteres
        int suma = 0;
        for (char c : clave.toCharArray()) {
            suma += (int) c;
        }
        
        // Método de división: residuo de la división por el tamaño
        return suma % tamaño;
    }
    
    /**
     * Inserta un nuevo par clave-valor en la tabla
     * @param clave La clave del elemento
     * @param valor El valor asociado a la clave
     */
    public void insertar(String clave, int valor) {
        int indice = funcionHash(clave);
        
        // Buscar si la clave ya existe
        for (ParClaveValor par : tabla[indice]) {
            if (par.clave.equals(clave)) {
                par.valor = valor; // Actualizar valor si clave existe
                return;
            }
        }
        
        // Insertar nuevo par clave-valor
        tabla[indice].add(new ParClaveValor(clave, valor));
    }
    
    /**
     * Busca un valor por su clave
     * @param clave La clave a buscar
     * @return El valor asociado o -1 si no se encuentra
     */
    public int buscar(String clave) {
        int indice = funcionHash(clave);
        
        for (ParClaveValor par : tabla[indice]) {
            if (par.clave.equals(clave)) {
                return par.valor;
            }
        }
        
        return -1; // No encontrado
    }
    
    /**
     * Elimina un elemento por su clave
     * @param clave La clave a eliminar
     * @return true si se eliminó, false si no existía
     */
    public boolean eliminar(String clave) {
        int indice = funcionHash(clave);
        
        for (ParClaveValor par : tabla[indice]) {
            if (par.clave.equals(clave)) {
                tabla[indice].remove(par);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Muestra el contenido de la tabla hash
     */
    public void mostrarTabla() {
        System.out.println("Contenido de la Tabla Hash:");
        for (int i = 0; i < tamaño; i++) {
            System.out.print("Índice " + i + ": ");
            if (tabla[i].isEmpty()) {
                System.out.println("Vacío");
            } else {
                for (ParClaveValor par : tabla[i]) {
                    System.out.print("[" + par.clave + "=" + par.valor + "] ");
                }
                System.out.println();
            }
        }
    }
    
    // Método principal de prueba
    public static void main(String[] args) {
        TablaHashEncadenamiento tabla = new TablaHashEncadenamiento(5);
        
        // Insertar algunos valores
        tabla.insertar("Juan", 25);
        tabla.insertar("Maria", 30);
        tabla.insertar("Pedro", 22);
        tabla.insertar("Ana", 28);
        tabla.insertar("Luis", 35);
        
        // Mostrar la tabla
        tabla.mostrarTabla();
        
        // Buscar valores
        System.out.println("\nBúsqueda de 'Maria': " + tabla.buscar("Maria"));
        System.out.println("Búsqueda de 'Carlos': " + tabla.buscar("Carlos"));
        
        // Eliminar un elemento
        tabla.eliminar("Pedro");
        System.out.println("\nDespués de eliminar 'Pedro':");
        tabla.mostrarTabla();
    }
}
