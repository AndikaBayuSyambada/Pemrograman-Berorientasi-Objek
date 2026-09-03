/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class BalokDemo {
    public static void main(String[]args){
        Balok a=new Balok();
        a.p=10;
        a.l=5;
        a.t=5;
        a.hitungLuas();
        a.hitungVolume();
        a.cetak();
        System.out.println("");
        a.l=7;
        a.hitungLuas();
        a.hitungVolume();
        a.cetak("Balokku");
    }
}
