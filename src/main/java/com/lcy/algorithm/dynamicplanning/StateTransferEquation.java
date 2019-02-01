package com.lcy.algorithm.dynamicplanning;

/**
 * Created by： luochengyue
 * date: 2019/1/29.
 * desc：状态转移方程
 * @version:
 */
public class StateTransferEquation {
    /**
     *
     * @param w 二维数组
     * @param distMem 距离及备忘录
     * @param i 行索引
     * @param j 列索引
     */
    public int minDist(int[][] w,int[][] distMem,int i,int j){
        //递归必须要有终止条件
        if(j==0&&i==0){
            return w[i][j];
        }
        //之前已计算过防止重复递归
        if(distMem[i][j]!=0){
            return distMem[i][j];
        }
        int leftDist = Integer.MAX_VALUE ;
        if(i>0){
            leftDist = minDist(w,distMem,i-1,j);
        }
        int upDist= Integer.MAX_VALUE;
        if(j>0){
            upDist = minDist(w,distMem,i,j-1);
        }
        int minDist = w[i][j] + min(leftDist,upDist);
        distMem[i][j] = minDist;//做下记录
        return distMem[i][j];

    }

    public int min(int v1 ,int v2){
        if(v1>v2){
            return v2;
        }
        return v1;
    }

    public static void main(String[] args) {
        int[][] w = new int[][]{{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
        StateTransferEquation ba = new StateTransferEquation();
        int[][] dist = new int[4][4];
        System.out.println(ba.minDist(w,dist,4-1,4-1));
    }
}
