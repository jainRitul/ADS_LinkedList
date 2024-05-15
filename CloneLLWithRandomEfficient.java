class Node{
    Node next,random;
    int data ;
    Node(int x){
        data = x;
        next = random = null;
    }
}
public class CloneLLWithRandomEfficient {
   public static void main(String[] args) {
    Node head = new Node(10); 
    head.next = new Node(5); 
    head.next.next = new Node(20); 
    head.next.next.next = new Node(15); 
    head.next.next.next.next = new Node(20); 

    head.random = head.next.next;
    head.next.random=head.next.next.next;
    head.next.next.random=head;
    head.next.next.next.random=head.next.next;
    head.next.next.next.next.random=head.next.next.next;
    printList(head);
    Node clone_list = cloneLL(head);
    printList(clone_list);
   }
   static Node cloneLL(Node head)
   {
      for(Node curr = head;curr!= null;curr= curr.next.next)
      {
          Node next = curr.next;
          curr.next = new Node(curr.data);
          curr.next.next = next;
      }
      
      for(Node curr = head;curr!=null;curr=curr.next.next)
        curr.next.random = (curr.random != null) ? curr.random.next : null;
      
   
     Node curr = head;
     Node head2 = curr.next;
     Node curr2 = head2;
     while(curr != null && curr2 != null){
        curr.next = (curr.next != null) ? curr.next.next : curr.next;
        curr2.next = (curr2.next != null) ? curr2.next.next : curr2.next;
        curr = curr.next;
        curr2 = curr2.next;
     }
     return head2;
      
   }
   static void printList(Node head){
    Node curr = head ;
    while(curr != null){
        System.out.println(curr.data + " " + curr.random.data);
        curr  = curr.next;
    }
    System.out.println();
   }
}
