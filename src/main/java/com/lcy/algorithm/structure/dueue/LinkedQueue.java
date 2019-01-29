package com.lcy.algorithm.structure.dueue;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：链表队列
 * @version:
 */
public class LinkedQueue<E> implements Queue<E> {
    private QueueNode header = new QueueNode(null,null);

    @Override
    public void enQuede(E data) {

    }

    @Override
    public E deQueue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    /**
     * 队列的node节点
     * @param <E>
     */
    public static class QueueNode<E>{
        private E data;
        private QueueNode<E> next;

        public QueueNode(E data, QueueNode<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public QueueNode<E> getNext() {
            return next;
        }

        public void setNext(QueueNode<E> next) {
            this.next = next;
        }
    }
}
