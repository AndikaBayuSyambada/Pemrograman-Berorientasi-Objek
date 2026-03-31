public class Lingkaran {
    public static void main(String[] args) {
        float PHI=3.14f;
        int r;
        r=7;

        double luas=PHI*r*r;
        double kel=2*PHI*r;
        
        System.out.println("phi : " +PHI);
        System.out.println("r : " +r);
        System.out.println("Luas = phi*r*r");
        System.out.println("     = " +luas);
        System.out.println("Keliling = 2*phi*r");
        System.out.println("         = " +kel);
    }
}
