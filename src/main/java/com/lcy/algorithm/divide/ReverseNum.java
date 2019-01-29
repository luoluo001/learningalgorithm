package com.lcy.algorithm.divide;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by： luochengyue
 * date: 2019/1/17.
 * desc：逆序度计算
 * @version:
 */
public class ReverseNum {

    /**
     * 逆序度数量计算
     * @param a 数组
     * @param s 开始索引
     * @param r 结束索引
     */
    public void mergeSortNum(int[] a,int s,int r){
        /**
         * 边界条件
         */
        if(s>=r){
            return ;
        }
        int q = ((r-s)>>1) + s;
        mergeSortNum(a,s,q);
        mergeSortNum(a,q+1,r);
        merge(a,s,q,r);
    }
    private int rev = 0;
    /**
     * 合并
     * @param a 数组
     * @param s 开始索引
     * @param q 索引分割点
     * @param r 结束索引
     */
    private void merge(int[] a, int s,int q, int r) {
        int[] tem = new int[r-s+1];
        int k=0;
        int i = s,j = q+1;
        //当数组1小于等于分界点，数组2小于等于结束点的时候讲大的数据放入到临时数组中
        while (i<=q&&j<=r){
            //数组a小于数组b中的则将数组a搬移到临时数组中 否则相反并计数逆序度
            if(a[i]<=a[j]){
                tem[k++] = a[i++];
            }else{
                tem[k++] = a[j++];
                rev += q-i+1;
            }
        }
        //上面循环结束了说明有一个条件没有满足，但是数组还没有完全迁移完
        int fs = 0,fr = 0;
        if(i<=q){
            fs = i;
            fr = q;
        }
        if(j<=r){
            fs = j;
            fr = r;
        }
        for(;fs<=fr;fs++){
            tem[k++] = a[fs];
        }
        //归并后的将数据回填回原数组
        for (int m=0;m<tem.length;m++){
            a[s+m] = tem[m];
        }
    }

    public static void main(String[] args) {
//        int[] a = new int[]{3,2,1};
//        ReverseNum rn = new ReverseNum();
//        rn.mergeSortNum(a,0,a.length-1);
//        for (int i =0 ;i<a.length;i++){
//            System.out.print(a[i]);
//        }
//        System.out.println("=================");
//        System.out.println(rn.rev);
        System.out.println((int) 1e20);
    }
}
