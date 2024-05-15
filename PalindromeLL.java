import java.util.ArrayDeque;
import java.util.Deque;

class Node{
    char data;
    Node next;
    Node(char c){
        data = c;
        next = null;
    }
}
public class PalindromeLL {
    public static void main(String[] args) {
        Node head = new Node('A');
        head.next = new Node('D');
        head.next.next = new Node('A');
        // head.next.next.next = new Node('A');
        // head.next.next.next.next = new Node('R');

        System.out.println(checkPali(head));
        System.out.println(checkPaliEfficient(head));
    }
    static Node reverseList(Node head){
        Node prev = null,curr = head;
        while (curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static boolean checkPaliEfficient(Node head){
       if(head == null )return true;
       Node slow = head,fast = head;

       while (fast.next != null && fast.next.next != null) {
         slow = slow.next;
         fast = fast.next.next;
       }
       Node curr = head;
       Node rev = reverseList(slow.next);
       while (rev != null) {
          if(rev.data != curr.data){
            return false;
          }rev = rev.next;
          curr = curr.next;
       }
       return true;
          
    }
    static boolean checkPali(Node head){
       Deque<Character>d = new ArrayDeque<>();
       for(Node curr = head ; curr != null;curr=curr.next)
          d.push(curr.data);
       
          
       for(Node curr = head;curr!=null;curr= curr.next)
        if(d.pop()!=curr.data) return false;
       
       return  true;
       
    }
}
