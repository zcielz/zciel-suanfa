package cn.zciel.class02;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author YINZHEN
 * @date 2019/7/1 12:12
 * @Description 队列实现栈栈实现队列
 */
public class Code_03_StackAndQueueConvert {

    //两个栈生成队列
    public static class TwoStacksQueue {

        private Stack<Integer> stackPush;

        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(Integer num) {
            if (num == null) {
                throw new RuntimeException("num is empty");
            }
            stackPush.push(num);
        }

        public Integer peck() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }

        public Integer pop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }
    }

    //队列生成栈
    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(Integer num) {
            if (num == null) {
                throw new RuntimeException("num is empty");
            }
            queue.add(num);
        }

        public Integer peek() {
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swapQueue();
            return res;
        }

        public Integer pop() {
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swapQueue();
            return res;
        }

        public void swapQueue() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }

    }

    public static void main(String[] args) {
        TwoQueuesStack twoStacksQueue = new TwoQueuesStack();
        twoStacksQueue.push(1);
        twoStacksQueue.push(2);
        twoStacksQueue.push(3);
        twoStacksQueue.push(4);
        twoStacksQueue.push(5);
        twoStacksQueue.push(6);
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.pop());
        System.out.println(twoStacksQueue.pop());
        System.out.println(twoStacksQueue.pop());

    }

}
