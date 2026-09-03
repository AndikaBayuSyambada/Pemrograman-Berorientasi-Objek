/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Hewan {
    String jenis;
    String ciri;

    // Konstruktor untuk mempermudah pengisian atribut
    public Hewan(String jenis, String ciri) {
        this.jenis = jenis;
        this.ciri = ciri;
    }

    public void suara() {
        System.out.println("Hewan ini mengeluarkan suara.");
    }

    public void berjalan() {
        System.out.println("Hewan ini bergerak/berjalan.");
    }

    // Ditambahkan untuk Soal No. 3
    public void bernafas() {
        System.out.println("Hewan ini bernafas.");
    }
}
