package cn.zciel.class03;

import java.util.Stack;

/**
 * @author YINZHEN
 * @date 2019/7/1 11:33
 * @Description 实现一个特殊的栈，在实现栈的基础上，再实现返回栈中最小的元素的操作。
 * <p>
 * 那么只需要引入多一个栈（minElementStack），在push时，在minElementStack的栈顶里面保存比当前最小值还小的元素就可以了，而minElementStack的栈顶始终保持当前栈中最小的元素。
 * 在pop时，当pop掉栈的最小值元素，只需同时pop掉minElementStack中的元素就好了。
 */
public class Code_02_GetMinStack {

    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public void push(Integer num) {
            if (stackMin.isEmpty()) {
                stackMin.push(num);
            } else if (num < getMin()) {
                stackMin.push(num);
            }
            stackData.push(num);
        }

        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new IndexOutOfBoundsException("this stack is out of boun");
            } else {
                if (stackData.peek() == getMin()) {
                    stackMin.pop();
                }
            }
            return stackData.pop();
        }

        public Integer getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("this stackMin is empty");
            }
            return this.stackMin.peek();
        }
    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public void push(Integer num) {
            if (stackMin.isEmpty()) {
                stackMin.push(num);
            } else if (num < getMin()) {
                stackMin.push(num);
            } else {
                stackMin.push(getMin());
            }
            stackData.push(num);

        }

        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new IndexOutOfBoundsException("pop is outof bounds exception");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public Integer getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("this stackMin is empty");
            }
            return this.stackMin.peek();
        }

    }

}
