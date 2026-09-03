/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class MainDemo {
    public static void main(String[] args) {
        System.out.println("--- UJI COBA CIRCLE ---");
        Circle c1 = new Circle(5.0, "yellow", false);
        System.out.println(c1.toString());
        System.out.println("Luas      : " + c1.getArea());
        System.out.println("Keliling  : " + c1.getPerimeter());
        System.out.println();

        System.out.println("--- UJI COBA RECTANGLE ---");
        Rectangle r1 = new Rectangle(4.0, 6.0, "blue", true);
        System.out.println(r1.toString());
        System.out.println("Luas      : " + r1.getArea());
        System.out.println("Keliling  : " + r1.getPerimeter());
        System.out.println();

        System.out.println("--- UJI COBA SQUARE ---");
        Square s1 = new Square(4.0, "green", true);
        System.out.println(s1.toString());
        System.out.println("Luas awal : " + s1.getArea());
        
        // Ubah panjang sisi menggunakan overriding method
        s1.setWidth(10.0); 
        System.out.println("Setelah setWidth(10.0): " + s1.toString());
        System.out.println("Luas baru : " + s1.getArea());
    }
}
