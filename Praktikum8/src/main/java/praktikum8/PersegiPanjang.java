package praktikum8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andika Bayu S
 */
public class PersegiPanjang {
    double p,l,luas;
    void hitungLuas(){
        luas=p*l;
    }
    void cetak(){
        System.out.println("Panjang\t: "+p);
        System.out.println("Lebar\t: "+l);
        System.out.println("Luas\t: "+luas);
    }
}
