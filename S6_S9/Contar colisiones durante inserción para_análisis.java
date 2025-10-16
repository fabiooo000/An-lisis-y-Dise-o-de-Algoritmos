// Cuenta cuántas colisiones ocurren al insertar una clave con sondeo lineal
public int countCollisions(int[] table, int key, int tableSize) {
    int index = key % tableSize;
    int collisions = 0;
    while (table[index] != -1) { // Mientras la posición esté ocupada
        collisions++;
        index = (index + 1) % tableSize; // Sondeo lineal
        if (collisions >= tableSize) break; // Evita bucle infinito
    }
    return collisions;
}
