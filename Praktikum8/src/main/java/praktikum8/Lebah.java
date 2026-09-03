/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Lebah extends Hewan {
    public Lebah() {
        super("Serangga", "Memiliki sengatan defensif dan menghasilkan madu.");
    }

    @Override
    public void suara() {
        System.out.println("Suara   : Berdengung (Bzzz!)");
    }

    @Override
    public void berjalan() {
        System.out.println("Bergerak: Terbang menggunakan sayap kecil");
    }

    @Override
    public void bernafas() {
        System.out.println("Bernafas: Menggunakan Trakea");
    }
}
