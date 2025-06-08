import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Queue Capcity");
        Queue<Integer> queue = new Queue<>(sc.nextInt());
        boolean flag = true;
        System.out.println("***********************");
        System.out.println("  WELCOME TO QUEUE");
        System.out.println("***********************");
         do {
            System.out.println("\n1. Enqueue\t\t2. Dequeue");
            System.out.println("3. Peek\t\t4. isEmpty?");
            System.out.println("5. isFull?\t6. Display");
            System.out.println("\t7.Exit");
            System.out.print("Enter your choice");
            switch (sc.nextInt()) {
                case 1:
                    try {
                        System.out.println("Enter your data");
                        queue.enqueue(sc.nextInt());
                    } catch (QueueOverFlowException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println(queue.dequeue() + " dequeue from Queue");
                    } catch (QueueUnderFlowException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println(queue.peek());
                    } catch (QueueUnderFlowException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(queue.isEmpty() ? "queue is Empty" : "queue is not Empty");
                    break;
                case 5:
                    System.out.println(queue.isFull() ? "queue is Full" : "queue is not Full");
                    break;
                case 6:
                    System.out.println(queue);
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.err.println("Wrong Choice !!");
                    break;
            }

        } while (flag);
        sc.close();
    }
}
