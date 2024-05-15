class Node{
    int data ;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}
public class PairwiseSwapNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(19);
        head.next.next = new Node(9);
        head.next.next.next = new Node(13);
        head.next.next.next.next = new Node(15);
        // pairwiseSwap(head);
        head =  pairwiseSwapEfficient(head);
        printlist(head);
    }
    static Node pairwiseSwapEfficient(Node head){
        if(head == null || head.next == null) return head;
       Node prev = head;
       Node curr = head.next.next;
       head = head.next;
       head.next = prev;
       while (curr != null && curr.next != null) {
          prev.next = curr.next;
          prev = curr;
          Node next= curr.next.next;
          curr.next.next = curr;
          curr = next;
       }
       prev.next = curr;
       return head;
    }
    static void pairwiseSwap(Node head){
       
        Node curr = head;
       
        while(curr!= null && curr.next!=null){
           
           int temp = curr.data;
           curr.data = curr.next.data;
           curr.next.data= temp;

           curr = curr.next.next;
        }
       
    }
    static void printlist(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

}

