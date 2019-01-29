package com.lcy.algorithm.structure.linetable;

/**
 * Created by： luochengyue
 * date: 2018/11/19.
 * desc：链表
 * @version:
 */
public class LinkedList<T> implements List<T> {

    private Node<T> firstPoint =new Node<T>(null,null);

    private Integer size = 0;

    /**
     * insertFirst比较合适
     * @param a
     */
    public void add(T a) {
        Node<T> realHeader = firstPoint.getNext();
        Node newEntry = new Node(realHeader, a);
        firstPoint.next = newEntry;
        size++;
    }

    public T delete(Integer loc) {
        //删除的时候需要判定是否索引超过或者等于的情况 多判断个等于
        checkRangeDel(loc);
        Node<T> tem = null;
        tem =  firstPoint.getNext();//因为这里已经获取了 所以i从1开始
        for(int i =0;i<loc;i++){//i为计数器
            tem = tem.getNext();
        }
        Node<T> q = tem;
        tem.setNext(q.getNext());
        size--;
        return q.getData();
    }

    /**
     * 新增用于中环测试 世纪没有这样操作的
     * @param loc
     * @return
     */
    public Node<T> findByLoc(Integer loc) {
        //删除的时候需要判定是否索引超过或者等于的情况 多判断个等于
        checkRangeDel(loc);
        Node<T> tem = null;
        tem =  firstPoint.getNext();//因为这里已经获取了 所以i从1开始
        for(int i =0;i<loc;i++){//i为计数器
            tem = tem.getNext();
        }
        return tem;
    }


    public T deleteFirst() {
      return delete(0);
    }

    private void checkRange(Integer loc) {
        if (loc > size || loc < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(loc));
    }

    private void checkRangeDel(Integer loc) {
        if (loc >= size || loc < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(loc));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public void insert(T e, Integer loc) {
        checkRange(loc);
        Node tem = null;
        int j = 1;
        tem = firstPoint.getNext();
        //获取要插入的元素位置
        while (j<loc){
            tem = tem.getNext();
            j++;
        }
        Node node = new Node(null,e);
        node.setNext(tem.getNext());
        tem.setNext(node);
        size++;

    }

    /**
     * 为了测试中环
     * @param node
     * @param loc
     */
    public void insert(Node node, Integer loc) {
        checkRange(loc);
        Node tem = null;
        int j = 1;
        tem = firstPoint.getNext();
        //获取要插入的元素位置
        while (j<loc){
            tem = tem.getNext();
            j++;
        }
        node.setNext(tem.getNext());
        tem.setNext(node);
        size++;

    }

    public void clear() {
        firstPoint.setNext(null);
        size=0;
    }

    public Integer getLocation(T e) {
        return null;
    }

    public Boolean isEmply() {
        return size==0;
    }

    public Integer getLen() {
        return size;
    }

    public class Node<T>{

        public Node(Node<T> next, T data) {
            this.next = next;
            this.data = data;
        }

        public Node() {
        }

        private Node<T> next;
        private T data;

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> node = firstPoint.getNext();
        while (node!=null){
            sb.append(node.getData()).append(",");
            node = node.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 反转链表 原地反转空间复杂度为1
     */
    public void reverse1(){
        //先决条件是空间 节点不为空
        if(firstPoint.getNext()==null){
            return ;
        }
        Node<T> preCur = firstPoint.getNext();
        Node<T> target = null;
        //循环借宿的条件是对应的要反转的节点为null
        while (preCur.getNext()!=null){
            target = preCur.getNext();
            preCur.setNext(target.getNext());
            target.setNext(firstPoint.getNext());
            firstPoint.setNext(target);
        }

    }


    /**
     * 反转链表之 新创建表头
     */
    public void reverse2(){
        //先决条件是空间 节点不为空
        if(firstPoint.getNext()==null){
            return ;
        }
        Node<T> temHeader = new Node<T>();
        Node<T> cPur = null;
        //循环借宿的条件是对应的要反转的节点为null
        while (firstPoint.getNext()!=null){
            cPur = firstPoint.getNext();
            firstPoint.setNext(cPur.getNext());
            cPur.setNext(temHeader.getNext());
            temHeader.setNext(cPur);
        }
        firstPoint = temHeader;
    }

    /**
     * 快慢指针法
     * @return
     */
    public boolean hasLoopV1(){
        if(size<=0){
            return false;
        }
        //p为慢指针 q为快指针
        Node p = firstPoint.getNext();
        Node q = firstPoint.getNext().getNext();
        while (p.getNext()!=null&&q!=null&&q.getNext()!=null){
            if(p.equals(q)){
                return true;
            }
            p = p.getNext();
            q = q.getNext().getNext();
        }
        return false;
    }

    /**
     * 遍历节点 采用map存储，如果遍历到的map存在 先放着后期找时间写下咯
     * @return
     */
    public boolean hasLoopV2(){
        return false;
    }

    /**
     * 还是用快慢指针的方式
     * 但是这回呢是这样的原理，p 一个个节点走  q 两个个走 如果q==null 说明走完了 这时候p就是刚好走到一半所以这个几点就是中间节点
     * @return
     */
    public Node<T> findMdNode(){
        if(firstPoint.getNext()==null){
            return null;
        }
        //p为慢指针 q为快指针
        Node p = firstPoint.getNext();
        Node q = firstPoint.getNext().getNext();
        while (p.getNext()!=null&&q!=null&&q.getNext()!=null){
            p = p.getNext();
            q = q.getNext().getNext();
        }
        return p;
    }


}
