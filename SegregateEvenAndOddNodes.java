class Node{
    int data ;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}
public class SegregateEvenAndOddNodes {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(19);
        head.next.next = new Node(9);
        head.next.next.next = new Node(13);
        head.next.next.next.next = new Node(15);
        head.next.next.next.next.next = new Node(21);
        head.next.next.next.next.next.next = new Node(41);
        head = segregateEvenAndOdd(head);
        printlist(head);
    }
    static Node segregateEvenAndOdd(Node head){
        Node eS = null,eE = null , oS = null , oE = null;
        for(Node curr = head ; curr  != null ; curr = curr.next){
            int x = curr.data;
            if(x%2==0){
              if(eS == null ){
                eS = curr;
                eE = eS;
              }
              else{
                eE.next = curr;
                eE = eE.next;
              }
            }
            else{
              if(oS == null){
                oS = curr;
                oE = oS;
              }
              else{
                oE.next = curr;
                oE = oE.next;
              }
            }
        }
        if(oS == null || eS == null){
            return head;
        }

        eE.next = oS;
        oE.next = null;
        return eS;
    }
    static void printlist(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
