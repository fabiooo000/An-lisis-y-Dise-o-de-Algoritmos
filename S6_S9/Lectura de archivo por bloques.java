import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Simula la lectura de un archivo en bloques fijos de tamaño 4 líneas
public List<String> readBlock(File file, int blockSize, int blockNumber) throws IOException {
    List<String> block = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        int currentLine = 0;
        int targetStart = blockNumber * blockSize;
        int targetEnd = targetStart + blockSize;

        while ((line = reader.readLine()) != null) {
            if (currentLine >= targetStart && currentLine < targetEnd) {
                block.add(line);
            } else if (currentLine >= targetEnd) break;
            currentLine++;
        }
    }
    return block;
}
