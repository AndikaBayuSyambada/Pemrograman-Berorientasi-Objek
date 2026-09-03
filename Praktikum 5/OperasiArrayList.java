import java.util.ArrayList;
import java.util.Scanner;

public class OperasiArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 1. Input Jumlah Data
        System.out.print("Masukkan jumlah data yang ingin diproses: ");
        int n = input.nextInt();
        
        ArrayList<Double> list1 = new ArrayList<Double>();
        ArrayList<Double> list2 = new ArrayList<Double>();
        
        // 2. Mengisi Data list1
        System.out.println("\n--- Input Data Pertama ---");
        for (int i = 0; i < n; i++) {
            System.out.print("Index ke-" + i + ": ");
            list1.add(input.nextDouble());
        }
        
        // 3. Mengisi Data list2
        System.out.println("\n--- Input Data Kedua ---");
        for (int i = 0; i < n; i++) {
            System.out.print("Index ke-" + i + ": ");
            list2.add(input.nextDouble());
        }
        
        // 4. Melakukan Operasi dan Menampilkan Hasil
        System.out.println("\n=================================");
        System.out.println("Hasil Operasi Aritmatika:");
        System.out.println("=================================");
        
        for (int i = 0; i < n; i++) {
            double a = list1.get(i);
            double b = list2.get(i);
            
            System.out.println("Index ke-" + i + " [" + a + " dan " + b + "]:");
            System.out.println("  Penjumlahan : " + (a + b));
            System.out.println("  Pengurangan : " + (a - b));
            System.out.println("  Perkalian   : " + (a * b));
            
            // Penanganan Error Pembagian (Divide by Zero)
            if (b != 0) {
                System.out.println("  Pembagian   : " + (a / b));
            } else {
                System.out.println("  Pembagian   : Tidak bisa dibagi dengan 0");
            }
            System.out.println("---------------------------------");
        }
    }
}