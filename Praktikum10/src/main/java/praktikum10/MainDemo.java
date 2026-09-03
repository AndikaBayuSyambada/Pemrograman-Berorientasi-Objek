/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

/**
 *
 * @author Andika Bayu S
 */
public class MainDemo {
    public static void main(String[] args) {
        System.out.println("=== SIMULASI TOKO MEBEL NYATA ===");
        System.out.println();

        // 1. Menguji Meja Tamu
        MejaTamu mejaKita = new MejaTamu();
        mejaKita.harga = 1500000;       
        mejaKita.bahan = "Kayu Jati";   
        mejaKita.jmlKaki = 4;           
        mejaKita.bentukKaca = "Oval";   
        
        System.out.println("Spesifikasi Barang:");
        System.out.println("> Jenis: Meja Tamu " + mejaKita.bentukKaca);
        System.out.println("> Bahan: " + mejaKita.bahan);
        mejaKita.discount(mejaKita.harga); // Memanggil method diskon
        System.out.println("---------------------------------");

        // 2. Menguji Almari Pakaian
        AlmariPakaian lemariBaju = new AlmariPakaian();
        lemariBaju.harga = 2500000;
        lemariBaju.bahan = "Kayu Mahoni";
        lemariBaju.roda = false;        
        lemariBaju.jmlPintu = 3;        
        
        System.out.println("");
        System.out.println("Spesifikasi Barang:");
        System.out.println("> Jenis: Almari Pakaian " + lemariBaju.jmlPintu + " Pintu");
        System.out.println("> Bahan: " + lemariBaju.bahan);
        lemariBaju.discount(lemariBaju.harga); // Memanggil method diskon
        System.out.println("---------------------------------");

        // 3. Menguji Almari Makan
        AlmariMakan lemariDapur = new AlmariMakan();
        lemariDapur.harga = 2000000;
        lemariDapur.bahan = "Aluminium";
        lemariDapur.roda = true;
        lemariDapur.jmlRoda = 4;
        
        System.out.println("");
        System.out.println("Spesifikasi Barang:");
        System.out.println("> Jenis: Almari Makan dengan " + lemariDapur.jmlRoda + " Roda");
        System.out.println("> Bahan: " + lemariDapur.bahan);
        lemariDapur.discount(lemariDapur.harga); // Memanggil method diskon
        System.out.println("---------------------------------");
    }
}