public class Branching {
    public static void main(String args[]) {
        char nilai = 'a';
        String predikat;

        if(nilai == 'a') {
            predikat = "Excellent";
        } else if(nilai == 'b') {
            predikat = "Good";
        } else if(nilai == 'c') {
            predikat = "Fair";
        } else if(nilai == 'd') {
            predikat = "Dafuq";
        } else if(nilai == 'e') {
            predikat = "Fail";
        } else {
            predikat = "No Such Grade";
        }

        System.out.println("Nilai : " + nilai);
        System.out.println("Predikat : " + predikat);
    }
}