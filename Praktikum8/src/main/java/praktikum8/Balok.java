/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Balok extends PersegiPanjang{
    double t, volume;
    void hitungVolume(){
        volume=luas*t;
    }
    
    void cetak(){
        super.cetak();
        System.out.println("Tinggi/t: "+t);
        System.out.println("Volume/t: "+volume);
    }
    
    void cetak(String nama){
        System.out.println("Balok/t: "+nama);
        cetak();
    }
}
