public class TesMobil {
    public static void main(String[] args) {
        Mobil avanza = new Mobil();

        Mobil.maju();
        avanza.mundur();
        avanza.belok();

        System.out.println("Roda: " + avanza.roda);
        System.out.println("Mesin: " + Mobil.mesin);
    }
}