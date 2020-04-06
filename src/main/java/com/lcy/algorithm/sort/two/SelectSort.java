package com.lcy.algorithm.sort.two;

/**
 * Created by luo on 2020/4/6.
 * 选择排序：将数据区拆分成两段，一个是已排序区，一个未排序区，
 * 然后每次从已排序区选择最小的数据和当前的所在位置的下表进行交换
 *
 */
public class SelectSort {

    public void sort(int[] a){
        //外层已排序区，在里层未排序区找一个最小的数据插入到外层最后一个数据
        for (int i = 0; i < a.length; i++) {
            //需要排序的区域的位置
            int minInd = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j]<a[minInd]){
                    minInd = j;
                }
            }
            if(minInd!=i){
                int tmp = a[minInd];
                a[minInd] = a[i];
                a[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,3,2,1,4};
        SelectSort ss  = new SelectSort();
        ss.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
