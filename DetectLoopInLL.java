import java.util.HashSet;

class Node{
    int data;
    Node next ;
    boolean visit;
    Node(int x){
        data = x;
        next = null;
        visit = false;
    }
}
public class DetectLoopInLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(12);
        head.next.next.next = new Node(20);
        head.next.next.next.next =  head;
        
        System.out.println(checkLoopWithHashing(head));
        System.out.println(checkLoopWithTwoPointer(head));
        System.out.println(checkLoop(head));
        System.out.println(checkLoopWithModificationInReferenceAndPointer(head));
   
    }
    //two pointer
    static boolean checkLoopWithTwoPointer(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    //with hashing approah
    static boolean checkLoopWithHashing(Node head){
        HashSet<Node>s = new HashSet<>();

        for(Node curr = head ; curr != null ; curr = curr.next){
            if(s.contains(curr)) return true;
            s.add(curr);
        }
        return false;
    }
    //with modification in reference
    static boolean checkLoopWithModificationInReferenceAndPointer(Node head){
        Node temp = new Node(0);
        Node curr = head;

        while (curr != null) {
            if(curr.next == null) return false;

            if(curr.next == temp) return true;
            Node currNext = curr.next;
          
            curr.next = temp;
            curr = currNext;
        }
        return false;
    }

    //maintaing one more field in original array

    static boolean checkLoop(Node head){
        if(head == null ) return false;
        Node curr = head;
        while (curr != null) {
            if(curr.visit == true ){
                return true;
            }
            curr.visit = true;
            curr = curr.next;
        }return false;
    }
}
