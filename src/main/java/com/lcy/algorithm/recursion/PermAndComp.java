package com.lcy.algorithm.recursion;

/**
 * Created by： luochengyue
 * date: 2018/12/24.
 * desc：排列组合
 * @version:
 */
public class PermAndComp {
    /**
     * a = [1,2,3];
     *  printPerm(a,3,3); 入口的时候
     *  f(n) = 最后一位* f(n-1) + 倒数第二位确定数字 * f(n-1)+。。。。+ 第一位确定*f(n-1)
     * @param a 数组
     * @param n 数组长度
     * @param k 当前剩余的多少种排列方式
     */
    public void printPerm(int[] a,int n,int k){
        //说明 位数都确定了就可以输出了
        if(k==1){
            for (int i=0;i<n;i++){
                System.out.print(a[i]+",");
            }
            System.out.println();
        }
        int tem = 0;
        for(int i =0;i<k;i++){
            //确定谁为最后一位
            tem = a[i];
            a[i] = a[k-1];
            a[k-1] = tem;
            printPerm(a,n,k-1);
            //需要复位下 为下一位作为最后一位做准备
            tem = a[i];
            a[i] = a[k-1];
            a[k-1] = tem;
        }
    }
}
