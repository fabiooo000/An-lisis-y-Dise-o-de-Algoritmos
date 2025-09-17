/**
 * Implementación de tabla hash usando sondeo cuadrático
 * En este método, la secuencia de exploración sigue un patrón cuadrático
 */
public class TablaHashSondeoCuadratico {
    private String[] claves;
    private int[] valores;
    private int tamaño;
    private int elementos;
    
    public TablaHashSondeoCuadratico(int tamaño) {
        this.tamaño = tamaño;
        this.elementos = 0;
        claves = new String[tamaño];
        valores = new int[tamaño];
    }
    
    /**
     * Función de dispersión principal
     */
    private int hash1(String clave) {
        int hash = 0;
        for (char c : clave.toCharArray()) {
            hash = (hash * 31 + c) % tamaño;
        }
        return hash;
    }
    
    /**
     * Inserta usando sondeo cuadrático: posición = (hash + i²) % tamaño
     */
    public void insertar(String clave, int valor) {
        if (elementos >= tamaño * 0.75) {
            System.out.println("Advertencia: La tabla está casi llena");
        }
        
        int indice = hash1(clave);
        int intentos = 0;
        
        while (claves[indice] != null && !claves[indice].equals(clave) && intentos < tamaño) {
            // Sondeo cuadrático: i² en cada intento
            indice = (hash1(clave) + intentos * intentos) % tamaño;
            intentos++;
        }
        
        if (intentos >= tamaño) {
            System.out.println("Error: No se pudo encontrar posición vacía");
            return;
        }
        
        if (claves[indice] == null) {
            elementos++;
        }
        
        claves[indice] = clave;
        valores[indice] = valor;
    }
    
    /**
     * Busca usando sondeo cuadrático
     */
    public int buscar(String clave) {
        int intentos = 0;
        int indiceInicial = hash1(clave);
        int indice = indiceInicial;
        
        while (claves[indice] != null && intentos < tamaño) {
            if (claves[indice].equals(clave)) {
                return valores[indice];
            }
            // Mismo patrón cuadrático que en la inserción
            indice = (indiceInicial + intentos * intentos) % tamaño;
            intentos++;
        }
        
        return -1;
    }
    
    public void mostrarTabla() {
        System.out.println("Tabla Hash con Sondeo Cuadrático:");
        for (int i = 0; i < tamaño; i++) {
            if (claves[i] != null) {
                System.out.println("Índice " + i + ": " + claves[i] + " = " + valores[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        TablaHashSondeoCuadratico tabla = new TablaHashSondeoCuadratico(11);
        
        tabla.insertar("apple", 1);
        tabla.insertar("banana", 2);
        tabla.insertar("orange", 3);
        tabla.insertar("grape", 4);
        
        tabla.mostrarTabla();
        
        System.out.println("Valor de 'banana': " + tabla.buscar("banana"));
    }
}
