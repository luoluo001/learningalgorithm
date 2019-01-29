package com.lcy.algorithm.backtrack;

/**
 * Created by： luochengyue
 * date: 2019/1/18.
 * desc：0-1问题
 * @version:
 */
public class ZeroOne {
    //以此来作为最大重量的记录
    private Integer maxWeight = Integer.MIN_VALUE;

    /**
     *  0-1问题采用回溯算法
     * @param goods 物品的数组，下标为物品对应的下标值为对应的物品重量的值
     * @param w  不能超过的总重量 如果超过则返回不再递归
     * @param i 轮到第几个物品
     * @param gw 装入的物品总重量
     */
    public void alg(int[] goods,int w,int i,int gw){
        //如果物品已达上限，或者物品都已选择完了则不再继续
        if(gw==w||i==goods.length){
            if(gw>maxWeight){
                maxWeight= gw;
            }
            return ;
        }
        //不放入当前商品
        alg(goods,w,i+1,gw);
        if(gw+goods[i]<=w){
            //放入当前商品
            alg(goods,w,i+1,gw+goods[i]);
        }
    }

    public static void main(String[] args) {
        int[] goods = new int[]{2,2,4,11,2};
        ZeroOne zeroOne = new ZeroOne();
        zeroOne.alg(goods,7,0,0);
        System.out.println(zeroOne.maxWeight);
    }
}
