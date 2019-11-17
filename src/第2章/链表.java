package 第2章;

import java.util.Scanner;

public class 链表 {

    private static Scanner sc = new Scanner(System.in);

    static class Node{
        int data;
        Node next;
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = null, p, q = null;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            p = new Node(sc.nextInt(), null);
            if (head == null){
                head = p;
            } else {
                q.next = p;
            }
            q = p;
        }

        int x = sc.nextInt();
        p = head;
        while (p.data < x){
            q = p;
            p = p.next;
        }
        q.next = new Node(x, p);

        for (Node h = head; h != null; h = h.next)
            System.out.print(h.data + " ");
    }
}
