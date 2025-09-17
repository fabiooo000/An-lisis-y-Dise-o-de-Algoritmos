/**
 * Implementación de tabla hash usando sondeo lineal para resolver colisiones
 * En este método, cuando hay colisión, se buscan posiciones secuencialmente
 */
public class TablaHashSondeoLineal {
    private String[] claves;
    private int[] valores;
    private int tamaño;
    private int elementos;
    
    /**
     * Constructor que inicializa la tabla hash
     * @param tamaño Tamaño de la tabla
     */
    public TablaHashSondeoLineal(int tamaño) {
        this.tamaño = tamaño;
        this.elementos = 0;
        claves = new String[tamaño];
        valores = new int[tamaño];
    }
    
    /**
     * Función de dispersión principal
     * @param clave La clave a convertir
     * @return Índice inicial en la tabla
     */
    private int hash1(String clave) {
        int hash = 0;
        for (char c : clave.toCharArray()) {
            hash = (hash * 31 + c) % tamaño;
        }
        return hash;
    }
    
    /**
     * Inserta un nuevo par clave-valor usando sondeo lineal
     * @param clave La clave del elemento
     * @param valor El valor asociado
     */
    public void insertar(String clave, int valor) {
        if (elementos >= tamaño * 0.75) {
            System.out.println("Advertencia: La tabla está casi llena");
        }
        
        int indice = hash1(clave);
        int intentos = 0;
        
        // Buscar posición vacía o con la misma clave
        while (claves[indice] != null && !claves[indice].equals(clave) && intentos < tamaño) {
            indice = (indice + 1) % tamaño; // Sondeo lineal: siguiente posición
            intentos++;
        }
        
        if (intentos >= tamaño) {
            System.out.println("Error: Tabla llena, no se puede insertar");
            return;
        }
        
        if (claves[indice] == null) {
            elementos++; // Nuevo elemento
        }
        
        claves[indice] = clave;
        valores[indice] = valor;
    }
    
    /**
     * Busca un valor por su clave usando sondeo lineal
     * @param clave La clave a buscar
     * @return El valor asociado o -1 si no se encuentra
     */
    public int buscar(String clave) {
        int indice = hash1(clave);
        int intentos = 0;
        
        while (claves[indice] != null && intentos < tamaño) {
            if (claves[indice].equals(clave)) {
                return valores[indice];
            }
            indice = (indice + 1) % tamaño; // Sondeo lineal
            intentos++;
        }
        
        return -1; // No encontrado
    }
    
    /**
     * Muestra el contenido de la tabla
     */
    public void mostrarTabla() {
        System.out.println("Tabla Hash con Sondeo Lineal:");
        for (int i = 0; i < tamaño; i++) {
            if (claves[i] != null) {
                System.out.println("Índice " + i + ": " + claves[i] + " = " + valores[i]);
            } else {
                System.out.println("Índice " + i + ": Vacío");
            }
        }
    }
    
    // Método principal de prueba
    public static void main(String[] args) {
        TablaHashSondeoLineal tabla = new TablaHashSondeoLineal(7);
        
        // Insertar valores
        tabla.insertar("A", 10);
        tabla.insertar("B", 20);
        tabla.insertar("C", 30);
        tabla.insertar("D", 40);
        tabla.insertar("E", 50);
        
        // Mostrar tabla
        tabla.mostrarTabla();
        
        // Buscar valores
        System.out.println("\nBúsqueda de 'C': " + tabla.buscar("C"));
        System.out.println("Búsqueda de 'X': " + tabla.buscar("X"));
    }
}
