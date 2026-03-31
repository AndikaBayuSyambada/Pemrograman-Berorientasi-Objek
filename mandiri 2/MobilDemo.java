class Mobil{
    String warna;
    int tahunProduksi;
}

public class MobilDemo{
    public static void main(String[] args) {
        //membuat object
        Mobil mobilku = new Mobil();

        // memnggil atribut dan memberi nilai
        mobilku.warna ="Hitam";
        mobilku.tahunProduksi = 2006;
        
        System.out.println("Warna: " +mobilku.warna);
        System.out.println("Tahun: " +mobilku.tahunProduksi);
    }
}