package com.lcy.leetcode.list;

import com.google.common.base.Objects;

/**
 * Created by：luo
 * date: 2020/4/1.
 * desc：链表接口定义
 */
public interface ListInter<T> {

    void addFirst(T t);

    void addLast(T t);

    Node deleteByNode(Node node);

    Node<T> deleteFirst();

    Node<T> findByValue(T t);

    Node<T> deleteByValue(T t);

    class Node<T>{
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equal(data, node.data);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(data);
        }
    }
}
