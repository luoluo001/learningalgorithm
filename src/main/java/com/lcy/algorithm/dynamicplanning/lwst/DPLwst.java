package com.lcy.algorithm.dynamicplanning.lwst;

/**
 * Created by： luochengyue
 * date: 2019/2/18.
 * desc：动态规划莱文斯坦对应的代码
 * @version:
 */
public class DPLwst {
    /**
     * 两个数组
     */
    private char[] a = "mitcmu".toCharArray();
    private char[] b = ",matcnu".toCharArray();
    private int[][] min_dist;
    public int dpLwst(){
        min_dist = new int[a.length][b.length];
        //初始化第0行 第0列
        for(int i =0;i<a.length;i++){
            if(a[i] == b[0]){
                min_dist[i][0] = i;
            }else if(i!=0){
                min_dist[i][0] = min_dist[i-1][0]+1;
            }else{
                min_dist[i][0] = 1;
            }
        }

        for(int j =0;j<b.length;j++){
            if(b[j] == a[0]){
                min_dist[0][j] = j;
            }else if(j!=0){
                min_dist[0][j] = min_dist[0][j-1]+1;
            }else{
                min_dist[0][j] = 1;
            }
        }
        //之后根据条件不同来完成动态规划的递推每行递推
        for(int i = 1;i<a.length;i++){
            for(int j = 1;j<b.length;j++){
                if(a[i]==b[j]){
                    //通过递推公式获取当前的状态值
                    min_dist[i][j] = min(min_dist[i-1][j-1],min_dist[i-1][j]+1,min_dist[i][j-1]+1);
                }else{
                    min_dist[i][j] = min(min_dist[i-1][j-1]+1,min_dist[i-1][j]+1,min_dist[i][j-1]+1);
                }
            }
        }
        return min_dist[a.length-1][b.length-1];
    }

    private int min(int i, int i1, int i2) {
        int min = i;
        if(min>i1){
            min = i1;
        }
        if(min>i2){
            min = i2;
        }
        return min;
    }

    public static void main(String[] args) {
        DPLwst dpLwst = new DPLwst();
        System.out.println(dpLwst.dpLwst());
    }
}
