/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum9;

/**
 *
 * @author Andika Bayu S
 */
public class DataMahasiswa {
    public String getNilHuruf(float nilaiAkhir) {
        if (nilaiAkhir >= 80) {
            return "A";
        } else if (nilaiAkhir >= 70) {
            return "B";
        } else if (nilaiAkhir >= 60) {
            return "C";
        } else if (nilaiAkhir >= 50) {
            return "D";
        } else {
            return "E";
        }
    }
    
    public String getPredikat(String nilaiHuruf) {
        switch (nilaiHuruf) {
            case "A":
                return "Sangat Baik";
            case "B":
                return "Baik";
            case "C":
                return "Cukup";
            case "D":
                return "Kurang";
            case "E":
                return "Gagal";
            default:
                return "-";
        }
    }
}