package cn.zciel.class02;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YINZHEN
 * @date 2019/7/2 18:15
 * @Description 拷贝带有随机指针的链表
 */
public class Code_13_CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

}
