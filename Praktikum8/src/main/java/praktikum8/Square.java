/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Square extends Rectangle {

    // Overloading Konstruktor 1
    public Square() {
        super();
    }

    // Overloading Konstruktor 2
    public Square(double side) {
        super(side, side); // memanggil konstruktor Rectangle(width, length)
    }

    // Overloading Konstruktor 3
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return super.getWidth(); // atau getLength() karena nilainya sama
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    // Overriding setWidth agar integritas persegi tetap terjaga (sisi sama panjang)
    @Override
    public void setWidth(double side) {
        this.setSide(side);
    }

    // Overriding setLength agar integritas persegi tetap terjaga (sisi sama panjang)
    @Override
    public void setLength(double side) {
        this.setSide(side);
    }

    // Overriding method toString() milik Rectangle
    @Override
    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}