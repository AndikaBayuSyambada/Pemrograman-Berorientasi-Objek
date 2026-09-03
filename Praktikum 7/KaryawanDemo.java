public class KaryawanDemo {
    public static void main(String[] args) {
        KaryawanTetap tetap = new KaryawanTetap(5000000);
        
        tetap.hitungTotalGaji();

        KaryawanKontrak kontrak = new KaryawanKontrak(150000, 20);
        
        kontrak.hitungTotalUpah();
    }
}