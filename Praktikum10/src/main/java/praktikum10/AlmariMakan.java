/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

/**
 *
 * @author Andika Bayu S
 */
class AlmariMakan extends Almari implements Discountable {
    int jmlRoda;

    @Override
    public void discount(int harga) {
        // Logika hitung diskon 15%
        int potongan = (int) (harga * 0.15);
        int hargaAkhir = harga - potongan;
        
        System.out.println("--- HITUNG DISKON ALMARI MAKAN ---");
        System.out.println("Harga Awal  : Rp " + harga);
        System.out.println("Diskon (15%): Rp " + potongan);
        System.out.println("Harga Akhir : Rp " + hargaAkhir);
    }
}
