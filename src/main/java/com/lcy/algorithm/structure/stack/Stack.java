package com.lcy.algorithm.structure.stack;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：栈的数据结构：特点后进先出，所以都只能在头部做操作
 * @version:
 */
public interface Stack<E> {
    /**
     * 压入
     */
    void push(E data);

    /**
     * 弹出
     * @return
     */
    E pop();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();


}
