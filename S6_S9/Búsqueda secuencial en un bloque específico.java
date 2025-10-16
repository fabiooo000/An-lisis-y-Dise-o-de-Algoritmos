// Busca una clave dentro de un bloque ya cargado en memoria
public boolean searchInBlock(List<String> block, String target) {
    for (String line : block) {
        if (line.trim().equals(target)) {
            return true; // Encontrado
        }
    }
    return false; // No encontrado en este bloque
}
