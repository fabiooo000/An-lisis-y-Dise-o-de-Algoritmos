import java.util.*;

public class OrdenacionExternaSimple {

    public static void main(String[] args) {
        // Simulamos un archivo grande con un array
        int[] archivo = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original: " + Arrays.toString(archivo));

        // Paso 1: Dividir en bloques pequeños y ordenarlos (simulando ordenamiento en memoria)
        int tamanoBloque = 3; // Supongamos que solo podemos ordenar 3 elementos a la vez
        List<int[]> bloques = dividirYOrdenar(archivo, tamanoBloque);

        // Paso 2: Mostrar bloques ordenados
        System.out.println("\nBloques ordenados:");
        for (int i = 0; i < bloques.size(); i++) {
            System.out.println("Bloque " + (i+1) + ": " + Arrays.toString(bloques.get(i)));
        }

        // Paso 3: Fusionar todos los bloques ordenados
        int[] resultado = fusionarTodos(bloques);
        System.out.println("\nArchivo final ordenado:");
        System.out.println(Arrays.toString(resultado));
    }

    // Divide el archivo en bloques y los ordena
    public static List<int[]> dividirYOrdenar(int[] archivo, int tamanoBloque) {
        List<int[]> bloques = new ArrayList<>();
        for (int i = 0; i < archivo.length; i += tamanoBloque) {
            int fin = Math.min(i + tamanoBloque, archivo.length);
            int[] bloque = Arrays.copyOfRange(archivo, i, fin);
            Arrays.sort(bloque); // Ordenamos el bloque (como si lo hicimos en memoria)
            bloques.add(bloque);
        }
        return bloques;
    }

    // Fusiona todos los bloques ordenados en un solo array
    public static int[] fusionarTodos(List<int[]> bloques) {
        // Simulamos fusionar de a dos bloques hasta que solo quede uno
        while (bloques.size() > 1) {
            List<int[]> nuevosBloques = new ArrayList<>();
            for (int i = 0; i < bloques.size(); i += 2) {
                if (i + 1 < bloques.size()) {
                    // Fusionar dos bloques
                    int[] fusionado = fusionarDos(bloques.get(i), bloques.get(i + 1));
                    nuevosBloques.add(fusionado);
                } else {
                    // Si queda uno solo, lo dejamos así
                    nuevosBloques.add(bloques.get(i));
                }
            }
            bloques = nuevosBloques;
        }
        return bloques.get(0);
    }

    // Fusiona dos arrays ordenados en uno solo ordenado
    public static int[] fusionarDos(int[] a, int[] b) {
        int[] resultado = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                resultado[k++] = a[i++];
            } else {
                resultado[k++] = b[j++];
            }
        }

        // Copiar lo que queda
        while (i < a.length) resultado[k++] = a[i++];
        while (j < b.length) resultado[k++] = b[j++];

        return resultado;
    }
}
