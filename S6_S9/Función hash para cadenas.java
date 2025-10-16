// Función hash para claves de tipo String
public int hashString(String key, int tableSize) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash += (int) c; // Suma los valores ASCII de los caracteres
    }
    return hash % tableSize; // Asegura que el índice esté dentro de la tabla
}
