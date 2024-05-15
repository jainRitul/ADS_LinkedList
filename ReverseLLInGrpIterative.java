class Node{
    int data;
    Node next ;
    Node(int x){
        data = x;
        next = null;
    }
}
public class ReverseLLInGrpIterative {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head =  reverseInGrp(head,3);
        printlist(head);
    }
    static void printlist(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static Node reverseInGrp(Node head,int k){
       Node prevFirst = null;
       boolean isFirstPass = true;
       Node curr = head;
       while (curr!=null) {
          Node prev = null;
          Node first = curr;
          int count = 0;
          while (curr != null && count < k) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
          }
          if(isFirstPass) {head = prev; isFirstPass = false;}
          else {prevFirst.next = prev;}
          prevFirst = first;
       }
       return head;
    }

}
