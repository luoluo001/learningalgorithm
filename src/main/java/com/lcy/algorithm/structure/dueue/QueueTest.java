package com.lcy.algorithm.structure.dueue;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：队列操作测试类
 * @version:
 */
public class QueueTest {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        System.out.println(queue.isEmpty());
        queue.enQuede("a");
        System.out.println(queue.deQueue());
        queue.enQuede("b");
        queue.enQuede("c");
        queue.enQuede("d");
        queue.enQuede("e");
        System.out.println(queue.toString());
        System.out.println(queue.deQueue());
        queue.enQuede("f");
        System.out.println(queue);
    }
}
