package com.lcy.algorithm.structure.stack;

import com.lcy.algorithm.structure.linetable.ArrayList;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：首先分析下栈结构的抽象数据模型：都是栈顶操作
 * 这里用的是顺序存储的栈结构
 * @version:
 */
public class ArrayStatck<E> implements Stack<E> {
    private Integer cap;//容量大小

    private int size;//当前的存储大小

    private Object[] arrays;

    public ArrayStatck(int cap){
        this.cap = cap;
        arrays = new Object[cap];
        size =0;
    }
    public ArrayStatck(){
        this.cap = 20;
        arrays = new Object[cap];
        size = 0;
    }

    /**
     * 既然以顺序存储的话 则需要以数组的最后的一位作为入栈和出栈的操作 符合后进先出的规则
     * @param data
     */
    @Override
    public void push(E data) {
        if(size>=cap){
            resize();
        }
        arrays[size++] = data;
    }

    private synchronized void resize() {
        if(size>=cap){
            cap = 2*cap;
            Object[] tem = arrays;
            arrays = new Object[cap];
            for(int i =0;i<size;i++){
                arrays[i] = tem[i];
            }
        }
    }

    @Override
    public E pop() {
        if(isEmpty()){
           throw new RuntimeException("当前栈不存在数据");
        }
        size--;
        Object tem = arrays[size];
        return (E)tem;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0;i<size;i++){
            sb.append(arrays[i]);
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
