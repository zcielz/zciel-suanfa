package cn.zciel.class03;

/**
 * @author YINZHEN
 * @date 2019/7/3 10:29
 * @Description 求两单向链表交点
 * 　　０．判断两链表是否有环（分别找环入口结点，能找到则有环，否则无环）：
 * <p>
 * 　　　　若都无环，转入第１步（可能是情况1或2）；
 * <p>
 * 　　　　若都有环，转入第２步（可能是情况4或5或6）；
 * <p>
 * 　　　　若一个有环一个无环，直接返回NULL，因为如果他们相交，是不可能一个有环一个无环的（图中情况3）；
 * <p>
 * 　　１．都无环的情况，退化到两个无环链表找入口点的问题（可参见＜剑指offer＞和leetcode:Intersection of Two Linked Lists）
 * <p>
 * 　　　　1.0 先判断两条链表的长度；
 * <p>
 * 　　　　1.1 从头节点开始走，更长的链表先走＂长度之差＂步，然后一起走，如果相遇，则为入口点（情况2）；否则无交点（情况1）
 * <p>
 * 　　２．都有环的情况，这种情况还要细分:
 * <p>
 * 　　　　2.0 先判断两链表环入口点是否相同，若相同，则为情况4，转入步骤2.1；若不同，则为情况5或6，转入2.2；
 * <p>
 * 　　　　2.1 如果为上图中情况4，我们可以把两链表交点作为＂假想的尾部节点＂，然后就退化成两个无环链表找交点的问题了；
 * <p>
 * 　　　　2.2 为判断两链表是否有交点，我们可以从第一个环的入口节点的下一个节点开始next，如果遇到了第二个链表环的入口节点，
 * 则返回第一个链表的入口节点（情况5：题目说找出第一个相交的节点，其实我觉得返回第二个链表的入口节点也行）；
 * 反之，若走了一圈没遇到第二个链表环的入口节点，说明两链表不相交（情况6）；
 * <p>
 * ref : https://cloud.tencent.com/developer/article/1359658
 */
public class Code_14_FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }

        return null;
    }

    /**
     * 无环
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node noLoop(Node head1, Node head2) {

        return null;
    }

    /**
     * 获取环的节点
     *
     * @param head
     * @return 如果有环, 返回那个节点, 如果没有就返回null
     */
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; //n1 -> slow
        Node n2 = head.next.next; //n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;  // n2 -> walk again from head
        while (n1 != n2) {  //寻找相交点节点
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


}
