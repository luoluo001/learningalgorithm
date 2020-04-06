package com.lcy.algorithm.sort.two;

/**
 * Created by luo on 2020/4/6.
 * 二刷 冒泡排序
 */
public class BubblingSort {
    /**
     * 算法分析：顾名思义就是每次将数据 冒一次泡排一次数据
     * 所有数据都冒泡了就是有序了
     * 每次比较数据 如果数据较大则后移 那么到最后的时候每次会将最大的那条数据放到最后
     */
    public void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            //array.length-i 就是当前要排出那个最大值的数据
            boolean flag = false;
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    int tem = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tem;
                    flag = true;
                }
            }
            if(!flag){
                break;//如果一遍都木有交换数据说明这里面的数据都是有序的 没有必要继续遍历寻找冒泡的数据
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,3,2,1,4};
        BubblingSort bs = new BubblingSort();
        bs.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
