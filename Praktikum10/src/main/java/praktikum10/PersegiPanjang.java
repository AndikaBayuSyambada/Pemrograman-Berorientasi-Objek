/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

/**
 *
 * @author Andika Bayu S
 */
public class PersegiPanjang extends Bangun2D{
    private int panjang,lebar;
    
    public PersegiPanjang(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
        System.out.println("Panjang persegi panjang : "+ panjang);
        System.out.println("Lebar persegi panjang : "+lebar);
    }
    
    public void cetakLuas(){
        int luas = panjang * lebar;
        System.out.println("Luas Persegi Panjang : "+luas);
    }
    
    public void cetakKeliling(){
        int keliling = 2*(panjang+lebar);
        System.out.println("Keliling Persegi Panjang : "+keliling);
    }
}
