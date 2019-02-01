package com.lcy.algorithm.dynamicplanning;

/**
 * Created by： luochengyue
 * date: 2019/1/29.
 * desc：状态转移表法
 * @version:
 */
public class StateTransferTable {
    /**
     * 最短距离
     * @param dist
     * @param w
     */
    public int minDist(int[][] dist ,int[][] w,int n){
        dist[0][0] = w[0][0];
        //初始化第一行
        for(int j = 1;j<n ;j++ ){
            dist[0][j] = dist[0][j-1]+w[0][j];
        }
        //第一列
        for(int i = 1;i<n;i++){
            dist[i][0] = dist[0][i-1]+w[i][0];
        }
        //按递推关系往后填充状态
        for(int i = 1;i<n;i++){
            for(int j = 1;j<n;j++){
                dist[i][j] = w[i][j]+ min(dist[i-1][j],dist[i][j-1]);
            }
        }
        return dist[n-1][n-1];
    }

    public int min(int v1 ,int v2){
        if(v1>v2){
            return v2;
        }
        return v1;
    }

    public static void main(String[] args) {
        int[][] w = new int[][]{{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
        StateTransferTable ba = new StateTransferTable();
        int[][] dist = new int[4][4];
        System.out.println(ba.minDist(dist,w,4));
    }
}
