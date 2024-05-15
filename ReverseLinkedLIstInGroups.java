import java.util.*;
import java.io.*;
import java.lang.*;
class Node {
    int data;
    Node next ;
    Node(int x){
     data = x;
     next = null;
    }
 }
class ReverseLinkedLIstInGroups{
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head.next.next.next.next.next.next.next = new Node(80);
        head.next.next.next.next.next.next.next.next = new Node(90);
        printlist(head);
        // head = reverse(head);
        head = reverseInGroup(head,2);
        printlist(head);

    }
    static Node  reverseInGroup(Node head,int k){
        Node next = null,curr = head,prev = null;
        int count = 0;
        while (curr != null && count < k ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(curr != null){
            Node res_head = reverseInGroup(next, k);
            head.next = res_head;
        } return prev;
    }

    public  static void printlist(Node head){
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data +" ");
            curr = curr.next;
        }System.out.println();

    }
    static Node reverse(Node head){
        Node curr = head;
        Node prev = null,next = null;
        while (curr!=null) {
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
        }return prev;
    }
}

