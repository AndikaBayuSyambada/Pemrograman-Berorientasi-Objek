public class Mobil2BMWDemo {
    public static void main(String[] args) {
        Mobil2BMW bmw = new Mobil2BMW();
        
        bmw.hidupkanMobil(); // Memanggil method dari parent
        bmw.nontonTV();      // Memanggil method sendiri
        bmw.ubahGigi(2);     // Memanggil method dari parent
        bmw.matikanMobil();  // Memanggil method dari parent
    }
}