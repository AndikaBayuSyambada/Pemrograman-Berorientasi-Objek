public class KaryawanTetap extends Karyawan {
    double gajiPokok;

    KaryawanTetap(double gaji) {
        this.gajiPokok = gaji;
    }

    void hitungTotalGaji() {
        double total = gajiPokok + tunjanganAnak;
        System.out.println("Total Gaji Karyawan Tetap: " + total);
    }
}