package com.lcy.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by： luochengyue
 * date: 2018/12/5.
 * desc：背景呢在递归那一章介绍有
 * @version:
 */
public class TakeTheStairs {

    /**
     * 楼梯走法递归
     * @param n
     * @return
     */
    public int fn(int  n){
        //两个终止条件
        if(n==1){return 1;}
        if(n==2){return 2;}
        //公式
        return fn(n-1) + fn(n-2);
    }

    private Map<Integer,Integer> map ;
    public  void initMap(){
        if(map==null){
            synchronized (this){
                if(map==null){
                    map =  new HashMap<>();
                }
            }
        }
    }

    /**
     * 防止重复求值递归
     * @param n
     * @return
     */
    public int fnNew(int  n){
        //两个终止条件
        if(n==1){return 1;}
        if(n==2){return 2;}
        //放置重复调用栈
        if(map.containsKey(n)){
            return map.get(n);
        }
        //公式
        int ret = fnNew(n - 1) + fnNew(n - 2);
        map.put(n,ret);
        return ret;
    }

    public static void main(String[] args) {
        TakeTheStairs stairs  = new TakeTheStairs();
        stairs.initMap();
        long start1 = System.currentTimeMillis();
        int ret1 = stairs.fnNew(100);
        long end1 = System.currentTimeMillis();
        System.out.println("防重复时间花费：" + (end1-start1)+",结果："+ret1);

        long start = System.currentTimeMillis();
        int ret = stairs.fn(100);
        long end = System.currentTimeMillis();
        System.out.println("时间花费：" + (end-start)+",结果："+ret);


    }
}
