public class NilaiDemo{
    public static void main(String[] args) {
        Nilai nilaiku = new Nilai();
        Nilai nilaimu = new Nilai("A11.2026.00007","Ghiyatsi",90,80,87);
        nilaiku.nim = "A11.2026.00001";
        nilaiku.nama = "Najwa";
        nilaiku.nilaiTugas = 95;
        nilaiku.nilaiUts = 80;
        nilaiku.nilaiUas = 88;
        nilaimu.hitungNilai();
        nilaimu.cetakNilai();

        Nilai nilaidia = new Nilai();
        nilaidia.isiData();
        nilaidia.hitungNilai();
        nilaidia.cetakNilai();

    }
}