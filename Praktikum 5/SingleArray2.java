import java.util.Scanner;

public class SingleArray2{
    int j;
    int[] nilai;
    Scanner in = new Scanner(System.in);
    public SingleArray2(){}
    public SingleArray2(int j){
        this.j = j;
        this.nilai = new int[j];
    }

    void inputData(){
        System.out.print(" Jumlah Data : ");
        j=in.nextInt();
        nilai = new int[j];

        //input
        for(int i =0;i<j;i++){
            System.out.print("Data ke - "+(i+1) + " = ");
            nilai[i]=in.nextInt();
        }

        
    }

    void cetak(){
        //cetak
        for(int i=0; i<j ; i++){
            System.out.println("Hasil Nilai [" + i + "] = " + nilai[i]);
        }
    }
}