package com.lcy.algorithm.sort.linear;

/**
 * Created by： luochengyue
 * date: 2018/12/18.
 * desc：计数排序
 * @version:
 */
public class CountSort {

    /**
     * 计数排序的设计思路：
     * 1，先遍历数组中的数据，获取到最大值k,（首先得保证数据范围比较小 否则就不适用这个排序了，同时这个排序还有个弊端 空间复杂度为O(n))
     * 2.创建一个计数数组 就是桶集合数组
     * 3.遍历数组 在计数数组上出现一次 增加一次计数
     * 4.最后对计数数组做累加
     * 5.创建一个临时数组，与原先的数组大小一致
     * 6.遍历原数组 在计数数组中取值 然后-1作为下标 同时计数数组对应的值--1
     * 7.copy临时数组到原数组上，或者替换掉
     */

    /**
     * 获取数组最大值
     * @param a
     * @return
     */
    public int getMax(int[] a){
        //判断数组的数据量
        if(a.length<1){
            return -1;
        }
        int k = 0;
        for(int i =0;i<a.length;i++){
            if(a[i]>k){
                k = a[i];
            }
        }
        return k ;
    }

    /**
     * 2.创建一个计数数组 就是桶集合数组
     * 3.遍历数组 在计数数组上出现一次 增加一次计数
     * 4.最后对计数数组做累加
     * @param a k
     * @param k 最大值
     * @return
     */
    public int[] getCountArray(int[] a,int k){
        if(k<0){
            return null;
        }
        int[] countArray = new int[k+1];
        for(int i =0;i<a.length;i++){
            countArray[a[i]]++;
        }

        for(int j = 1;j<countArray.length;j++){
            countArray[j] = countArray[j]+countArray[j-1];
        }
        return countArray;
    }

    /**
     * 5.创建一个临时数组，与原先的数组大小一致
     * 6.遍历原数组 在计数数组中取值 然后-1作为下标 同时计数数组对应的值--1
     * 7.copy临时数组到原数组上，或者替换掉
     */
    public int[] copyOrigin(int[] a,int[] countArray){
        if(countArray==null){
            return null;
        }
        int[] temArray = new int[a.length];
        for(int i =0;i<a.length;i++){
            countArray[a[i]]--;
            temArray[countArray[a[i]]] = a[i];
        }
        return temArray;
    }

    public static void main(String[] args) {
        int[] a = new int[]{8,3,4,5};
        CountSort cs = new CountSort();
        int[] countArray = cs.getCountArray(a, cs.getMax(a));
        a = cs.copyOrigin(a,countArray);
        for (int i =0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
    }




}
