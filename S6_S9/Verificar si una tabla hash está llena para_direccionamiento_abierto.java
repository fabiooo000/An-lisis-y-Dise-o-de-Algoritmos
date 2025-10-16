// Útil en direccionamiento abierto: determina si la tabla está llena
public boolean isTableFull(int[] table) {
    for (int slot : table) {
        if (slot == -1) return false; // Suponemos -1 como "vacío"
    }
    return true;
}
