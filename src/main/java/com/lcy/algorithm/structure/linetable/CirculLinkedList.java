package com.lcy.algorithm.structure.linetable;

import java.util.LinkedList;

/**
 * Created by： luochengyue
 * date: 2018/11/22.
 * desc：循环节点 没有带大小记录的
 * @version:
 */
public class CirculLinkedList<E> {
   //头结点
    private Node<E> header = new Node<E>();
    //尾指针
    private Node<E> trailPointer = null;
    public void add(E a) {
        Node newNode = new Node(header.getNext(), a);
        header.next = newNode;
        //需要尾指针指向对应的最后一个结点
        if(trailPointer==null){
            trailPointer =newNode;
            trailPointer.setNext(header);//指向头结点
        }
    }

    /**
     * 添加到尾节点
     * @param data
     */
    public void addTrail(E data){
        //通过这种形式增加到尾节点有好处就是存在O(1)即可添加到尾节点
        if(trailPointer==null){
            //说明整个都是空的
            trailPointer = new Node<E>(header,data);
        }else{
            Node newNode = new Node(trailPointer.getNext(), data);
            trailPointer.setNext(newNode);
            //多一步最后的赋值
            trailPointer = newNode;
        }
    }
    /**
     * 根据索引位置做删除
     * @param loc 所在位置
     * @return
     */
    public E delete(Integer loc) {
        if(trailPointer==null||loc<0){
            //没有元素抛出异常
            throw new IndexOutOfBoundsException(outOfBoundsMsg(loc));
        }
        int j = 0;
        Node current = header.getNext();//获取第一个节点
        Node previous = header; //上一个node
        //遍历获取该索引
        while (current.getNext()!=null&&current.getNext()!=header&&j!=loc){
            //索引本身就是0 每次遍历增加1
            previous = current;
            current = current.getNext();
            j++;
        }
        //索引越界了
        if(j!=loc){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(loc));
        }
        //需要对尾指针做下特殊处理
        handleTrailPointer(current, previous);
        return (E) current.getData();
    }

    /**
     * 处理尾节点
     * @param current
     * @param previous
     */
    private void handleTrailPointer(Node current, Node previous) {
        if(current.equals(trailPointer)){
            trailPointer = null;
            previous.setNext(null);
        }else{
            previous.setNext(current.getNext());
        }
    }


    private String outOfBoundsMsg(int index) {
        return "Index: "+index;
    }
    public E deleteByValue(E value) {
        Node<E> previous = header;
        //判定条件有三 不为空当链表无数据的情况  不为header当链表循环结束的时候 不能与value值相当 否则退出
        while (previous.getNext()!=null&&previous.getNext()!=header&&!previous.getNext().getData().equals(value)){
            previous = previous.getNext();
        }
        if(previous.equals(header)||previous==null){
            return null;
        }
        Node<E> current = previous.getNext();
        handleTrailPointer(current, previous);
        return current.getData();
    }


    public void clear() {
        header.setNext(null);
        trailPointer = null;
    }

    public Integer getLocation(E e) {
        int j =0;
        Node<E> p = header;
        while (p.getNext()!=null&&p.getNext()!=header&&!p.getNext().getData().equals(e)){
            p = p.getNext();
            j++;
        }
        if(p.getNext()==header||p.getNext()==null){
            return -1;
        }
        return j;
    }

    public Boolean isEmply() {
        return header.getNext()==null;
    }

    public Integer getLen() {
        Node<E> temp = header;
        int j =0;
        while (temp.next!=null&&temp.next!=header){
            j++;
        }
        return j;
    }

    /**
     * 基础的只要根据对应的索引去做添加删除即可
     * @return
     */
    public E deleteFirst() {
         return delete(0);
    }

    public E getTrail() {
        return trailPointer==null?trailPointer.getData():null;
    }

    @Override
    public String toString() {
        Node p = header;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (p.next != null&&p.next!=header) {
            p = p.next;
            sb.append(p.getData());
         }
         sb.substring(0,sb.length()-1);
         sb.append("]");
        return sb.toString();
    }

    public static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(){
        }
        public Node(Node<E> next,E data) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CirculLinkedList list = new CirculLinkedList();
        list.add("a");
        list.add("b");
        list.addTrail("c");
        System.out.println(list.toString());
        System.out.println(list.getLocation("d"));
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();
        System.out.println(list);
        list.deleteFirst();
//        LinkedList linkedList = new LinkedList();
//        linkedList.add("a");
//        linkedList.add("b");
//        linkedList.add("c");
//        System.out.println(linkedList);

    }
}
