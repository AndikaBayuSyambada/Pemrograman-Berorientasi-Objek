/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    // Overloading Konstruktor 1
    public Rectangle() {
        super();
    }

    // Overloading Konstruktor 2
    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    // Overloading Konstruktor 3
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    // Overriding method toString() milik Shape
    @Override
    public String toString() {
        return "Rectangle[" + super.toString() + ",width=" + width + ",length=" + length + "]";
    }
}