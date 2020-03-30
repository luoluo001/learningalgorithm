package com.lcy.algorithm.dynamicplanning.commonsubstring;

/**
 * Created by： luochengyue
 * date: 2019/2/18.
 * desc：最长公共子串对应的动态规划算法
 * @version:
 */
public class DPcommSub {
    /**
     * 两个数组
     */
    private char[] a = "mitcmu".toCharArray();
    private char[] b = ",matcnu".toCharArray();
    private int[][] max_loc;//记录公共子串长度大小的状态数组
    public int dpComSub(){
        max_loc = new int[a.length][b.length];
        //初始化第一列
        for(int i = 0;i<a.length;i++){
            if(a[i]==b[0]){
                max_loc[i][0] = 1;
            }else if(i!=0){
                max_loc[i][0] = max_loc[i-1][0];
            }else {
                max_loc[i][0] = 0;
            }
        }
        //初始化第一行
        for(int j=0;j<b.length;j++){
            if(b[j]==a[0]){
                max_loc[0][j] = 1;
            }else if(j!=0){
                max_loc[0][j] = max_loc[0][j-1];
            }else {
                max_loc[0][j] = 0;
            }
        }
        //填充状态
        for(int i = 1;i<a.length;i++){
            for(int j =1;j<b.length;j++){
                if(a[i]==b[j]){
                    max_loc[i][j] = max(max_loc[i-1][j],max_loc[i][j-1],max_loc[i-1][j-1]+1);
                }else{
                    max_loc[i][j] = max(max_loc[i-1][j],max_loc[i][j-1],max_loc[i-1][j-1]);
                }
            }
        }
        return max_loc[a.length-1][b.length-1];
    }

    private int max(int i, int i1, int i2) {
        int max = i;
        if(max<i1){
            max=i1;
        }
        if(max<i2){
            max= i2;
        }
        return max;
    }

    public static void main(String[] args) {
        DPcommSub dPcommSub = new DPcommSub();
        System.out.println(dPcommSub.dpComSub());
    }

}
