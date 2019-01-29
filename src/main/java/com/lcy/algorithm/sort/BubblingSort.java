package com.lcy.algorithm.sort;

/**
 * Created by： luochengyue
 * date: 2018/12/7.
 * desc：冒泡排序
 * @version:
 */
public class BubblingSort {
    /**
     * 这里讲原理的话，只需要把数组的部分给
     * 冒泡排序每回比较如果出现大的就往后移动
     * 设定flag 如果没有交换则跳出循环
     * @param a  数组
     */
    public static void bubbling(int[] a){
        int tem;
        for (int i =0 ;i < a.length;i++){
            boolean flag = false;
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j] > a[j+1]){
                    //交换一下
                    tem = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tem;
                    flag = true;
                }
            }
            //如果没有交换则跳出循环冒泡
            if(!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,1,2,6};
        for(int i =0;i<array.length;i++){
            System.out.print(array[i]);
        }
        System.out.println();
        bubbling(array);
        for(int i =0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }
}
