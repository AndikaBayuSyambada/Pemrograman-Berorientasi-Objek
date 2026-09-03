import java.util.Arrays;

public class SortingDemo {

    // Helper untuk mencetak array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // 1. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("\n--- Bubble Sort ---");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    printArray(arr); // Cetak perubahan
                }
            }
        }
    }

    // 2. Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("\n--- Selection Sort ---");
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
                printArray(arr);
            }
        }
    }

    // 3. Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        System.out.println("\n--- Insertion Sort ---");
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            printArray(arr);
        }
    }

    // 4. Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                printArray(arr);
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        printArray(arr);
        return i + 1;
    }

    // 5. Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        // Logika standar Merge Sort
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
        
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k] = L[i++];
            else arr[k] = R[j++];
            k++;
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
        printArray(arr); // Cetak hasil merge setiap tahap
    }

    // Main Method
    public static void main(String[] args) {
        int[] data = {7, 1, 3, 5, 2};

        // Note: Karena array akan berubah setelah disorting, 
        // buat copy array jika ingin mencoba semua algoritma sekaligus
        bubbleSort(data.clone());
        selectionSort(data.clone());
        insertionSort(data.clone());
        
        System.out.println("\n--- Quick Sort ---");
        quickSort(data.clone(), 0, data.length - 1);
        
        System.out.println("\n--- Merge Sort ---");
        mergeSort(data.clone(), 0, data.length - 1);
    }
}