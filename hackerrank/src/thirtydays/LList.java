package thirtydays;

import java.util.Scanner;

/**
 * @author ashevenkov 04.04.17 19:25.
 */
public class LList {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node insert(Node head, int data) {
        Node pointer = head;
        Node newNode = new Node(data);
        if(pointer == null) {
            return newNode;
        }
        while(pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = newNode;
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
