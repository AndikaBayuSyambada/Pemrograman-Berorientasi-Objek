import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Inisialisasi ArrayList
        ArrayList<Integer> nilai1 = new ArrayList<Integer>();
        ArrayList<Integer> nilai2 = new ArrayList<Integer>();
        ArrayList<Integer> jumlah = new ArrayList<Integer>();

        // Mengisi data (Simulasi input)
        System.out.println("Nilai 1");
        for (int i = 0; i < 5; i++) {
            nilai1.add(i); 
            System.out.println("Index ke " + i + " = " + nilai1.get(i));
        }

        System.out.println("Nilai 2");
        for (int i = 0; i < 5; i++) {
            nilai2.add(i); 
            System.out.println("Index ke " + i + " = " + nilai2.get(i));
        }

        // Operasi Penjumlahan
        for (int i = 0; i < 5; i++) {
            jumlah.add(nilai1.get(i) + nilai2.get(i));
        }

        // Cetak hasil penjumlahan
        System.out.println("Hasil Jumlah nilai1 + nilai2");
        for (int i = 0; i < 5; i++) {
            System.out.println("Jumlah index ke " + i + " = " + jumlah.get(i));
        }
    }
}