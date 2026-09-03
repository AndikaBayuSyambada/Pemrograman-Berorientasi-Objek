/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Paus extends Hewan {
    public Paus() {
        super("Mamalia Air", "Hewan sangat besar yang hidup di laut.");
    }

    @Override
    public void suara() {
        System.out.println("Suara   : Nyanyian frekuensi rendah di dalam air");
    }

    @Override
    public void berjalan() {
        System.out.println("Bergerak: Berenang menggunakan sirip dan ekor");
    }

    @Override
    public void bernafas() {
        System.out.println("Bernafas: Menggunakan Paru-paru (mengambil udara via lubang sembur)");
    }
}
