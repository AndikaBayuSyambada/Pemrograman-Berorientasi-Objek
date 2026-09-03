/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

/**
 *
 * @author Andika Bayu S
 */
public class AlmariPakaian extends Almari implements Discountable {
    int jmlPintu;

    @Override
    public void discount(int harga) {
        // Logika hitung diskon 20%
        int potongan = (int) (harga * 0.20);
        int hargaAkhir = harga - potongan;
        
        System.out.println("--- HITUNG DISKON ALMARI PAKAIAN ---");
        System.out.println("Harga Awal  : Rp " + harga);
        System.out.println("Diskon (20%): Rp " + potongan);
        System.out.println("Harga Akhir : Rp " + hargaAkhir);
    }
}
