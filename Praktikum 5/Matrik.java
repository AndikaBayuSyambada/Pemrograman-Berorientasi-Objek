import java.util.Scanner;

public class Matrik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input Matriks A
        System.out.print("Input baris matriks A: "); int rA = input.nextInt();
        System.out.print("Input kolom matriks A: "); int cA = input.nextInt();
        int[][] A = new int[rA][cA];
        for(int i=0; i<rA; i++) {
            for(int j=0; j<cA; j++) {
                System.out.print("Input elemen matriks A ["+i+","+j+"] = ");
                A[i][j] = input.nextInt();
            }
        }

        // Input Matriks B
        System.out.print("Input baris matriks B: "); int rB = input.nextInt();
        System.out.print("Input kolom matriks B: "); int cB = input.nextInt();
        int[][] B = new int[rB][cB];
        for(int i=0; i<rB; i++) {
            for(int j=0; j<cB; j++) {
                System.out.print("Input elemen matriks B ["+i+","+j+"] = ");
                B[i][j] = input.nextInt();
            }
        }

        // 1. Penjumlahan (C = A + B)
        int[][] C = new int[rA][cA];
        System.out.println("Hasil penjumlahan matrik A");
        for(int i=0; i<rA; i++) {
            for(int j=0; j<cA; j++) {
                C[i][j] = A[i][j] + B[i][j];
                System.out.print(C[i][j] + "\t");
            }
            System.out.println();
        }

        // 2. Transpose dari C (Hasil penjumlahan tadi)
        System.out.println("\nHasil transfos matrik C=");
        int[][] transC = new int[cA][rA];
        for(int i=0; i<rA; i++) {
            for(int j=0; j<cA; j++) {
                transC[j][i] = C[i][j];
            }
        }
        // Cetak Transpose
        for(int i=0; i<cA; i++) {
            for(int j=0; j<rA; j++) {
                System.out.print(transC[i][j] + "\t");
            }
            System.out.println();
        }

        // 3. Perkalian A x B
        System.out.println("\nHasil perkalian matrix A dengan matrix B =");
        int[][] D = new int[rA][cB];
        for(int i=0; i<rA; i++) {
            for(int j=0; j<cB; j++) {
                D[i][j] = 0;
                for(int k=0; k<cA; k++) {
                    D[i][j] += A[i][k] * B[k][j];
                }
                System.out.print(D[i][j] + "\t");
            }
            System.out.println();
        }
    }
}