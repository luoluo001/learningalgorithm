package com.lcy.algorithm.structure.linetable;

/**
 * Created by： luochengyue
 * date: 2018/11/19.
 * desc：主测试类
 * @version:
 */
public class MainTest {

    public static void main(String[] args) {
//          List<String> list = new ArrayList<String>();
          LinkedList<String> list = new LinkedList<>();
          list.add("a");
          list.add("b");
          list.add("c");
//          list.add("d");
//          list.add("e");
//          System.out.println(list.delete(4));
          //测试反转
          list.reverse2();
          System.out.println(list);
//          //测试中环
//          LinkedList<String>.Node<String> node = list.findByLoc(4);
//          LinkedList<String>.Node<String> secoudNode = list.findByLoc(1);
//          node.setNext(secoudNode);
//          System.out.println(list.hasLoopV1());

          //        list.delete(20);
//        list.insert("g",2);
//        LinkedList<String> list = new LinkedList<String>();
//        list.add("a");
//        list.add("b");
//        System.out.println(list);
////        list.delete(3);
////        list.deleteFirst();
//        System.out.println(list);
          //测试查找中间节点
          System.out.println(list.findMdNode().getData());

    }
}
