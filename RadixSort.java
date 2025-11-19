public class RadixSort {

    public static void main(String[] args) {

    }
        // Obtener el valor máximo del arreglo
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}
