/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

/**
 *
 * @author Andika Bayu S
 */
public class MejaTamu extends Meja implements Discountable {
    String bentukKaca;

    @Override
    public void discount(int harga) {
        // Logika hitung diskon 10%
        int potongan = (int) (harga * 0.10);
        int hargaAkhir = harga - potongan;
        
        System.out.println("--- HITUNG DISKON MEJA TAMU ---");
        System.out.println("Harga Awal  : Rp " + harga);
        System.out.println("Diskon (10%): Rp " + potongan);
        System.out.println("Harga Akhir : Rp " + hargaAkhir);
    }
}
