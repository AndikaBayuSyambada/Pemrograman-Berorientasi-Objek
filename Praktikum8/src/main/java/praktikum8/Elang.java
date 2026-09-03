/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Elang extends Hewan {
    public Elang() {
        super("Burung", "Memiliki paruh tajam dan penglihatan yang sangat jeli.");
    }

    @Override
    public void suara() {
        System.out.println("Suara   : Menjerit nyaring (Kreeee!)");
    }

    @Override
    public void berjalan() {
        System.out.println("Bergerak: Terbang menggunakan sayap");
    }

    @Override
    public void bernafas() {
        System.out.println("Bernafas: Menggunakan Paru-paru dan Kantung Udara");
    }
}
