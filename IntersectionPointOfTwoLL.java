import java.util.HashSet;

class Node{
    int data ;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}
public class IntersectionPointOfTwoLL {
    public static void main(String[] args) {
    Node head = new Node(5);
    head.next = new Node(8);
    head.next.next = new Node(7);
    head.next.next.next = new Node(10);
    head.next.next.next.next = new Node(12);
    head.next.next.next.next.next = new Node(15);
    Node head2 = new Node(9);
    head2.next = head;

    int ans = findIntersectionPoint(head,head2);
    int ans1 = findIntersectionPointEfficient(head,head2);
    System.out.println(ans);
    System.out.println(ans1);
    }
    static int findIntersectionPointEfficient(Node h1,Node h2){
        Node curr1 = h1;
        Node curr2 = h2;
        int c1 = 0;
        int c2 = 0;

        while(curr1 != null ){curr1 = curr1.next;c1++;}
        while(curr2!= null ){curr2 = curr2.next;c2++;}

        curr1 = h1;
        curr2 = h2;

        int absDiff = Math.abs(c1-c2);

        if(c1 > c2){
            int count = 0;
            while(count < absDiff){
               curr1 = curr1.next;
               count++;
            }
        }else{
            int count = 0;
            while(count < absDiff){
               curr2 = curr2.next;
               count++;
            }
        }
        while(curr1 != null && curr2 != null){
            if(curr1 == curr2){
                return curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }return -1;

        
    }
    static int findIntersectionPoint(Node h1 , Node h2){
        Node curr = h1;
        Node curr2 = h2;
        HashSet<Integer>s = new HashSet<>();
        while(curr != null){
            s.add(curr.data);
            curr=curr.next;
        }
        while(curr2 !=  null){
            if(s.contains(curr2.data)){
                return curr2.data;
            }
            curr2 = curr2.next;
        }
        return -1;
    }
    
}

