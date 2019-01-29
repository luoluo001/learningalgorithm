package com.lcy.algorithm.structure.linetable;

import java.util.Arrays;

/**
 * Created by： luochengyue
 * date: 2018/11/19.
 * desc：顺序存储
 * @version:
 */
public class ArrayList<T> implements List<T> {
    /**
     * 以数组的形式去存储
     */
    private Object[] arrays;
    /**
     * 容量
     */
    private Integer capacity = 20;
    /**
     *
     */
    private Integer size = 0;
    public ArrayList(){
        arrays = new Object[capacity];
    }

    public ArrayList(int capacity){
        arrays = new Object[capacity];
        this.capacity = capacity;
    }

    public void add(T a) {
        if(size>=capacity){
            resize();
//            throw  new ArrayIndexOutOfBoundsException("超出限制");
        }
        arrays[size++] = a;
    }

    /**
     * 删除
     * @param loc 所在位置
     * @return
     */
    public T delete(Integer loc) {
        checkDelRange(loc);
        T ele = (T)arrays[loc];
        //删除需要将之后的所有数据往前移动
        for(;loc<size-1;loc++){
            arrays[loc] = arrays[loc+1];
        }
        size--;
        return ele;
    }

    /**
     * 删除
     * @param loc 所在位置
     * @return
     */
    public T find(Integer loc) {
        checkDelRange(loc);
        T ele = (T)arrays[loc];
        //删除需要将之后的所有数据往前移动
        for(;loc<size-1;loc++){
            arrays[loc] = arrays[loc+1];
        }
        size--;
        return ele;
    }



    public void insert(T e, Integer loc) {
        //满了
        if(size==capacity){
            throw new RuntimeException("已经满了");
        }
        checkRange(loc);
        //第一方法执行次数较多
      /*  for(;loc<size-loc;loc++){
            arrays[loc+1] = arrays[loc];
        }*/
   /*     for(int i = size-1;i>=loc;i--){
            arrays[i+1] = arrays[i];
        }*/
        for(int i = size;i>loc;i--){
            arrays[i] = arrays[i-1];
        }
        arrays[loc] = e;
        size++;
    }

    private void checkRange(Integer loc) {
//        if (loc > size || loc < 0)
        if (loc > size || loc < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(loc));
    }

    private void checkDelRange(Integer loc) {
//        if (loc > size || loc < 0)
        if (loc >= size || loc < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(loc));
    }



    public void resize(){
        capacity = capacity*2;
        Object[] temp = arrays;
        arrays = new Object[capacity];
        //O(n)操作进行扩容
        for(int i = 0 ;i<size;i++){
            arrays[i] = temp[i];
        }
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    public void clear() {
        for(int i =0;i<size;i++){
            arrays[i] = null;
        }
        size = 0;
    }

    public Integer getLocation(T e) {
        int i = 0;
        for(;i<size;i++){
            if(arrays[i].equals(e)){
                break;
            }
        }
        return i;
    }

    public Boolean isEmply() {
        return size==0;
    }

    public Integer getLen() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "arrays=" + Arrays.toString(arrays) +
                '}';
    }
}
