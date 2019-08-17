class Node{
    int val;
    Node next = null;

    Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("Node(%d)",val);
    }
}


public class Practice {
    private static Node fen(Node head,int x){
        Node small = null;
        Node smallLast = null;
        Node big = null;
        Node bigLast = null;
        for(Node cur = head;cur != null;cur = cur.next) {
            if (cur.val < x) {
                if (small == null) {
                    small = cur;
                } else {
                    small.next = cur;
                }
                smallLast = cur;
            }else{
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
        }
        if(smallLast == null){
            return big;
        }else{
            smallLast.next = big;
            if(bigLast != null){
                bigLast.next = null;
            }
        }
        return small;
    }


    private static Node test(){
        Node n1 = new Node(5);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    public static void main(String[] args) {
        Node head = fen(test(),3);

        for(Node cur = head;cur != null;cur = cur.next){
            System.out.println(cur);
        }
    }
}
