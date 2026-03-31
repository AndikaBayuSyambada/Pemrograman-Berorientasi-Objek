public class MobilDemo2 {
    public static void main(String[] args) {
        Mobil2 avanza = new Mobil2();
        Mobil2 xenia = new Mobil2();

        Mobil2.hidupkanMobil("Avanza Silver");
        Mobil2.ubahGigi("Avanza Silver");
        avanza.maju();
        avanza.mundur();
        avanza.belok();
        System.out.println("Roda Avanza   : " + avanza.roda);
        System.out.println("Roda Xenia    : " + xenia.roda);
        System.out.println("Mesin Avanza  : " +Mobil2.mesin);
        System.out.println("Mesin Xenia   : " +Mobil2.mesin);

        //ubah nilai
        avanza.roda=5;
        System.out.println("Roda Avanza   : " +avanza.roda);
        System.out.println("Roda Avanza   : " +xenia.roda);

        //ubah nilai
        Mobil2.mesin=9;
        System.out.println("Mesin Avanza  : "+Mobil2.mesin);
        System.out.println("Mesin Xenia   : "+Mobil2.mesin);
        System.out.println("Mesin Avanza  : "+Mobil2.mesin);
        System.out.println("Mesin Xenia   : "+Mobil2.mesin);
        
        Mobil2.matikankanMobil("Avanza Silver");
    }
}