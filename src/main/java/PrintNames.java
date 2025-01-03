import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrintNames {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Node head = new Node(0, null);
        Node node = head;
        while(true) {
            System.out.println("Please enter a value " );
            int val = scan.nextInt();
            node.next = new Node(val, null);
            node = node.next;

            print(head);
        }
    }

    private static void print(Node node) {
        long sum = 0;
        while(node != null) {
            sum += node.val;
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
        System.out.println("Sum == " + sum);
    }


    static class Node {
        int val;
        Node next;

        public Node(int val, Node node) {
            this.val = val;
            this.next = node;
        }
    }
}
