class Node{
    int data ;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}
public class LengthOfLoop {
        public static void main(String[] args) {
            Node head = new Node(10);
            head.next = new Node(15);
            head.next.next = new Node(12);
            head.next.next.next = new Node(20);
            head.next.next.next.next = head.next.next;
            int ans = lengthOfLoop(head);
            System.out.println(ans);
          
    
        }
        static int lengthOfLoop(Node head){
            Node slow = head,fast =head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow)
                {
                    break;
                }
            }
           if(fast == null || fast.next == null )return 0;
            int count = 1;
            Node temp = fast.next;
            while(fast != temp){
                count++;
                temp = temp.next;
            }
            return count;
        }
    
    }

