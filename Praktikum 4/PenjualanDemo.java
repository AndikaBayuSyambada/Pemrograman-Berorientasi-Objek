import java.util.Scanner;
public class PenjualanDemo {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String pilihan;

        do { 
            Penjualan jual = new Penjualan();

            System.out.print("Masukkan Kode Barang : ");
            String kode = input.next();
            System.err.print("Masukkan Nama Barang : ");
            String nama = input.next();
            System.out.print("Masukkan Harga : ");
            float harga = input.nextFloat();
            System.out.print("Masukkan Jumlah : ");
            int jumlah = input.nextInt();

            jual.setData(kode, nama, harga, jumlah);
            jual.cetakNota();

            System.out.println("Input data lagi [Y/T]? ");
            pilihan = input.next();
        } while (pilihan.equalsIgnoreCase("Y"));

        System.out.println("Terima kasih!!");
        input.close();
    }
}
