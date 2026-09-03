/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum10;

/**
 *
 * @author Andika Bayu S
 */
abstract class Binatang {
    abstract void makan();
    abstract void tidur();
    
    void mati() {
        System.out.println("mati.");
    }
}