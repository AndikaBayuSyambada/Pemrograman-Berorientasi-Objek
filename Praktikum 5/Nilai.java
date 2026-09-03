import java.util.Scanner;

public class Nilai {
    String nim, nama, predikat;
    char nHuruf;
    float nilaiUts, nilaiTugas, nilaiUas, pNilaiUts, pNilaiTugas, pNilaiUas, nilaiAkhir;

    public Nilai() {}

    void isiData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM    : "); nim = input.nextLine();
        System.out.print("Masukkan Nama   : "); nama = input.nextLine();
        System.out.print("Nilai Tugas     : "); nilaiTugas = input.nextFloat();
        System.out.print("Nilai UTS       : "); nilaiUts = input.nextFloat();
        System.out.print("Nilai UAS       : "); nilaiUas = input.nextFloat();    
    }

    void hitungNilai() {
        pNilaiTugas = 0.2f * nilaiTugas;
        pNilaiUts = 0.35f * nilaiUts;
        pNilaiUas = 0.45f * nilaiUas;
        nilaiAkhir = pNilaiTugas + pNilaiUts + pNilaiUas;
        
        // Otomatis isi nHuruf dan predikat setelah hitung
        this.nHuruf = getNilHuruf(nilaiAkhir);
        this.predikat = getPredikat(this.nHuruf);
    }

    char getNilHuruf(float nilai) {
        if (nilai >= 85) return 'A';
        else if (nilai >= 70) return 'B';
        else if (nilai >= 60) return 'C';
        else if (nilai >= 40) return 'D';
        else return 'E';
    }

    String getPredikat(char huruf) {
        switch (huruf) {
            case 'A': return "Apik";
            case 'B': return "Baik";
            case 'C': return "Cukup";
            case 'D': return "Dablek";
            default: return "Elek";
        }
    }

    void cetakNilai() {
        System.out.println("\n--- Detail Nilai ---");
        System.out.println("Nim     : " + nim);
        System.out.println("Nama    : " + nama);
        System.out.println("N.Akhir : " + nilaiAkhir);
        System.out.println("Huruf   : " + nHuruf);
        System.out.println("Predikat: " + predikat);
    }

    void judul() {
        System.out.println("\n=== Daftar Nilai PBO ===");
        System.out.println("Nim\t\tNama\tTugas\tUTS\tUAS\tAkhir\tHuruf\tPredikat");
        System.out.println("-------------------------------------------------------------------------------");
    }

    void daftarNilai() {
        System.out.println(nim + "\t" + nama + "\t" + nilaiTugas + "\t" +
                           nilaiUts + "\t" + nilaiUas + "\t" + nilaiAkhir +
                           "\t" + nHuruf + "\t" + predikat);
    }
}