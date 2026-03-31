import java.util.Scanner;
public class Suhu {
    int c;
    float hasil;
    Scanner in=new Scanner(System.in);

    public Suhu(){}

    public Suhu(int c){
        this.c=c;
    }

    void inputC(){
        System.out.print("Masukkan suhu(C) : "); 
        c=in.nextInt();
    }

    //  Kelvin
    void cToK(int c){
        hasil= c + 273.15f;
        System.out.println(c+" C = "+hasil+" K ");
    }
    float cTK(int c){
        return c + 273.15f;
    }

    //  Fahrenheit
    void cToF(int c){
        hasil= c * 1.8f + 32;
        System.out.println(c+" C = "+hasil+" F ");
    }
    float cTF(int c){
        return c * 1.8f + 32;
    }

    //  Rankine
    void cToRa(int c){
        hasil= c * 1.8f + 491.67f;
        System.out.println(c+" C = "+hasil+" Ra ");
    }
    float cTRa(int c){
        return c * 1.8f + 491.67f;
    }

    //  Delisle
    void cToDe(int c){
        hasil= (100 - c) * 1.5f;
        System.out.println(c+" C = "+hasil+" De ");
    }
    float cTDe(int c){
        return (100 - c) * 1.5f;
    }

    //  Newton
    void cToN(int c){
        hasil= c * 33/100;
        System.out.println(c+" C = "+hasil+" N ");
    }
    float cTN(int c){
        return c * 33/100;
    }

    //  Réaumur
    void cToRe(int c){
        hasil= c * 0.8f;
        System.out.println(c+" C = "+hasil+" Re ");
    }
    float cTRe(int c){
        return c * 0.8f;
    }

    //  Rømer
    void cToRo(int c){
        hasil= c * 21/40 + 7.5f;
        System.out.println(c+" C = "+hasil+" Ro ");
    }
    float cTRo(int c){
        return c * 21/40 + 7.5f;
    }
}
