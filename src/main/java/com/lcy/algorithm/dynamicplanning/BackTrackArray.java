package com.lcy.algorithm.dynamicplanning;

/**
 * Created by： luochengyue
 * date: 2019/1/29.
 * desc： 使用回溯算法完成 二维数组的最短路径
 * @version:
 */
public class BackTrackArray {
    /**
     * 需要一个记录最短距离的一个全局变量
     * 需要传递一个二维数组 这个二维数组就是记录每个格子距离的二维数组
     * 之后每次向右或者向下
     */
    int minValue = Integer.MAX_VALUE;//最小距离

    /**
     *
     * @param w 二维数组
     * @param i 第一维度索引
     * @param j 第二维度索引
     * @param mv minv 当前值
     * @param n  维度长度
     */
    //入口 f(w,0,0,0,mv,n)
    public void f(int[][] w,int i ,int j ,int mv,int n){
        if(i==n&&j==n){
            if(mv+w[i][j]<minValue){
                minValue = mv+w[i][j] ;
                return ;
            }
        }
        //向下
        if(i<n){
            System.out.println(i+":"+j);
            f(w,i+1,j,mv+w[i][j],n);
        }
        //向右
        if(j<n){
            System.out.println(i+":"+j);
            f(w,i,j+1,mv+w[i][j],n);
        }
    }

    public static void main(String[] args) {
        int[][] w = new int[][]{{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
        BackTrackArray ba = new BackTrackArray();
        ba.f(w,0,0,0,3);
        System.out.println(ba.minValue);
    }
}
