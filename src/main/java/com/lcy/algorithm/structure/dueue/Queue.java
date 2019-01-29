package com.lcy.algorithm.structure.dueue;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：队列只有在一端输入，一端删除
 * @version:
 */
public interface Queue<E> {
    /**
     * 入队
     * @param data
     */
    void enQuede(E data);

    /**
     * 出队
     * @return
     */
    E deQueue();

    boolean isEmpty();
}
