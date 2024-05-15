import java.util.HashMap;

class Node{
    int data;
    Node next , random;
    Node(int x){
        data = x;
        next = null;
        random = null;
    }
}
public class CloneLLWithRandom {
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
        
        printlist(head);
        Node clone_list = cloneLL(head);
        printlist(clone_list);
    }
    static Node cloneLL(Node head){
        HashMap<Node,Node>hm  = new HashMap<>();

        for(Node curr = head ; curr != null ; curr = curr.next)
           hm.put(curr, new Node(curr.data));

        for(Node curr = head ; curr!=null ; curr = curr.next){
            Node cloneNode = hm.get(curr);
            cloneNode.next = hm.get(curr.next);
            cloneNode.random = hm.get(curr.random);
        }   
        Node head2 = hm.get(head);
        return head2;
    }
    static void printlist(Node head){
        Node curr=head;
        while (curr != null) {
            System.out.println(curr.data + " "+curr.random.data);
            curr = curr.next;
        }
        System.out.println();
    }
}
