// Retorna los documentos que contienen un término dado
public List<Integer> searchInvertedIndex(String term) {
    return invertedIndex.getOrDefault(term, new ArrayList<>());
}
