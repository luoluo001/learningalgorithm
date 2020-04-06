package com.lcy.algorithm.sort.two;

/**
 * Created by luo on 2020/4/6.
 * 分析：插入和选择 插入到哪 选择到数据放到哪 其实都是放到已排序区 即将要排序的那个索引位置中
 * 数据分区：已排序区，未排序区， 每次从未排序区中找数据 到已排序区中找到位置去插入
 */
public class InsertSort {
    public void sort(int[] a){
        //外层表示未排序区 选择拿数据区里层已排序区插入
        for (int i = 1; i < a.length; i++) {
            //从1开始未排序区选择一个数据
            int tmp = a[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                //小于则要插入到前面 数据需要后移
                if(tmp<a[j]){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,3,2,1,4};
        InsertSort bs = new InsertSort();
        bs.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
