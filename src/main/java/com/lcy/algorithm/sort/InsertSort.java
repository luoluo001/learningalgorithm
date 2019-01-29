package com.lcy.algorithm.sort;

/**
 * Created by： luochengyue
 * date: 2018/12/7.
 * desc：插入排序
 * @version:
 */
public class InsertSort {
    /**
     * 插入排序
     * 插入排序是以第一个作为初始值的已排序数组，属于原地排序
     * 每次后面取一个值，在已排序的数组中找位置插入
     * @param a
     */
    public static void insertSort(int[] a) {
        //如果为空的啥也不做
        if(a.length==0){
            return ;
        }
        int value = 0;
        int j;
        //循环插入
        for (int i =1;i<a.length;i++){
            value = a[i];
            //跟已排序部分的数组做对比，插入对应的位置
            for(j = i-1;j>=0;j--){
                if(a[j]>value){
                    //大于则右移
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,3,4,5,1,2};
        for(int i =0;i<array.length;i++){
            System.out.print(array[i]);
        }
        System.out.println();
        insertSort(array);
        for(int i =0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }
}
