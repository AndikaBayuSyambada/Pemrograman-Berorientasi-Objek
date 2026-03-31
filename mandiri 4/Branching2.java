public class Branching2 {
    public static void main(String args[]) {
        char nilai = 'a';
        String predikat;

        switch(nilai) {
            case 'a': 
                predikat = "Excellent"; 
                break;
            case 'b': 
                predikat = "Good"; 
                break;
            case 'c': 
                predikat = "Fair"; 
                break;
            case 'd': 
                predikat = "Dafuq"; 
                break;
            case 'e': 
                predikat = "Fail"; 
                break;
            default: 
                predikat = "No Such Grade";
        }

        System.out.println("Nilai : " + nilai);
        System.out.println("Predikat : " + predikat);
    }
}