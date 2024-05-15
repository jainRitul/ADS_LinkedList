class Node{
    int data ;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}
public class DeleteNodeEvenOnlyPointerIsGiven {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        deleteNode(head.next.next);
        printlist(head);
    }
    static void printlist(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+ " ");
            curr =curr.next;
        }
    }
    static void deleteNode(Node ptr){
     ptr.data = ptr.next.data;
     ptr.next = ptr.next.next;
     return;
    }

}
