package com.lcy.algorithm.sort;

/**
 * Created by： luochengyue
 * date: 2018/12/17.
 * desc：归并排序
 * @version:
 */
public class MergeSort {
    /**
     * 归并排序采用的思想是分治思想，具体的编程手段是递归的形式
     * 所以需要归纳出递推公式并且分析终止条件
     * 将数组拆开 两份数组 分而治之进行排序之后再将两份数组进行合并 mergeSort(a,0,f) = merge(mergeSort(a,0,q),mergeSort(a,q+1,f))
     * 其中 0,f是整个数组，将整个数组拆分成两个子问题  的排序 mergeSort(0,q) mergeSort(q+1,f) 之后再将两个排完序的数组进行合并，就完成排序了
     * 这样整个数组就都有序了
     * 终止条件是 起始索引要小于等于 终止索引 s >= f
     * @param a 数组
     * @param s start 索引
     * @param f finsh 终止索引
     */
    public void mergeSort(int[] a,int s,int f){
        //终止条件
        if(s>=f){return ;}
        int q = ((f-s)>>1) + s;
        mergeSort(a,s,q);
        mergeSort(a,q+1,f);
        //对两个数组拆分排序后进行合并
        merge(a,s,q,f);
    }

    /**
     * 合并就是两个数组 谁小谁先放进临时数组中，之后剩余的数组将拷贝到临时数组
     * 最后将临时数组进行数据拷贝，拷贝到原先的数组中
     * @param a 数组
     * @param s 开始
     * @param q 区分数组的中间索引
     * @param f 结束索引
     */
    public void merge(int[] a,int s,int q,int f){
        //创建临时数组
        int[] tem = new int[f-s+1];
        int j = q+1;
        int i = s;
        int k = 0;
        //谁小谁先进临时数组
        while (i<=q&&j<=f){
            if(a[i]<=a[j]){
                tem[k++] = a[i++];
            }else{
                tem[k++] = a[j++];
            }
        }
        //判断数组是否执行完了
        int start = i;;int end = q;
        if(j<=f){
            start = j;
            end = f;
        }
        while (start<=end){
            tem[k++] = a[start++];
        }

        //数据搬移到数组a中
        for(j = 0 ;j<tem.length;j++){
            a[s+j] = tem[j];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,6,1,2,8,9};
        MergeSort ms = new MergeSort();
        ms.mergeSort(a,0,a.length-1);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
    }
}
