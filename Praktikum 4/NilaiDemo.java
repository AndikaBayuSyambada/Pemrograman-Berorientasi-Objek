import java.util.Scanner;
public class NilaiDemo {
    public static void main(String[] args) {

        Nilai nilaiku=new Nilai();
        nilaiku.nim="A11.2024.15551";
        nilaiku.nama="Andika";
        nilaiku.nilaiTugas = 80;
        nilaiku.nilaiUts = 90;
        nilaiku.nilaiUas = 88;
        nilaiku.hitungNilai();
        nilaiku.cetakNilai();

        Nilai nilaimu=new Nilai();
        nilaimu.isiData();
        nilaimu.hitungNilai();
        nilaimu.cetakNilai();

        // cetak ledger, per kolom
        nilaimu.judul();
        nilaiku.daftarNilai();
        nilaimu.daftarNilai();

        // buat array object, masukkan 5 data, gunakan perulangan
        // cetak hasilnya, gunakan method juduk & daftarnilai

        Scanner input=new Scanner(System.in);
        System.out.print("Jumlah Mahasiswa : "); int n=input.nextInt();
        Nilai[] nilaibyk=new Nilai[n];  // array object
        for(int i=0; i<n; i++){
            System.out.println("Mahasiswa Ke : "+(i+1));
            nilaibyk[i]=new Nilai();
            nilaibyk[i].isiData();
            nilaibyk[i].cetakNilai();
        }
        nilaibyk[0].judul();
        for (int i=0; i<n; i++){
            nilaibyk[i].daftarNilai();
        }
    }
}
