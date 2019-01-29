package com.lcy.algorithm.structure.stack;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：
 *
 * @version:
 */
public class StackTest {

    public static void main(String[] args) {
    /*    ArrayStatck<String> statck= new ArrayStatck<>();
        statck.push("a");
        statck.push("b");
        statck.push("c");
        statck.push("d");
        System.out.println(statck);
        System.out.println(statck.pop());
        System.out.println(statck.pop());
        System.out.println(statck.pop());
        System.out.println(statck.pop());
        System.out.println(statck);*/

        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("a");
        linkedStack.push("b");
        linkedStack.push("c");
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());

    }
}
