public class SuhuDemo {
    public static void main(String[] args) {
        Suhu Suhuku = new Suhu();
        Suhuku.cToF(25);
        Suhuku.cToK(25);
        Suhuku.cToRa(25);
        Suhuku.cToDe(25);
        Suhuku.cToN(25);
        Suhuku.cToRe(25);
        Suhuku.cToRo(25);
        System.out.println(" ");

        System.out.println("C ke F : "+Suhuku.cTF(25));
        System.out.println("C ke K : "+Suhuku.cTK(25));
        System.out.println("C ke Ra : "+Suhuku.cTRa(25));
        System.out.println("C ke De : "+Suhuku.cTDe(25));
        System.out.println("C ke Tn : "+Suhuku.cTN(25));
        System.out.println("C ke Re : "+Suhuku.cTRe(25));
        System.out.println("C ke Ro : "+Suhuku.cTRo(25));
        System.out.println(" ");

        Suhu suhumu = new Suhu(20);
        suhumu.cToF(suhumu.c);
        suhumu.cToK(suhumu.c);
        suhumu.cToRa(suhumu.c);
        suhumu.cToDe(suhumu.c);
        suhumu.cToN(suhumu.c);
        suhumu.cToRe(suhumu.c);
        suhumu.cToRo(suhumu.c);
        System.out.println(" ");

        Suhu suhunya = new Suhu();
        suhunya.inputC();
        suhunya.cToK(suhunya.c);
        suhunya.cToF(suhunya.c);
        suhunya.cToRa(suhunya.c);
        suhunya.cToDe(suhunya.c);
        suhunya.cToN(suhunya.c);
        suhunya.cToRe(suhunya.c);
        suhunya.cToRo(suhunya.c);
    }
}