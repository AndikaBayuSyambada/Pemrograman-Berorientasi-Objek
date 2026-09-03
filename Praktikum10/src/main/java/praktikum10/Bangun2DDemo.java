/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

/**
 *
 * @author Andika Bayu S
 */
class Bangun2DDemo{
    public static void main(String[]args){
        BujurSangkar bs=new BujurSangkar(5);
        bs.cetakKeliling();
        bs.cetakLuas();
        
        System.out.println("----------");
        PersegiPanjang pj=new PersegiPanjang(10,5);
        pj.cetakLuas();
        pj.cetakKeliling();
    }
}
