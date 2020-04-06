package com.lcy.leetcode.recursion;

/**
 * Created by luo on 2020/4/4.
 *  案例：走楼梯一次能走1或者2，然后比如有9阶台阶那么请问总共有多少种走法
 */
public class RunStairs {
    /**
     * @param n 楼梯总数
     * @return
     */
    public int count(int n){
        //先递归条件
        if(n==1){return 1;}
//        if(n==0){return 1;}//时候当为0的时候也算一种走法，因为这样有点奇怪还要多计算一次所以有点奇怪 干脆有两阶梯的时候为2更好
        if(n==2) return 2;
        return count(n-1) + count(n-2);
    }

    public static void main(String[] args) {
        RunStairs rs = new RunStairs();
        System.out.println(rs.count(1));//边界测试
    }
}
