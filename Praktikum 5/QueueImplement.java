import java.util.Scanner;

public class QueueImplement {
    // Kapasitas 5 sesuai contoh
    private int[] queue = new int[5];
    private int maxSize = 5;
    private int front = 0;
    private int rear = -1;
    private int nItems = 0;

    public static void main(String[] args) {
        QueueImplement q = new QueueImplement();
        Scanner sc = new Scanner(System.in);
        String lanjut;

        do {
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size");
            System.out.print("Your Choice ? ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (q.nItems == q.maxSize) System.out.println("Queue Full!");
                    else {
                        System.out.print("Insert value: ");
                        q.rear = (q.rear + 1) % q.maxSize;
                        q.queue[q.rear] = sc.nextInt();
                        q.nItems++;
                    }
                    break;
                case 2:
                    if (q.nItems == 0) System.out.println("Queue Empty!");
                    else {
                        int removed = q.queue[q.front];
                        q.front = (q.front + 1) % q.maxSize;
                        q.nItems--;
                        System.out.println("Removed: " + removed);
                    }
                    break;
                case 3:
                    if (q.nItems > 0) System.out.println("Peek: " + q.queue[q.front]);
                    else System.out.println("Queue Empty!");
                    break;
                case 4:
                    System.out.println(q.nItems == 0 ? "Queue is Empty" : "Queue is not Empty");
                    break;
                case 5:
                    System.out.println(q.nItems == q.maxSize ? "Queue is Full" : "Queue is not Full");
                    break;
                case 6:
                    // Format output disesuaikan dengan gambar
                    System.out.println("Size = " + q.nItems);
                    System.out.print("Queue = ");
                    for (int i = 0; i < q.nItems; i++) {
                        System.out.print(q.queue[(q.front + i) % q.maxSize] + " ");
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

            System.out.print("\nDo you want to continue (Type y or n) ");
            lanjut = sc.next();
        } while (lanjut.equalsIgnoreCase("y"));
    }
}