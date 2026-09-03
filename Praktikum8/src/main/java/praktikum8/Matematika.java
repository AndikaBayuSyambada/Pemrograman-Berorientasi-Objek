package praktikum8;
public class Matematika {
    int a, b, hasil;
    float hasil1;
    double hasil2;
    void pertambahan(int a, int b){
        hasil = a + b;
        System.out.println("Pertambahan : "+a+ " + " +b+ " = " +hasil);
    }

    void pengurangan(int a, int b){
        hasil = a - b;
        System.out.println("Pengurangan : "+a+ " - " +b+ " = " +hasil);
    }

    void perkalian(int a, int b){
        hasil = a * b;
        System.out.println("Perkalian : "+a+ " * " +b+ " = " +hasil);
    }

    void pembagian(int a, int b){
        hasil = a / b;
        System.out.println("Pembagian : "+a+ " / " +b+ " = " +hasil);
    }


    //  Overloading
    void pertambahan(float a, float b){
        hasil1 = a + b;
        System.out.println("Pertambahan : "+a+ " + " +b+ " = " +hasil1);
    }

    void pengurangan(float a, float b){
        hasil1 = a - b;
        System.out.println("Pengurangan : "+a+ " - " +b+ " = " +hasil1);
    }

    void perkalian(float a, float b){
        hasil1 = a * b;
        System.out.println("Perkalian : "+a+ " * " +b+ " = " +hasil1);
    }

    void pembagian(float a, float b){
        hasil1 = a / b;
        System.out.println("Pembagian : "+a+ " / " +b+ " = " +hasil1);
    }
    
    void pertambahan(double a, double b, double c){
        hasil2 = a + b + c;
        System.out.println("Pertambahan : " +a+ " + " +b+ " + " +c+ " = " +hasil2);
    }

    void pengurangan(double a, double b, double c){
        hasil2 = a - b - c;
        System.out.println("Pengurangan : " +a+ " - " +b+ " - " +c+ " = " +hasil2);
    }

    void perkalian(double a, double b, double c){
        hasil2 = a * b * c;
        System.out.println("Perkalian : " +a+ " * " +b+ " * " +c+ " = " +hasil2);
    }

    void pembagian(double a, double b, double c){
        hasil2 = a / b / c;
        System.out.println("Pembagian : " +a+ " / " +b+ " / " +c+ " = " +hasil2);
    }
}