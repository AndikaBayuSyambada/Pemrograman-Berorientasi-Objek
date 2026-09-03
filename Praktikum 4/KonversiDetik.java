import java.util.Scanner;
public class KonversiDetik {
    public static void main(String[] args) {
        Scanner imput= new Scanner(System.in);
        String jawab;
        do { 
            System.out.print("Masukkan Jumlah Detik: " );
            int totalDetik=imput.nextInt();
            int detikAsli = totalDetik;

            int hari = totalDetik/86400;
            totalDetik %= 86400;
            int jam = totalDetik/3600;
            totalDetik %= 3600;
            int menit = totalDetik/60;
            int detik = totalDetik % 60;

            System.out.println("\nHasil Konversi: ");
            System.out.println("Detik: " +detikAsli);
            System.out.println("Hari: " +hari);
            System.out.println("Jam: " +jam);
            System.out.println("Menit: " +menit);
            System.out.println("Detik: " + detik);

            System.out.println("Imput data lagi [Y/T]? ");
            imput.nextLine();
            jawab = imput.nextLine();
        } while (jawab.equalsIgnoreCase("Y"));
        System.err.println("Terima Kasih");
    }
}
