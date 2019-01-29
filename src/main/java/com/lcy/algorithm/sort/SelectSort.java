package com.lcy.algorithm.sort;

/**
 * Created by： luochengyue
 * date: 2018/12/7.
 * desc：选择排序
 * @version:
 */
public class SelectSort {

    //选择排序是从后面所有的数据做比较 把最小的按顺序替换比如
    public static void selectSort(int[] a){
        int temInd = 0;
        int temValue = 0;
        //外层循环
        for(int i =0;i<a.length;i++){
            temInd = i;
            temValue = a[i];
            //从当前位置的后一位开始比较 如果发现了最小的数值则进行交换
            for (int j =i+1;j<a.length;j++){
                if(temValue>a[j]){
                    //记录索引 记录对应的值 后续需要用于比较交换
                    temInd = j;
                    temValue = a[j];
                }
            }
            if(temInd!=i){
                //做下交换
                a[temInd] = a[i];
                a[i] = temValue;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,3,4,5,1,2};
        for(int i =0;i<array.length;i++){
            System.out.print(array[i]);
        }
        System.out.println();
        selectSort(array);
        for(int i =0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }
}
