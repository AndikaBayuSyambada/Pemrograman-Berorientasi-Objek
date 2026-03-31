public class NilaiDemo {
    public static void main(String[] args) {
        Nilai nilaiku=new Nilai();

        Nilai nilaimu=new Nilai("08982983", "Ghiyatsi", 90, 80, 87);
        
        nilaiku.nim="A11.2024.15552";
        nilaiku.nama="Andika Bayu Syambada";
        nilaiku.nilaiTugas = 95;
        nilaiku.nilaiUts = 80;
        nilaiku.nilaiUas = 87;

        nilaiku.hitungNilai();  
        nilaiku.cetakNilai(); 
        System.out.println("");  
        nilaimu.hitungNilai();
        nilaimu.cetakNilai();
    }
}
