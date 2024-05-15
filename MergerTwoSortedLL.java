class Node{
    int data;
    Node next;
    Node(int x){
        next = null;
        data = x;
    }
}
public class MergerTwoSortedLL {
    public static void main(String[] args) {
        Node head  = new Node(10);
        head.next  = new Node(20);
        head.next.next  = new Node(30);
        Node head1 = new Node(5);
        head1.next = new Node(25);
       ;
        printlist(merge(head,head1));
    }
    static void printlist(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    static Node merge(Node a,Node b){
        if(a == null) return b ;
        if(b== null) return a;
        Node head = null , tail = null;
       
        if(a.data <= b.data) {
            head =tail= a ;
            a=a.next;
        }
        else{
            head = tail = b;
            b=b.next;
        }
 
       while(a != null && b!= null){
          
          if(a.data <= b.data)
          {
            tail.next = a;
            a = a.next;
            tail = a;
          }
          else
          {
            tail.next = b;
            tail = b;
            b = b.next;
          }
       }
       if(a==null) {
        tail.next = b;
       }
       else{
        tail.next = a;
       }
        return head;
    }
}
