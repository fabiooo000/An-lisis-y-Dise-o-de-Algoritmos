import java.util.*;

// Representa una lista invertida simple: término → lista de IDs de documentos
Map<String, List<Integer>> invertedIndex = new HashMap<>();

// Agrega un documento al índice invertido
public void addToIndex(String term, int docId) {
    invertedIndex.computeIfAbsent(term, k -> new ArrayList<>()).add(docId);
}
