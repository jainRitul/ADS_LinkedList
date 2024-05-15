class Node{
    int data ;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}
class DetectAndRemoveLoppInLL{
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(12);
        head.next.next.next = new Node(20);
        head.next.next.next.next = head.next;
        detectAndRemoveLoop(head);
        printlist(head);

    }
    static void printlist(Node head){
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr  = curr.next;
        }
    }
    static void detectAndRemoveLoop(Node head){
        Node slow = head,fast =head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
            {
                break;
            }
        }
        if(fast != slow){
            return;
        }
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

}