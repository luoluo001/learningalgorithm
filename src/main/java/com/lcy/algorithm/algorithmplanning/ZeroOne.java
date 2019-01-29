package com.lcy.algorithm.algorithmplanning;

/**
 * Created by： luochengyue
 * date: 2019/1/22.
 * desc：0-1背包 使用动态规划来写
 * @version:
 */
public class ZeroOne {

    /**
     * 0-1背包使用动态规划来完成
     * @param goods 商品重量 下标为编号
     * @param i 当前已经在第i个商品进行决策
     * @param n 商品的数量
     * @param cw 商品当前的承受重量
     */
    int w = 9;// 背包的最大承受重量
    public int algorithm(int[] goods,int n){
        //第一阶段的决策是我们进行初始化的，之后每个阶段的决策都是基于上一个阶段的决策结果来推导
        boolean[][] stats = new boolean[n][w+1];//二维数组作为状态记录，其中n表示第几阶段 w+1代表着当前最大索引是w就是所能达到的重量
        int i;
        stats[0][0] = true;//第一阶段需要进行初始化
        stats[0][goods[0]] = true;
        for( i=1;i<goods.length;i++){
            for(int j =0;j<=w;j++){//表示第i个商品不放入背包
                if(stats[i-1][j]){
                    stats[i][j] = true;
                }
            }
            for(int j =0;j<=w-goods[i];j++){//表示放入商品
                if(stats[i-1][j]){
                    stats[i][j+goods[i]]= true;
                }
            }
            //经上面两步 如果有状态一致的在第i层就会合并 由上方可以看出，每下一层的状态都包含上层的所有状态并且增加了上一层如果放入当前层物品之后的所有状态
        }
        //从最后往前 如果第i层的第k个满足true条件表示，当前状态为第i层承重为k kg的最大承重就是k
        for(int k=w;k>=0;k--){
            if(stats[n-1][k]){
                return k;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] goods = new int[]{2,2,4,11,2};
        ZeroOne zeroOne = new ZeroOne();
        zeroOne.algorithm(goods,goods.length);
    }

}
