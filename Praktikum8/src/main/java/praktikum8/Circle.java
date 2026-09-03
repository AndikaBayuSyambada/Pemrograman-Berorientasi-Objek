/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Circle extends Shape {
    private double radius = 1.0;

    // Overloading Konstruktor 1
    public Circle() {
        super();
    }

    // Overloading Konstruktor 2
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    // Overloading Konstruktor 3
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Overriding method toString() milik Shape
    @Override
    public String toString() {
        return "Circle[" + super.toString() + ",radius=" + radius + "]";
    }
}
