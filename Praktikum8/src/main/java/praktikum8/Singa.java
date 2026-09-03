/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Singa extends Hewan {
    public Singa() {
        super("Mamalia", "Memiliki rambut lebat di leher (jantan) dan hidup berkelompok.");
    }

    @Override
    public void suara() {
        System.out.println("Suara   : Mengaum keras (Roar!)");
    }

    @Override
    public void berjalan() {
        System.out.println("Bergerak: Berjalan dan berlari menggunakan 4 kaki");
    }

    @Override
    public void bernafas() {
        System.out.println("Bernafas: Menggunakan Paru-paru");
    }
}
