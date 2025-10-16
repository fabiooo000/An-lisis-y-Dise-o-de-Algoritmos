// Inserta un par clave-valor en la tabla hash usando encadenamiento
public void insert(HashNode[] table, int key, String value, int tableSize) {
    int index = key % tableSize; // Calcula el índice con función hash
    HashNode newNode = new HashNode(key, value);
    
    if (table[index] == null) {
        table[index] = newNode; // Si la posición está vacía, inserta directamente
    } else {
        // Si ya hay nodos, inserta al inicio de la lista (estrategia común)
        newNode.next = table[index];
        table[index] = newNode;
    }
}
