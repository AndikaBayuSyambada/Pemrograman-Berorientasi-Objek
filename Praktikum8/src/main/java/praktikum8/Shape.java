/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author Andika Bayu S
 */
public class Shape {
    private String color = "red";
    private boolean filled = true;

    // Overloading Konstruktor 1
    public Shape() {
    }

    // Overloading Konstruktor 2
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Overriding dari kelas Object java
    @Override
    public String toString() {
        return "Shape[color=" + color + ",filled=" + filled + "]";
    }
}
