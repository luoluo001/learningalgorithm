package com.lcy.algorithm.greedy.sweets;

import java.util.List;

/**
 * Created by： luochengyue
 * date: 2019/1/15.
 * desc：
 *
 * @version:
 */
public class QSort<T extends Comparable> {

    /**
     * 分区 这里采用最简单的方式去数组中最后一个数据作为分区点
     * @param a 数组
     * @param s 开始索引
     * @param r 结束索引
     * @return
     */
    public int partition(List<T> a, int s, int r){
        Comparable parvalue = (Comparable) a.get(r);
        int i = s,q = s;
        //主要小于等于r的就循环
        T tem = null;
        Comparable c = (Comparable) a.get(i);
        while (i<=r){
            if(((Comparable)a.get(i)).compareTo(parvalue)<0){
                //做下数据交换
                tem = a.get(q);
                a.set(q++,a.get(i));
                a.set(i,tem);
            }
            i++;
        }
        //将分区点的数据与要分区的点的所在位置数据做下交换
        a.set(r,a.get(q));
        a.set(q,(T)parvalue);
        return q;
    }

    /**
     * 快排
     * @param a
     * @param s
     * @param r
     */
    public void quickSort(List<T> a,int s,int r){
        if(s>=r){
            return ;
        }
        int q = partition(a, s, r);
        quickSort(a,s,q-1);
        quickSort(a,q+1,r);
    }

}
