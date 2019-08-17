class Node2{
    int val;
    Node2 next = null;

    Node2(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("Node(%d)",val);
    }
}
public class Practice2 {
    public static Node2 deleteDuplication(Node2 head){
        if(head == null){
            return null;
        }

        Node2 fake = new Node2(0);
        fake.next = head;
        Node2 p1 = head;
        Node2 prev = fake;
        Node2 p2 = head.next;

        while(p2 != null){
            if(p1.val != p2.val){
                prev = p1;
                p1 = p1.next;
                p2 = p2.next;
            }else{
                while(p2 != null && p2.val == p1.val){
                    p2 = p1.next;
                }

                prev.next = p2;
                p1 = p2;
                if(p2 != null) {
                    p2 = p2.next;
                }
            }
        }
        return fake.next;
    }

    public static Node2 test(){
        Node2 n1= new Node2(2);
        Node2 n2= new Node2(2);
        Node2 n3= new Node2(3);
        Node2 n4= new Node2(4);
        Node2 n5= new Node2(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    public static void main(String[] args) {
        Node2 head = test();
        for(Node2 cur = deleteDuplication(test());cur != null;cur = cur.next){
            System.out.println(cur);
        }
    }
}
