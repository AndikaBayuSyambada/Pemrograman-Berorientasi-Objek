import java.util.Scanner;
public class Penjualan {
    Scanner input = new Scanner("system.in");
    String kode, nama;
    float harga;
    int jumlah;

    void setData(String kode, String nama, float harga, int jumlah){
        this.kode= kode;
        this.nama=nama;
        this.harga=harga;
        this.jumlah=jumlah;
        }

    float getTotalPembelian(){
        return harga*jumlah;
        }

    String getBonus(){
        float total = getTotalPembelian();
        if(total >= 500000 && jumlah > 5){
            return "Setrika";
        }else if(total >= 100000 && jumlah > 3){
           return "Payung";
        }else if(total >= 50000 && jumlah > 2){
            return "Ballpoint";
        }else{
            return "Tidak mendapat bonus";
        }
    }

    void cetakNota(){
        System.out.println(" ");
        System.out.println("=====Nota Penjualan=====");
        System.out.println("Kode Barang : "+kode);
        System.out.println("Nama Barang : "+nama);
        System.out.println("Harga Satuan : "+harga);
        System.out.println("Jumlah Pembelian : "+jumlah);
        System.out.println("Total Pembelian: "+getTotalPembelian());
        System.out.println("Bonus yang Didapat : "+getBonus());
        System.out.println("=======================");
    }
}

