// Función hash básica usando el método de división
public int hashFunction(int key, int tableSize) {
    // Retorna el residuo de dividir la clave entre el tamaño de la tabla
    // Esto asegura que el índice esté en el rango [0, tableSize - 1]
    return key % tableSize;
}
