package cn.zciel.class02;

import org.omg.Dynamic.Parameter;

import java.util.Stack;

/**
 * @author YINZHEN
 * @date 2019/7/2 15:14
 * @Description 回文链表
 */
public class Code_11_IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //need n extr space
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(head);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //使用快慢指针，找到中位数，使用栈取一半的数进行比较
    //need n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node fastNode = head.next; //结束指向另半边的第一个数
        Node curNode = head;
        while (curNode.next != null && curNode.next.next != null) {
            fastNode = fastNode.next;
            curNode = curNode.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (fastNode.next != null) {
            stack.push(fastNode);
            fastNode = fastNode.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 1. 采用快慢指针来找到链表中点
     * 2. 找到中点之后，采用空间复杂度O(1)的反转链表的算法，将链表反转，需要注意的是，反转过程中语句的顺序，
     * head = head.next一定要在第二句，而不是最后，要不然就断链了，因为p指向了head更改p相当于更改了head,当head指向next之后，才能更改p
     */
    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        //找出中间位置
        //TDOO

        return true;


    }


}
