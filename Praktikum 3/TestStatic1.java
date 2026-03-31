public class TestStatic1 {
    public static void main(String[] args) {

        // Membuat objek dari TestStatic
        TestStatic ts = new TestStatic();

        // Memanggil method
        ts.satu();           // method non-static → lewat objek
        TestStatic.dua();    // method static → lewat class
    }
}