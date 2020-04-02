package com.lcy.leetcode.list;

/**
 * Created by：luo
 * date: 2020/4/1.
 * desc：
 */
public class LinkedList<T extends Comparable> implements ListInter<T> {
    //哨兵
    private Node<T> head = new Node<>(null,null);
    @Override
    public void addFirst(T t) {
        Node node = new Node(t);
        insert2Head(node);
    }

    private void insert2Head(Node node) {
        insertAfter(head, node);
    }

    @Override
    public void addLast(T t) {
        Node q = head;
        while (q.next!=null){
            q = q.next;
        }
        Node newNode = new Node(t);
        insertAfter(q, newNode);
    }

    private void insertAfter(Node q, Node newNode) {
        if(q==null){
            System.out.println("错误插入");
            return;
        }
        newNode.next = q.next;
        q.next = newNode;
    }

    @Override
    public Node deleteByNode(Node node) {
        Node q = head;
        while (q.next!=null&&!q.next.equals(node)){
            q = q.next;
        }
        //找不到对应的元素
        if(q.next==null){
            return null;
        }
        //哨兵的优点 最后一个元素也无所谓在前面while已经判断了
        Node reNode = q.next;//这句话需要在删除之前 删除操作需要用next来判断这样才能够有较好的删除
        q.next = q.next.next;
        return reNode;
    }

    @Override
    public Node<T> deleteFirst() {
        if (head.next ==null) {
            return null;
        }
        Node returnNode = head.next;
        head.next = head.next.next;
        return returnNode;
    }

    @Override
    public Node<T> findByValue(T t) {
        Node q = head;
        while (q!=null&&!t.equals(q.getData())){
            q = q.next;
        }
        return q;
    }

    @Override
    public Node<T> deleteByValue(T t) {
        Node q = head;
        //多保留一位前节点
        while (q.next!=null&&!t.equals(q.next.getData())){
            q = q.next;
        }
        if(q.next==null){
            return null;
        }
        Node n = q.next;
        q.next = q.next.next;//删除掉
        return n;
    }

    @Override
    public String toString() {
        Node node = head.getNext();
        StringBuilder sb = appNodeData(node);
        return sb.toString();
    }

    private StringBuilder appNodeData(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node!=null){
            sb.append(node.getData()).append(",");
            node = node.getNext();
        }
        sb.append("]");
        return sb;
    }

    /**
     * 链表头尾和极限
     * @param args
     */
    public static void main(String[] args) {
        /*LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        System.out.println( list.toString());
        Node node = list.deleteByValue(1);
        System.out.println(node);
        list.addFirst(1);
        list.addFirst(2);
        System.out.println(list.toString());
        list.deleteByNode(new Node(1));//删除尾节点
        System.out.println(list.toString());
        list.deleteFirst();
        System.out.println(list.toString());
        list.deleteByNode(new Node(2));//删除头节点
        System.out.println(list.toString());*/

        //链表反转
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(2);
        list.addFirst(4);
        list.addFirst(5);
        System.out.println(list.toString());
        //取出节点做反转
//        Node<Integer> node = list.head.next;
//        Node reverse = list.reverse(node);
//        System.out.println(list.appNodeData(reverse));

        //环的检测
        Node<Integer> node = list.head.next;
        System.out.println(list.haCircle(node));
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addFirst(1);
        list1.addFirst(3);
        Node<Integer> node2 = list1.head.next;
        Node<Integer> newNode = list1.mergeTwoNode(node2, node);
        System.out.println(list.appNodeData(newNode));
    }

    /**
     * 链表反转
     * pre 反转后的头节点
     * current之前的节点（未变更之前 就是每次取出的节点）
     * next 临时变量（临时存放 取出节点的后面的所有节点）
     * 思路：每回取出下一个节点 放做临时变量到next中
     * 将当前节点放到反转后的节点的之前
     * 再将next节点交由current节点
     * @param node
     */
    public Node reverse(Node node){
        Node current = node; Node pre = null;Node next = null;
        while (current!=null){
            next = current.next;
            current.next = pre;//取出的那个放到新链表的头节点
            pre = current;//复位pre为新链表的头节点
            current = next;
        }
        return pre;
    }


    /**
     * 环检测
     * 利用快慢指针判定如果快指针所在节点与慢指针所在节点一致则说明存在环
     */
    public boolean haCircle(Node node){
        if(node==null){
            return false;
        }
        Node fast = node;
        Node slow = node;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    /**
     * 合并有序两个链表
     * 先创建一个节点： 之后哪个节点的数据小 就是当前的下一个节点 最后将未完成的那个链表节点作为新节点的下一个节点
     */
    public Node<T> mergeTwoNode(Node<T> node1,Node<T> node2){
        Node newNode = new Node(0);
        Node returnNode = newNode;
        while (node1!=null&&node2!=null){
            if(node1.getData().compareTo(node2.getData())>0){
                newNode.next = node1;
                newNode = newNode.next;
                node1 = node1.next;
            }else{
                newNode.next = node2;
                newNode = newNode.next;
                node2 =  node2.next;
            }
        }
        if(node1!=null){
            newNode.next = node1;
        }
        if (node2!=null) {
            newNode.next = node2;
        }
        returnNode = returnNode.next;
        return returnNode;
    }


}

