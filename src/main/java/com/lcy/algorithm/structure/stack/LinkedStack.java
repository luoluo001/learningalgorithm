package com.lcy.algorithm.structure.stack;

import com.lcy.algorithm.structure.linetable.ArrayList;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：链式栈，用正常的链表即可  每个链表的插入都是在头结点 这样出栈其实也在头结点
 * @version:
 */
public class LinkedStack<E> implements Stack<E> {
    /**
     * 给一个头结点
     */
    private Node<E> header = new Node<>(null,null);
    /**
     * 这里的
     * @param data
     */
    @Override
    public void push(E data) {
        Node<E> newNode = new Node<>(header.getNext(), data);
        header.setNext(newNode);
    }

    @Override
    public E pop() {
        Node<E> realHeader = header.getNext();
        if(realHeader==null){
            throw new RuntimeException("已无元素");
        }
        header.next = realHeader.getNext();
        return realHeader.getData();
    }

    @Override
    public boolean isEmpty() {
        return header.next==null;
    }

    public static class Node<E>{
        Node<E> next;
        E data;

        public Node(Node<E> next, E data) {
            this.next = next;
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
    }
}
