package com.lcy.algorithm.structure.dueue;

import java.util.Arrays;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：顺序存储的队列
 * @version:
 */
public class ArrayQueue<E> implements Queue<E> {

    public ArrayQueue(Integer cap){
        this.cap = cap;
        array = new Object[cap];
        front = 0;
        rear=0;
    }

    public ArrayQueue(){
        array = new Object[5];
        cap = 5;
        front = 0;
        rear=0;
    }
    private Object[] array;
    /**
     * 大小
     */
    private Integer cap;
    /**
     * 头指针
     */
    private Integer front ;
    /**
     * 尾指针
     */
    private Integer rear;

    @Override
    public void enQuede(E data) {
        //判断如果队列已满则需要防止被操作
        if((rear+1%cap)==front){
            throw  new OperationException("队列已满");
        }
        array[rear] = data;
        rear = (rear+1)%cap;
    }

    @Override
    public E deQueue() {
        if(rear==front){
            throw new OperationException("队列不存在元素");
        }
        Object data = array[front];
        array[front] = null;
        front = (front+1)%cap;
        return (E) data;
    }

    @Override
    public boolean isEmpty() {
        return rear==front;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
