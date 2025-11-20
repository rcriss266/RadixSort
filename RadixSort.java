import java.io.*;
import java.util.*;

public class RadixSort {

    public static void main(String[] args) {

        int[] arr = leerArchivo("Entrada.txt");

        if (arr.length == 0) {
            System.out.println("El archivo está vacío o no pudo leerse.");
            return;
        }

        System.out.println("Antes de ordenar:");
        imprimir(arr);

        radixSort(arr);

        System.out.println("\nDespués de ordenar:");
        imprimir(arr);
    }

    
    // aqui lee el archivo
    public static int[] leerArchivo(String nombreArchivo) {
        try {
            Scanner sc = new Scanner(new File(nombreArchivo));
            List<Integer> lista = new ArrayList<>();

            while (sc.hasNextInt()) {   // Lee números
                lista.add(sc.nextInt());
            }

            sc.close();

            int[] arr = new int[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                arr[i] = lista.get(i);
            }

            return arr;

        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return new int[0];
        }
    }

    
    public static void imprimir(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
}




