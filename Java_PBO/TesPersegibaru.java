public class TesPersegibaru {
    public static void main(String[] args) {
        Persegibaru persegiku=new Persegibaru();
        persegiku.p=20;
        persegiku.l=9;
        persegiku.info();
        persegiku.setP(90);
        persegiku.setL(50);
        persegiku.info();
        System.out.println("luas : "+persegiku.getLuas());
        System.out.println("kel : "+persegiku);
    }
}
