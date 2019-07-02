package cn.zciel.class02;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YINZHEN
 * @date 2019/7/1 10:23
 * @Description 用数组结构实现大小固定的队列和栈
 * ref https://blog.csdn.net/as1072966956/article/details/82941346
 */
public class Code_01_Array_To_Stack_Queue {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push(int num) {
            if (arr.length == size) {
                throw new ArrayIndexOutOfBoundsException("The arr can't push num");
            }
            arr[size++] = num;
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The arr can't pop num");
            }
            return arr[--size];
        }

    }

    public static class ArrayQueue {
        private Integer[] arr;

        private int size;

        private int startIndex;

        private int endIndex;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            startIndex = 0;
            endIndex = 0;
        }

        public Integer peck() {
            if (size == 0) {
                return null;
            }
            return arr[startIndex];
        }

        public void push(int num) {
            if (size == arr.length) {
                throw new IndexOutOfBoundsException("can't push num");
            }
            size++;
            arr[endIndex] = num;
            endIndex = endIndex == arr.length - 1 ? 0 : ++endIndex;
            System.out.println("endIndex:" + endIndex);

        }

        public Integer pop() {
            if (size == 0) {
                throw new IndexOutOfBoundsException("can't pop num");
            }
            size--;
            int tmp = startIndex;
            startIndex = startIndex == arr.length - 1 ? 0 : ++startIndex;
            System.out.println("startIndex" + startIndex);
            return arr[tmp];
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayStack = new ArrayQueue(4);
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());


    }


}
