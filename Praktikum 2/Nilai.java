public class Nilai {
    String nim, nama;
    float nilaiUts, nilaiTugas, nilaiUas, pNilaiUts, pNilaiTugas, pNilaiUas, nilaiAkhir;
    public Nilai(){

    }
    public Nilai(String nim, String nama, float nilaiUts, float nilaiTugas, float nilaiUas){
        this.nim=nim; this.nama=nama;
        this.nilaiTugas=nilaiTugas; this.nilaiUts=nilaiUts; this.nilaiUas=nilaiUas;
    }

    void hitungNilai(){
        pNilaiTugas=0.2f*nilaiTugas;
        pNilaiUts=0.35f*nilaiUts;
        pNilaiUas=0.45f*nilaiUas;
        nilaiAkhir=pNilaiTugas+pNilaiUts+pNilaiUas;
    }

    void cetakNilai(){
        System.out.println("Nim     :   " +nim);
        System.out.println("Nama    :   " +nama);
        System.out.println("N.Tugas :   " +nilaiTugas+ " 20% : " +pNilaiTugas );
        System.out.println("N.UTS   :   " +nilaiUts+ " 35% : " +pNilaiUts );
        System.out.println("N.UAS   :   " +nilaiUas+ " 45% : " +pNilaiUas );
        System.out.println("N.Akhir :   " +nilaiAkhir);
    } 
}
