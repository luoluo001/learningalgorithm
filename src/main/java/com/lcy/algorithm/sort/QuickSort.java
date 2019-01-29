package com.lcy.algorithm.sort;

import com.lcy.algorithm.structure.linetable.ArrayList;

import java.util.BitSet;

/**
 * Created by： luochengyue
 * date: 2018/12/17.
 * desc：分治思想的另一种排序快排：属于原地排序（空间复杂度为O(1)）
 * 快排是由上而下的 选择分区点 分区点左侧小于该点 分区点右侧大于改点，当数据数组区间只有1个的时候就是无法再分区 排序也结束了
 * @version:
 */
public class QuickSort {

    /**
     * 分区 这里采用最简单的方式去数组中最后一个数据作为分区点
     * @param a 数组
     * @param s 开始索引
     * @param r 结束索引
     * @return
     */
    public int partition(int[] a,int s,int r){
        int parvalue = a[r];
        int i = s,q = s;
        //主要小于等于r的就循环
        int tem = a[i];
        while (i<=r){
            if(a[i]<parvalue){
                //做下数据交换
                tem = a[q];
                a[q++] = a[i];
                a[i] = tem;
            }
            i++;
        }
        //将分区点的数据与要分区的点的所在位置数据做下交换
        a[r] = a[q];
        a[q] = parvalue;
        return q;
    }

    /**
     * 快排
     * @param a
     * @param s
     * @param r
     */
    public void quickSort(int[] a,int s,int r){
        if(s>=r){
            return ;
        }
        int q = partition(a, s, r);
        quickSort(a,s,q-1);
        quickSort(a,q+1,r);
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,3,4,5,6,1,2,8,9};
        QuickSort qs = new QuickSort();
        /**
         * 快排测试
         */
        qs.quickSort(a,0,a.length-1);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
        //测试第k大的数据是多少
//        System.out.println(qs.search(a,0,a.length-1,4));
    }


    /**
     * 分区 按大到小排序
     * @param a 数组
     * @param s 开始索引
     * @param r 结束索引
     * @return
     */
    public int partitionTwo(int[] a,int s,int r){
        int parvalue = a[r];
        int i = s,q = s;
        //主要小于等于r的就循环
        int tem = a[i];
        while (i<=r){
            //如果大则提前
            if(a[i]>parvalue){
                //做下数据交换
                tem = a[q];
                a[q++] = a[i];
                a[i] = tem;
            }
            i++;
        }
        //将分区点的数据与要分区的点的所在位置数据做下交换
        a[r] = a[q];
        a[q] = parvalue;
        return q;
    }



    /**
     * 查找第k大元素
     * @param a
     * @param s
     * @param r
     * @param k 第几大
     */
    public int search(int[] a,int s,int r,int k){
        if(s>=r){
            return -1;
        }
        int q = partitionTwo(a, s, r);
        //终止条件
        if(q+1== k){
            return a[q];
        }else if(k>q+1){
            return search(a,q+1,r,k);
        }else{
            return search(a,s,q-1,k);
        }
    }
}
