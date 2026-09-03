import java.util.Scanner;

public class NilaiDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Jumlah Mahasiswa yang ingin diinput: "); 
        int n = input.nextInt();
        
        // Deklarasi Array Object
        Nilai[] daftarMhs = new Nilai[n]; 

        // Input Data
        for (int i = 0; i < n; i++) {
            System.out.println("\nMahasiswa Ke - " + (i + 1));
            daftarMhs[i] = new Nilai(); // Wajib inisialisasi setiap index
            daftarMhs[i].isiData();
            daftarMhs[i].hitungNilai(); // Hitung dulu agar nHuruf & predikat terisi
        }

        // Tampilkan Data
        Nilai temp = new Nilai(); // Object sementara untuk memanggil method judul
        temp.judul();
        for (int i = 0; i < n; i++) {
            daftarMhs[i].daftarNilai();
        }
    }
}