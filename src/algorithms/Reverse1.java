package algorithms;

/**
 * Created by Bill on 2016/11/18.
 * Email androidBaoCP@163.com
 */
public class Reverse1 {
    public static void main(String... args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Node h = head;
        while (h != null) {
            System.out.println(h.getData() + " ");
            h = h.getNext();
        }
//        head = reverse(head);
//        System.out.println("=========================");
//        while (head!=null){
//            System.out.println(head.getData()+" ");
//            head=head.getNext();
//        }

        head = reverse2(head);
        System.out.println("=========================");
        while (head != null) {
            System.out.println(head.getData() + " ");
            head = head.getNext();
        }
    }

    /**
     * 单链表反转的递归实现
     */
    public static Node reverse(Node head) {
        //将head看做前一节点，head.getNext()为当前节点，reHead为反转后的头结点
        if (head == null || head.getNext() == null) {
            return head;
        }
        // 先反转后续节点
        Node reHead = reverse(head.getNext());
        // 当前节点的指针指向前一节点
        head.getNext().setNext(head);
        // 前一节点的后续节点指向null
        head.setNext(null);
        // 反转后新链表的头结点
        return reHead;
    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse2(Node head) {
        if (head == null || head.getNext() == null)
            return head;
        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向
            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);
        return pre;
    }
}

