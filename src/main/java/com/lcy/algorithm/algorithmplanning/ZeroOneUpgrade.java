package com.lcy.algorithm.algorithmplanning;

/**
 * Created by： luochengyue
 * date: 2019/1/23.
 * desc：0-1背包升级
 * @version:
 */
public class ZeroOneUpgrade {

    /**
     * 0-1背包使用动态规划来完成
     * @param weight 物品对应商品重量的数组
     * @param values 当前物品的价值数组
     * @param n 商品的数量
     * @param w 商品当前的承受重量
     */
    public int algorithm(int[] weight,int[] values,int n,int w){
        int[][] states = new int[n][w+1];
        //初始化数组 状态n是阶段， w是对应物品的承重
        for(int i =0;i<n;i++){
            for(int j =0;j<w+1;j++){
                states[i][j] = -1;
            }
        }
        //初始化数组的第一阶段
        states[0][0] = 0;
        states[0][weight[0]] = values[0];
        for(int i = 1;i<n;i++){
            //第i阶段的物品不放入
            for(int j = 0;j<=w;j++){
                states[i][j] = states[i-1][j];
            }
            //第i阶段的物品放入到背包中 要考虑到物品放入重量不能超过w 所以j<=w-weight[i]
            for(int j = 0;j<=w-weight[i];j++){
                //判断相同重量下哪个价值更高
                if(states[i][j+weight[i]] <states[i-1][j]+values[i]){
                    states[i][j+weight[i]] = states[i-1][j]+values[i];
                }
            }
        }
        //从最后往前判断找最大值
        int maxV = 0;
        for(int k=w;k>=0;k--){
            if(states[n-1][k]>maxV){
                maxV = states[n-1][k];
            }
        }
        return maxV;

    }

    public static void main(String[] args) {
        int[] weight = {2,2,4,6,3};  // 物品的重量
        int[] value = {3,4,8,9,6}; // 物品的价值
        ZeroOneUpgrade zu = new ZeroOneUpgrade();
        System.out.println(zu.algorithm(weight,value,value.length,4));

    }
}
