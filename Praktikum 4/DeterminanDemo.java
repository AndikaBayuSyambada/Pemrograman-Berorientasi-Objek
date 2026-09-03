import java.util.Scanner;
public class DeterminanDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String jawab;
        Determinan abc=new Determinan(1f, 2f, 1f);
        abc.cetakDeterminan();
        do{
            Determinan d=new Determinan();
            d.inputABC();
            d.cetakDeterminan();
            System.out.println("\n Input data lagi [Y/T]? ");

            jawab = input.nextLine();
        }while (jawab.equalsIgnoreCase("Y"));
    }
}
