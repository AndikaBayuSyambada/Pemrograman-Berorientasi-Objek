public class KaryawanKontrak extends Karyawan {
    double upahHarian;
    int jumlahHariMasuk;

    KaryawanKontrak(double upah, int hari) {
        this.upahHarian = upah;
        this.jumlahHariMasuk = hari;
    }

    void hitungTotalUpah() {
        double total = (upahHarian * jumlahHariMasuk) + tunjanganAnak;
        System.out.println("Total Upah Karyawan Kontrak: " + total);
    }
}