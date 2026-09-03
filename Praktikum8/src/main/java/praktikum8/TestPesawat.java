/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class TestPesawat {
    public static void main(String[]args){
        Pesawat airbus=new Pesawat();
        PesawatTempur f16=new PesawatTempur();
        System.out.println("...Airbus...");
        airbus.terbang();
        airbus.Mendarat();
        
        System.out.println("...F16...");
        f16.terbang();
        f16.Terbang();
        f16.Mendarat();
        f16.Manuver();
    } 
}
