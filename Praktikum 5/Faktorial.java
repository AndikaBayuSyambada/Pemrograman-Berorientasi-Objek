import java.util.Scanner;
public class Faktorial {
    int bil, i;
    long fak=1;
    Scanner input = new Scanner(System.in);

    public Faktorial(){}
    
    public Faktorial(int bil){
        this.bil=bil;
    }

    void inputBil(){
        System.out.print("Bil: ");bil=input.nextInt();
    }

    void cetak(){
        for(i=1; i<=bil; i++){
            System.out.print(fak+" x " +i+ " = ");fak=fak*i;
            System.out.println(fak);
        }
    }
}
