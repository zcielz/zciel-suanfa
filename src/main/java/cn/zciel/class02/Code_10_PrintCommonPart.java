package cn.zciel.class02;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YINZHEN
 * @date 2019/7/2 14:52
 * @Description 打印两个有序列表的公共部分
 * 如果head1的值小于head2,则head1往下移动。
 * 如果head2的值小于head1,则head2往下移动。
 * 如果head1的值与head2的值相等，则打印这个值，然后head1与head2都往下移动
 * head1或head2有任何一个移动到null，整个过程停止
 */
public class Code_10_PrintCommonPart {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printCommonPart(Node head1, Node head2) {
        System.out.println("common part:");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void printLinkedList(Node node) {
        System.out.println("Linked List :");
        while (node != null) {
            System.out.println(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1_1 = new Node(1);
        Node node1_2 = new Node(2);
        Node node1_3 = new Node(3);
        Node node1_4 = new Node(4);
        Node node1_5 = new Node(5);
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;
        node1_4.next = node1_5;
        printLinkedList(node1_1);

        Node node2_2 = new Node(2);
        Node node2_3 = new Node(3);
        Node node2_4 = new Node(4);
        Node node2_5 = new Node(5);
        Node node2_6 = new Node(6);
        node2_2.next = node2_3;
        node2_3.next = node2_4;
        node2_4.next = node2_5;
        node2_5.next = node2_6;
        printLinkedList(node2_2);

        printCommonPart(node1_1, node2_2);


    }

}
