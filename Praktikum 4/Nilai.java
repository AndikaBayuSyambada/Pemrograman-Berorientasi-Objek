import java.util.Scanner;
public class Nilai {
    String nim, nama, predikat;
    char  nHuruf;
    float nilaiUts, nilaiTugas, nilaiUas, pNilaiUts, pNilaiTugas, pNilaiUas, nilaiAkhir;

    public Nilai(){

    }

    public Nilai(String nim, String nama, float nilaiUts, float nilaiTugas, float nilaiUas){
        this.nim=nim; this.nama=nama;
        this.nilaiTugas=nilaiTugas; this.nilaiUts=nilaiUts; this.nilaiUas=nilaiUas;
    }

    void isiData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM    : "); nim = input.nextLine();
        System.out.print("Masukkan Nama   : "); nama = input.nextLine();
        System.out.print("Nilai Tugas     : "); nilaiTugas = input.nextFloat();
        System.out.print("Nilai UTS       : "); nilaiUts = input.nextFloat();
        System.out.print("Nilai UAS       : "); nilaiUas = input.nextFloat();    
    }

    void hitungNilai(){
        pNilaiTugas=0.2f*nilaiTugas;
        pNilaiUts=0.35f*nilaiUts;
        pNilaiUas=0.45f*nilaiUas;
        nilaiAkhir=pNilaiTugas+pNilaiUts+pNilaiUas;
    }

    char getNilHuruf(float nilai) {
        if (nilai >= 85) nHuruf = 'A';
        else if (nilai >= 70) nHuruf = 'B';
        else if (nilai >= 60) nHuruf = 'C';
        else if (nilai >= 40) nHuruf = 'D';
        else nHuruf = 'E';
        return nHuruf;
    }

    String getPredikat(char huruf) {
        switch (huruf) {
            case 'A': predikat = "Apik"; break;
            case 'B': predikat = "Baik"; break;
            case 'C': predikat = "Cukup"; break;
            case 'D': predikat = "Dablek"; break;
            default: predikat = "Elek"; // Untuk case 'E'
    }
    return predikat;
}

    void cetakNilai(){
        System.out.println("Nim     :   " +nim);
        System.out.println("Nama    :   " +nama);
        System.out.println("N.Tugas :   " +nilaiTugas+ " 30% : " +pNilaiTugas );
        System.out.println("N.UTS   :   " +nilaiUts+ " 35% : " +pNilaiUts );
        System.out.println("N.UAS   :   " +nilaiUas+ " 35% : " +pNilaiUas );
        System.out.println("N.Akhir :   " +nilaiAkhir);
        System.out.println("Nilai Huruf : " +getNilHuruf(nilaiAkhir));
        System.out.println("Predikat : " +getPredikat(nHuruf));
    }

    void judul() {
        System.out.println("\n=== Daftar Nilai PBO ===");
        System.out.println("Nim\t\tNama\tTugas\tUTS\tUAS\tAkhir\tHuruf\tPredikat");
        System.out.println("-------------------------------------------------------------------------------");
    }

    void daftarNilai(){
        System.out.println(nim + "\t" + nama + "\t" + nilaiTugas + "\t" +
                       nilaiUts + "\t" + nilaiUas + "\t" + nilaiAkhir +
                       "\t" + nHuruf + "\t" + predikat);
    }
}