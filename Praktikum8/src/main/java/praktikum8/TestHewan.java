/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
import java.util.Scanner;

public class TestHewan {
    public static void main(String[] args) {
        // PERBAIKAN: Menggunakan System.in secara langsung
        Scanner input = new Scanner(System.in); 
        int pilihan;

        do {
            System.out.println("=================================");
            System.out.println("      MENU PILIHAN HEWAN         ");
            System.out.println("=================================");
            System.out.println("1. Singa");
            System.out.println("2. Elang");
            System.out.println("3. Lebah");
            System.out.println("4. Paus");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda (1-5): ");
            pilihan = input.nextInt();
            System.out.println("=================================");

            Hewan hewanDipilih = null;

            switch (pilihan) {
                case 1:
                    hewanDipilih = new Singa();
                    break;
                case 2:
                    hewanDipilih = new Elang();
                    break;
                case 3:
                    hewanDipilih = new Lebah();
                    break;
                case 4:
                    hewanDipilih = new Paus();
                    break;
                case 5:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }

            if (hewanDipilih != null) {
                System.out.println("Informasi Hewan:");
                System.out.println("Jenis   : " + hewanDipilih.jenis);
                System.out.println("Ciri    : " + hewanDipilih.ciri);
                
                hewanDipilih.suara();
                hewanDipilih.berjalan();
                hewanDipilih.bernafas(); 
                System.out.println("=================================\n");
            }

        } while (pilihan != 5);

        input.close();
    }
}