package com.lcy.algorithm.anacomplex;

import org.junit.Test;

/**
 * Created by： luochengyue
 * date: 2018/11/6.
 * desc：复杂度分析
 * @version:
 */
public class TimeComploxAnaly {

    @Test
    public void ncomplex(){

    }

    /**
     * 前提条件：我们假设每次执行的时间都是unit_time
     * fn = （2n+2）*unit_time
     * 所有执行的总时间 T(n)  所有行执行的总次数  f(n)=2n+2
     * @param n
     * @return
     */
    public static int o_n_complexity(int n){
        int i = 0;      //执行1次
        int sum = 0;    //执行1次
        for(;i<n;i++){  //执行n次
            sum +=sum;  //执行n次
        }
        return sum;
    }

    /**
     * 内部for循环从j=i开始 这里其实也是分析基础执行次数
     * @param n O（n）第二种复杂度
     * @return
     */
    public static int n_2Complexity(int n){
        int sum = 0;
        int j = 0;
        for(int i =0;i<n;i++){

            for(j=i;j<n;j++){
                sum+=j; //分析方式1：i从0到n的概率都是 1/n  n-i (内部执行) 当为0的时候循环n次当为n-1的时候为1次
                // 1/n + 1/n*2 +...+n/n  然后再乘以外部循环的n次 n2/2 + n/2 就是O(n2)
                //分析方式i2:抛开内部执行的次数的概率,就计算总执行次数  0-n 总次数为 当i=0 n次 之后依次递减 n +n -1 + n-2 + ...+1 跟以上的计算结果一直
            }
        }
        return sum;
    }

}
